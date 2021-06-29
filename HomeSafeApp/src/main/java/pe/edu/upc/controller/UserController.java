package pe.edu.upc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.upc.entities.Users;
import pe.edu.upc.service.IUserService;

@Controller
//@Secured("ROLE_ADMIN")
@RequestMapping("/users")
public class UserController {
	@Autowired
	private IUserService uS;
	@Secured("ROLE_ADMIN")
	@GetMapping("/new")
	public String newUser(Model model) {
		model.addAttribute("user", new Users());
		return "user/user";
	}
	@Secured("ROLE_ADMIN")
	@PostMapping("/save")
	public String saveUser(@Validated Users users, BindingResult result, Model model) throws Exception {
		if (result.hasErrors()) {
			return "user/user";
		} else {
			String password = new BCryptPasswordEncoder().encode(users.getPassword());
			users.setPassword(password);
			uS.insert(users);
			model.addAttribute("listUsers", uS.list());
			return "user/listUsers";

		}
	}
	@Secured("ROLE_ADMIN")
	@RequestMapping("/delete")
	public String deleteUser(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if(id!=null && id>0) {
				uS.delete(id);
				model.put("mensaje", "Se eliminó correctamente!!");
			}		
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrió un error");
		}
		return "redirect:/users/list";
	}
	@Secured("ROLE_ADMIN")
	@GetMapping("/list")
	public String listUsers(Model model) {
		try {
			model.addAttribute("listUsers", uS.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "user/listUsers";

	}

}
