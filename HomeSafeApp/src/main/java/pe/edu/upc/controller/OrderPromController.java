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

import pe.edu.upc.entities.OrderProm;
import pe.edu.upc.service.IOrderPromService;
import pe.edu.upc.service.IOrderService;
import pe.edu.upc.service.IPromotionService;

@Controller
@RequestMapping("/orderProms")
public class OrderPromController {

	@Autowired
	private IOrderPromService OPS;
	
	@Autowired
	private IOrderService os;
	
	@Autowired
	private IPromotionService ps;
	@Secured("ROLE_ADMIN")
	@GetMapping("/new")
	public String newOrderProm(Model model) {
		model.addAttribute("orderProm", new OrderProm());
		model.addAttribute("listaOrdenes", os.list());
		model.addAttribute("listaPromociones", ps.list());
		return "orderProm/orderProm";
	}
	@Secured("ROLE_ADMIN")
	@PostMapping("/save")
	public String saveOrderProm(@Valid @ModelAttribute(value = "orderProm") OrderProm orderProm, BindingResult result,
			Model model, SessionStatus status) throws Exception {
		if (result.hasErrors()) {
			model.addAttribute("listaOrdenes", os.list());
			model.addAttribute("listaPromociones", ps.list());
			return "orderProm/orderProm";
		} else {
			OPS.insert(orderProm);
			model.addAttribute("mensaje", "Se realizó bien!!");
			status.setComplete();
			return "redirect:/orderProms/list";
		}
	}
	@Secured("ROLE_ADMIN")
	@GetMapping("/list")
	public String listOrderProm(Model model) {
		try {
			model.addAttribute("listaOrdenPromocion", OPS.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "orderProm/listOrderProm";
	}
	@Secured("ROLE_ADMIN")
	@RequestMapping("/delete")
	public String deleteOrderProm(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if(id!=null && id>0) {
				OPS.delete(id);
				model.put("mensaje", "Se eliminó correctamente!!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrió un error");
		}
		return "redirect:/orderProms/list";
	}
	@Secured("ROLE_ADMIN")
	@GetMapping("/detalle/{id}")
	public String viewOrderProm(@PathVariable(value = "id") int id, Model model) {
		try {
			Optional<OrderProm> orderprom = OPS.listarID(id);
			model.addAttribute("listaOrdenes", os.list());
			model.addAttribute("listaPromociones", ps.list());
			if(!orderprom.isPresent()) {
				model.addAttribute("mensaje","Orden de Promocion no existe");
				return "redirect:/orderProms/list";
			}
			else {
				model.addAttribute("orderProm",orderprom.get());
				return "orderProm/updateOrderProm";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "orderProm/updateOrderProm";
	}
}
