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

import pe.edu.upc.entities.Vehicle;
import pe.edu.upc.service.IRoundsmanService;
import pe.edu.upc.service.IVehicleService;

@Controller
@RequestMapping("/vehicles")
public class VehicleController {

	@Autowired
	private IVehicleService vs;
	
	@Autowired
	private IRoundsmanService rs;
	
	@GetMapping("/new")
	public String newVehicle(Model model) {
		model.addAttribute("vehicle", new Vehicle());
		model.addAttribute("listaRepartidores", rs.list());
		return "vehicle/vehicle";
	}
	
	@PostMapping("/save")
	public String saveVehicle(@Valid @ModelAttribute(value = "vehicle") Vehicle vehicle, BindingResult result,
			Model model, SessionStatus status) throws Exception {
		if (result.hasErrors()) {
			return "vehicle/vehicle";
		} else {
			vs.insert(vehicle);
			model.addAttribute("mensaje", "Se realizó bien!!");
			status.setComplete();
			return "redirect:/vehicles/list";
		}
	}
	
	@GetMapping("/list")
	public String listVehicle(Model model) {
		try {
			model.addAttribute("listaVehiculos", vs.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "vehicle/listVehicle";
	}
	
	@RequestMapping("/delete")
	public String deleteVehicle(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if(id!=null && id>0) {
				vs.delete(id);
				model.put("mensaje", "Se eliminó correctamente!!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrió un error");
		}
		return "redirect:/vehicles/list";

	}
	
	@GetMapping("/detalle/{id}")
	public String viewVehicle(@PathVariable(value = "id") int id, Model model) {
		try {
			Optional<Vehicle> vehicle = vs.listarID(id);
			model.addAttribute("listaRepartidores", rs.list());
			if(!vehicle.isPresent()) {
				model.addAttribute("mensaje","Vehiculo no existe");
				return "redirect:/vehicles/list";
			}
			else {
				model.addAttribute("vehicle",vehicle.get());
				return "vehicle/updateVehicle";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "vehicle/updateVehicle";
	}
}
