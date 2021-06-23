package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.el.parser.ParseException;
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

import pe.edu.upc.entities.Customer;
import pe.edu.upc.service.ICustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private ICustomerService cService;
	
	/*localhost:8082/owner/*/
	@GetMapping("/new")
	public String newCustomer(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer/customer";
	}
	
	//valid permite visualizar la validacion de @Size, @Email, etc...
	@PostMapping("/save")
	public String savecustomer(@Valid @ModelAttribute(value="customer") Customer customer, BindingResult result, 
			Model model, SessionStatus status) throws Exception{
		if(result.hasErrors()) {
			return "customer/customer";
		}else {
			cService.insert(customer);
			model.addAttribute("mensaje","Se realizó bien!");
			status.setComplete();
			return "redirect:/customers/list";
		}
	}
	@GetMapping("/list")
	public String listCustomer(Model model) {
		try {
			model.addAttribute("listaClientes",cService.list());
		} catch (Exception e) {
			model.addAttribute("error",e.getMessage());
			// TODO: handle exception
		}
		return "customer/listCustomer";
	}
	//para editar o modificar es request pero solo lectura se usa get?
	@RequestMapping("/delete")
	public String deleteCustomer(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				cService.delete(id);
				model.put("mensaje", "Se eliminó correctamente!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrió un error");
			// TODO: handle exception
		}
		return "redirect:/customers/list";
	}
	
	@GetMapping("/detalle/{id}")
	public String viewCustomer(@PathVariable(value = "id") int id, Model model) {
		try {
			Optional<Customer> customer = cService.listarID(id);
			if(!customer.isPresent()) {
				model.addAttribute("mensaje","Customer no existe");
				return "redirect:/customers/list";
			}
			else {
				model.addAttribute("customer",customer.get());
				return "customer/updateCustomer";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "customer/updateCustomer";
	}
	
	@GetMapping("/listFind")
	public String listCustomerFind(Model model) {
		try {
			model.addAttribute("customer", new Customer());
			model.addAttribute("listaClientes",cService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "customer/find";
	}

	@RequestMapping("/find")
	public String findByCustomer(Model model, @ModelAttribute Customer customer) throws ParseException {
		List<Customer> listaClientes = new ArrayList<Customer>();
		customer.setDniCustomer(customer.getDniCustomer());
		model.addAttribute("customer", new Customer());

		if (listaClientes.isEmpty()) {
			listaClientes = cService.searchDniIgnoreCase(customer.getDniCustomer());
		}
		if (listaClientes.isEmpty()) {
			listaClientes = cService.findByDni(customer.getDniCustomer());
		}
		if (listaClientes.isEmpty()) {
			model.addAttribute("mensaje", "No se encontró");
		}
		
		model.addAttribute("listaClientes", listaClientes);
		return "customer/find";
	}
	@RequestMapping("/reporte2")
	public String productosXord(Map<String, Object> model) {
		model.put("listCusxPriceOrder", cService.cusXpriceorder());
		return "reports/montosClientes";
	}
}
