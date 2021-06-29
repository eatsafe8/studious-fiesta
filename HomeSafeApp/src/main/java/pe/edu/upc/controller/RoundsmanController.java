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

import pe.edu.upc.entities.Roundsman;
import pe.edu.upc.service.IRoundsmanService;

@Controller
@RequestMapping("/roundsmans")
public class RoundsmanController {

	@Autowired
	private IRoundsmanService rs;
	@Secured("ROLE_ADMIN")
	@GetMapping("/new")
	public String newRoundsman(Model model) {
		model.addAttribute("roundsman", new Roundsman());
		return "roundsman/roundsman";
	}
	@Secured("ROLE_ADMIN")
	@PostMapping("/save")
	public String saveRoundsman(@Valid @ModelAttribute(value = "roundsman") Roundsman roundsman, BindingResult result,
			Model model, SessionStatus status) throws Exception {
		if (result.hasErrors()) {
			return "roundsman/roundsman";
		} else {
			rs.insert(roundsman);
			model.addAttribute("mensaje", "Se realizó bien!!");
			status.setComplete();
			return "redirect:/roundsmans/list";
		}
	}
	@Secured("ROLE_ADMIN")
	@GetMapping("/list")
	public String listRoundsman(Model model) {
		try {
			model.addAttribute("listaRepartidores", rs.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "roundsman/listRoundsman";
	}
	@Secured("ROLE_ADMIN")
	@RequestMapping("/delete")
	public String deleteRoundsman(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if(id!=null && id>0) {
				rs.delete(id);
				model.put("mensaje", "Se eliminó correctamente!!");
			}		
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrió un error");
		}
		return "redirect:/roundsmans/list";
	}
	@Secured("ROLE_ADMIN")
	@GetMapping("/detalle/{id}")
	public String viewRoundsman(@PathVariable(value = "id") int id, Model model) {
		try {
			Optional<Roundsman> roundsman = rs.listarID(id);
			if(!roundsman.isPresent()) {
				model.addAttribute("mensaje","Repartidor no existe");
				return "redirect:/roundsmans/list";
			}
			else {
				model.addAttribute("roundsman",roundsman.get());
				return "roundsman/updateRoundsman";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "roundsman/updateRoundsman";
	}
	@Secured("ROLE_ADMIN")
	@RequestMapping("/reporte4")
	public String DeliveriesXRoundsman(Map<String, Object> model) {
		model.put("listDeliveriesXRoundsman", rs.DeliveriesXRoundsman());
		return "reports/DeliveriesXRoundsman";
	}
}
