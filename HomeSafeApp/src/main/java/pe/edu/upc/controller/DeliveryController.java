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

import pe.edu.upc.entities.Delivery;
import pe.edu.upc.service.IDeliveryService;
import pe.edu.upc.service.IOrderService;
import pe.edu.upc.service.IRoundsmanService;

@Controller
@RequestMapping("/deliveries")
public class DeliveryController {

	
	@Autowired
	private IDeliveryService DS;
	
	@Autowired
	private IOrderService os;
	
	@Autowired
	private IRoundsmanService rs;
	@Secured("ROLE_ADMIN")
	@GetMapping("/new")
	public String newDelivery(Model model) {
		model.addAttribute("delivery", new Delivery());
		model.addAttribute("listaOrdenes", os.list());
		model.addAttribute("listaRepartidores", rs.list());
		return "delivery/delivery";
	}
	@Secured("ROLE_ADMIN")
	@PostMapping("/save")
	public String saveDelivery(@Valid @ModelAttribute(value = "delivery") Delivery delivery, BindingResult result,
			Model model, SessionStatus status) throws Exception {
		if (result.hasErrors()) {
			model.addAttribute("listaOrdenes", os.list());
			model.addAttribute("listaRepartidores", rs.list());
			return "delivery/delivery";
		} else {
			DS.insert(delivery);
			model.addAttribute("mensaje", "Se realizó bien!!");
			status.setComplete();
			return "redirect:/deliveries/list";
		}
	}
	@Secured("ROLE_ADMIN")
	@GetMapping("/list")
	public String listDelivery(Model model) {
		try {
			model.addAttribute("listaEntregas", DS.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "delivery/listDelivery";
	}
	@Secured("ROLE_ADMIN")
	@RequestMapping("/delete")
	public String deleteDelivery(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if(id!=null && id>0) {
				DS.delete(id);
				model.put("mensaje", "Se eliminó correctamente!!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrió un error");
		}
		return "redirect:/deliveries/list";
	}
	@Secured("ROLE_ADMIN")
	@GetMapping("/detalle/{id}")
	public String viewOrder(@PathVariable(value = "id") int id, Model model) {
		try {
			Optional<Delivery> delivery = DS.listarID(id);
			model.addAttribute("listaOrdenes", os.list());
			model.addAttribute("listaRepartidores", rs.list());
			if(!delivery.isPresent()) {
				model.addAttribute("mensaje","Delivery no existe");
				return "redirect:/deliveries/list";
			}
			else {
				model.addAttribute("delivery",delivery.get());
				return "delivery/updateDelivery";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "delivery/updateDelivery";
	}
}
