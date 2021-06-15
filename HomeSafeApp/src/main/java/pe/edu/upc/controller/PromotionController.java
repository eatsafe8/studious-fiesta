package pe.edu.upc.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.entities.Promotion;
import pe.edu.upc.service.IPromotionService;
import pe.edu.upc.service.IRestaurantService;

@Controller
@RequestMapping("/promotions")
public class PromotionController {
	@Autowired
	private IPromotionService pService;
	@Autowired
	private IRestaurantService rService;

	@GetMapping("/new")
	public String newPromotion(Model model) {
		model.addAttribute("promotion", new Promotion());
		model.addAttribute("listaRestaurantes", rService.list());
		return "promotion/promotion";
	}

	// valid permite visualizar la validacion de @Size, @Email, etc...
	@PostMapping("/save")
	public String savePromotion(@Valid @ModelAttribute(value = "promotion") Promotion promotion, BindingResult result,
			Model model, SessionStatus status) throws Exception {
		if (result.hasErrors()) {
			return "promotion/promotion";
		} else {
			pService.insert(promotion);
			model.addAttribute("mensaje", "Se realizó bien!");
			status.setComplete();
			return "redirect:/promotions/list";
		}
	}

	@GetMapping("/list")
	public String listPromotion(Model model) {
		try {
			model.addAttribute("listaPromociones", pService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			// TODO: handle exception
		}
		return "promotion/listPromotion";
	}

	// para editar o modificar es request pero solo lectura se usa get?
	@RequestMapping("/delete")
	public String deletePromotion(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				pService.delete(id);
				model.put("mensaje", "Se eliminó correctamente!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrió un error");
			// TODO: handle exception
		}
		return "redirect:/promotions/list";
	}
}
