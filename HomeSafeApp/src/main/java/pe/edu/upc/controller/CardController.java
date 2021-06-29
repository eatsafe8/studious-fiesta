package pe.edu.upc.controller;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.entities.Card;
import pe.edu.upc.service.ICardService;
import pe.edu.upc.service.IOwnerService;

@Controller
@RequestMapping("/cards")
public class CardController {

	@Autowired
	private ICardService cS;

	@Autowired
	private IOwnerService oS;
	@Secured("ROLE_ADMIN")
	@GetMapping("/new")
	public String newCard(Model model) {
		model.addAttribute("card", new Card());
		model.addAttribute("listaDuenos", oS.list());
		return "card/card";
	}
	@Secured("ROLE_ADMIN")
	@PostMapping("/save")
	public String saveCard(@Valid @ModelAttribute(value = "card") Card card, BindingResult result, Model model,
			SessionStatus status) throws Exception {
		if (result.hasErrors()) {
			model.addAttribute("listaDuenos", oS.list());
			return "card/card";
		} else {
			cS.insert(card);
			model.addAttribute("mensaje", "Se registró la tarjeta exitosamente");
			status.setComplete();
			return "redirect:/cards/list";
		}
	}
	@Secured("ROLE_ADMIN")
	@GetMapping("/list")
	public String listCard(Model model) {
		try {
			model.addAttribute("listaTarjetas", cS.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "card/listCard";
	}
	@Secured("ROLE_ADMIN")
	@RequestMapping("/delete")
	public String deleteCard(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				cS.delete(id);
				model.put("mensaje", "La tarjeta se eliminó exitosamente");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrió un error");
		}
		return "redirect:/cards/list";
	}
	@Secured("ROLE_ADMIN")
	@GetMapping("/detalle/{id}")
	public String viewTarjet(@PathVariable(value = "id") int id, Model model) {
		try {
			Optional<Card> card = cS.listarID(id);
			model.addAttribute("listaDuenos", oS.list());
			if(!card.isPresent()) {
				model.addAttribute("mensaje","Tarjeta no existe");
				return "redirect:/cards/list";
			}
			else {
				model.addAttribute("card",card.get());
				return "card/updateCard";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "card/updateCard";
	}
}
