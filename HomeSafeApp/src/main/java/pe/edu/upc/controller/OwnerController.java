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

import pe.edu.upc.entities.Customer;
import pe.edu.upc.entities.Owner;
import pe.edu.upc.service.IOwnerService;

@Controller
@RequestMapping("/owners")
public class OwnerController {
	@Autowired
	private IOwnerService oService;
	
	/*localhost:8082/owner/*/
	@GetMapping("/new")
	public String newOwner(Model model) {
		model.addAttribute("owner", new Owner());
		return "owner/owner";
	}
	
	//valid permite visualizar la validacion de @Size, @Email, etc...
	@PostMapping("/save")
	public String saveOwner(@Valid @ModelAttribute(value="owner") Owner owner, BindingResult result, 
			Model model, SessionStatus status) throws Exception{
		if(result.hasErrors()) {
			return "owner/owner";
		}else {
			oService.insert(owner);
			model.addAttribute("mensaje","Se realizó bien!");
			status.setComplete();
			return "redirect:/owners/list";
		}
	}
	@GetMapping("/list")
	public String listOwner(Model model) {
		try {
			model.addAttribute("listaDuenos",oService.list());
		} catch (Exception e) {
			model.addAttribute("error",e.getMessage());
			// TODO: handle exception
		}
		return "owner/listOwner";
	}
	//para editar o modificar es request pero solo lectura se usa get?
	@RequestMapping("/delete")
	public String deleteOwner(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				oService.delete(id);
				model.put("mensaje", "Se eliminó correctamente!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrió un error");
			// TODO: handle exception
		}
		return "redirect:/owners/list";
	}
	
	@GetMapping("/detalle/{id}")
	public String viewOwner(@PathVariable(value = "id") int id, Model model) {
		try {
			Optional<Owner> owner = oService.listarID(id);
			if(!owner.isPresent()) {
				model.addAttribute("mensaje","Owner no existe");
				return "redirect:/owners/list";
			}
			else {
				model.addAttribute("owner",owner.get());
				return "owner/updateOwner";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "owner/updateOwner";
	}
	
}
