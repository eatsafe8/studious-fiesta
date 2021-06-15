package pe.edu.upc.controller;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import pe.edu.upc.entities.OrderT;
import pe.edu.upc.service.ICustomerService;
import pe.edu.upc.service.IOrderService;
import pe.edu.upc.service.IRestaurantService;

@Controller
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private IOrderService OS;
	
	@Autowired
	private IRestaurantService rs;
	
	@Autowired
	private ICustomerService cs;
	
	@GetMapping("/new")
	public String newOrder(Model model) {
		model.addAttribute("orderT", new OrderT());
		model.addAttribute("listaRestaurantes", rs.list());
		model.addAttribute("listaClientes", cs.list());
		return "order/order";
	}
	
	@PostMapping("/save")
	public String saveOrder(@Valid @ModelAttribute(value = "orderT") OrderT orderT, BindingResult result,
			Model model, SessionStatus status) throws Exception {
		if (result.hasErrors()) {
			return "order/order";
		} else {
			OS.insert(orderT);
			model.addAttribute("mensaje", "Se realizó bien!!");
			status.setComplete();
			return "redirect:/orders/list";
		}
	}
	
	@GetMapping("/list")
	public String listOrder(Model model) {
		try {
			model.addAttribute("listaOrdenes", OS.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "order/listOrder";
	}
	
	@RequestMapping("/delete")
	public String deleteOrder(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if(id!=null && id>0) {
				OS.delete(id);
				model.put("mensaje", "Se eliminó correctamente!!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrió un error");
		}
		return "redirect:/orders/list";
	}
	
	@GetMapping("/detalle/{id}")
	public String viewOrder(@PathVariable(value = "id") int id, Model model) {
		try {
			Optional<OrderT> order = OS.listarID(id);
			model.addAttribute("listaRestaurantes", rs.list());
			model.addAttribute("listaClientes", cs.list());
			if(!order.isPresent()) {
				model.addAttribute("mensaje","Orden no existe");
				return "redirect:/orders/list";
			}
			else {
				model.addAttribute("orderT",order.get());
				return "order/updateOrder";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "order/updateOrder";
	}
}
