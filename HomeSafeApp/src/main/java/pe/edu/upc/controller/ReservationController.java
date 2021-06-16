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

import pe.edu.upc.entities.Reservation;
import pe.edu.upc.service.ICustomerService;
import pe.edu.upc.service.IReservationService;
import pe.edu.upc.service.IRestaurantService;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

	@Autowired
	private IReservationService RS;
	
	@Autowired
	private IRestaurantService rs;
	
	@Autowired
	private ICustomerService cs;
	
	@GetMapping("/new")
	public String newReservation(Model model) {
		model.addAttribute("reservation", new Reservation());
		model.addAttribute("listaRestaurantes", rs.list());
		model.addAttribute("listaClientes", cs.list());
		return "reservation/reservation";
	}
	
	@PostMapping("/save")
	public String saveReservation(@Valid @ModelAttribute(value = "reservation") Reservation reservation, BindingResult result,
			Model model, SessionStatus status) throws Exception {
		if (result.hasErrors()) {
			return "reservation/reservation";
		} else {
			RS.insert(reservation);
			model.addAttribute("mensaje", "Se realizó bien!!");
			status.setComplete();
			return "redirect:/reservations/list";
		}
	}
	
	@GetMapping("/list")
	public String listReservation(Model model) {
		try {
			model.addAttribute("listaReservaciones", RS.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "reservation/listReservation";
	}
	
	@RequestMapping("/delete")
	public String deleteReservation(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if(id!=null && id>0) {
				RS.delete(id);
				model.put("mensaje", "Se eliminó correctamente!!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrió un error");
		}
		return "redirect:/reservations/list";
	}
	
	@GetMapping("/detalle/{id}")
	public String viewReservation(@PathVariable(value = "id") int id, Model model) {
		try {
			Optional<Reservation> reservation = RS.listarID(id);
			model.addAttribute("listaRestaurantes", rs.list());
			model.addAttribute("listaClientes", cs.list());
			if(!reservation.isPresent()) {
				model.addAttribute("mensaje","Reservacion no existe");
				return "redirect:/reservations/list";
			}
			else {
				model.addAttribute("reservation",reservation.get());
				return "reservation/updateReservation";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "reservation/updateReservation";
	}
}
