package pe.edu.upc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.upc.entities.Role;
import pe.edu.upc.service.IRolService;
import pe.edu.upc.service.IUserService;

@Controller
//@Secured("ROLE_ADMIN")
@RequestMapping("/roles")
public class RolController {
	@Autowired
	private IRolService rS;
	@Autowired
	private IUserService uS;
	@Secured("ROLE_ADMIN")
	@GetMapping("/new")
	public String newRole(Model model) {
		model.addAttribute("role", new Role());
		model.addAttribute("listUsers", uS.list());
		return "rol/role";
	}
	@Secured("ROLE_ADMIN")
	@PostMapping("/save")
	public String saveRole(@Validated Role role, BindingResult result, Model model) throws Exception {
		if (result.hasErrors()) {
			return "role/role";
		} else {
			rS.insert(role);
			model.addAttribute("listRoles", rS.list());
			return "rol/listRoles";

		}
	}
	@Secured("ROLE_ADMIN")
	@GetMapping("/list")
	public String listRole(Model model) {
		try {
			model.addAttribute("listRoles", rS.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "rol/listRoles";

	}
	@Secured("ROLE_ADMIN")
	@RequestMapping("/delete")
	public String deleteRol(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if(id!=null && id>0) {
				rS.delete(id);
				model.put("mensaje", "Se eliminó correctamente!!");
			}		
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrió un error");
		}
		return "redirect:/roles/list";
	}
}
