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

import pe.edu.upc.entities.Restaurant;
import pe.edu.upc.service.IOwnerService;
import pe.edu.upc.service.IRestaurantService;

@Controller
@RequestMapping("/restaurants")
public class RestaurantController {
	@Autowired
	private IRestaurantService rService;
	@Autowired
	private IOwnerService oService;

	@GetMapping("/new")
	public String newRestaurant(Model model) {
		model.addAttribute("restaurant", new Restaurant());
		model.addAttribute("listaDuenos", oService.list());
		return "restaurant/restaurant";
	}

	// valid permite visualizar la validacion de @Size, @Email, etc...
	@PostMapping("/save")
	public String saveRestaurant(@Valid @ModelAttribute(value = "restaurant") Restaurant restaurant, BindingResult result,
			Model model, SessionStatus status) throws Exception {
		if (result.hasErrors()) {
			return "restaurant/restaurant";
		} else {
			rService.insert(restaurant);
			model.addAttribute("mensaje", "Se realizó bien!");
			status.setComplete();
			return "redirect:/restaurants/list";
		}
	}

	@GetMapping("/list")
	public String listRestaurant(Model model) {
		try {
			model.addAttribute("listaRestaurantes", rService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			// TODO: handle exception
		}
		return "restaurant/listRestaurant";
	}

	// para editar o modificar es request pero solo lectura se usa get?
	@RequestMapping("/delete")
	public String deleteRestaurant(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				rService.delete(id);
				model.put("mensaje", "Se eliminó correctamente!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrió un error");
			// TODO: handle exception
		}
		return "redirect:/restaurants/list";
	}
	
	@GetMapping("/detalle/{id}")
	public String viewRestaurant(@PathVariable(value = "id") int id, Model model) {
		try {
			Optional<Restaurant> restaurant = rService.listarID(id);
			if(!restaurant.isPresent()) {
				model.addAttribute("mensaje","Restaurante no existe");
				return "redirect:/restaurants/list";
			}
			else {
				model.addAttribute("restaurant",restaurant.get());
				return "restaurant/updateRestaurant";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "restaurant/updateRestaurant";
	}
	@RequestMapping("/reporte3")
	public String MontoRestaurantFiestasPatrias(Map<String, Object> model) {
		model.put("listMontoRestuaranteFiestasPatrias", rService.MontoRestuaranteFiestasPatrias());
		return "reports/MontoRestuaranteFiestasPatrias";
	}
}
