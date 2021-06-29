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

import pe.edu.upc.entities.OrderDetail;
import pe.edu.upc.service.IOrderDetailService;
import pe.edu.upc.service.IOrderService;
import pe.edu.upc.service.IProductService;

@Controller
@RequestMapping("/orderDetails")
public class OrderDetailController {

	@Autowired
	private IOrderDetailService ODS;
	
	@Autowired
	private IOrderService os;
	
	@Autowired
	private IProductService ps;
	@Secured("ROLE_ADMIN")
	@GetMapping("/new")
	public String newOrderDetail(Model model) {
		model.addAttribute("orderDetail", new OrderDetail());
		model.addAttribute("listaOrdenes", os.list());
		model.addAttribute("listaProductos", ps.list());
		return "orderDetail/orderDetail";
	}
	@Secured("ROLE_ADMIN")
	@PostMapping("/save")
	public String saveOrderDetail(@Valid @ModelAttribute(value = "orderDetail") OrderDetail orderDetail, BindingResult result,
			Model model, SessionStatus status) throws Exception {
		if (result.hasErrors()) {
			model.addAttribute("listaOrdenes", os.list());
			model.addAttribute("listaProductos", ps.list());
			return "orderDetail/orderDetail";
		} else {
			ODS.insert(orderDetail);
			model.addAttribute("mensaje", "Detalle de la orden registrado con éxito");
			status.setComplete();
			return "redirect:/orderDetails/list";
		}
	}
	@Secured("ROLE_ADMIN")
	@GetMapping("/list")
	public String listOrderDetail(Model model) {
		try {
			model.addAttribute("listaOrdenDetalle", ODS.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "orderDetail/listOrderDetail";
	}
	@Secured("ROLE_ADMIN")
	@RequestMapping("/delete")
	public String deleteOrderDetail(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if(id!=null && id>0) {
				ODS.delete(id);
				model.put("mensaje", "Se eliminó correctamente");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrió un error");
		}
		return "redirect:/orderDetails/list";
	}
	@Secured("ROLE_ADMIN")
	@GetMapping("/detalle/{id}")
	public String viewOrderDetail(@PathVariable(value = "id") int id, Model model) {
		try {
			Optional<OrderDetail> orderdetail = ODS.listarID(id);
			model.addAttribute("listaOrdenes", os.list());
			model.addAttribute("listaProductos", ps.list());
			if(!orderdetail.isPresent()) {
				model.addAttribute("mensaje","Orden de Producto no existe");
				return "redirect:/orderDetails/list";
			}
			else {
				model.addAttribute("orderDetail",orderdetail.get());
				return "orderDetail/updateOrderDetail";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "orderDetail/updateOrderDetail";
	}
}
