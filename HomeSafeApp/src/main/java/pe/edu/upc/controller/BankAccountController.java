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

import pe.edu.upc.entities.BankAccount;
import pe.edu.upc.service.IBankAccountService;
import pe.edu.upc.service.IOwnerService;

@Controller
@RequestMapping("/bankAccounts")
public class BankAccountController {

	@Autowired
	private IBankAccountService bS;

	@Autowired
	private IOwnerService oS;
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/new")
	public String newBankAccount(Model model) {
		model.addAttribute("bankAccount", new BankAccount());
		model.addAttribute("listaDuenos", oS.list());
		return "bankAccount/bankAccount";
	}
	@Secured("ROLE_ADMIN")
	@PostMapping("/save")
	public String saveBankAccount(@Valid @ModelAttribute(value = "bankAccount") BankAccount bankAccount,
			BindingResult result, Model model, SessionStatus status) throws Exception {
		if (result.hasErrors()) {
			model.addAttribute("listaDuenos", oS.list());
			return "bankAccount/bankAccount";
		} else {
			bS.insert(bankAccount);
			model.addAttribute("mensaje", "Se registró la cuenta bancaria exitosamente");
			status.setComplete();
			return "redirect:/bankAccounts/list";
		}
	}
	@Secured("ROLE_ADMIN")
	@GetMapping("/list")
	public String listBankAccount(Model model) {
		try {
			model.addAttribute("listaCuentasBanco", bS.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "bankAccount/listBankAccount";
	}
	@Secured("ROLE_ADMIN")
	@RequestMapping("/delete")
	public String deleteBankAccount(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				bS.delete(id);
				model.put("mensaje", "La cuenta bancaria se eliminó exitosamente");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrió un error");
		}
		return "redirect:/bankAccounts/list";
	}
	@Secured("ROLE_ADMIN")
	@GetMapping("/detalle/{id}")
	public String viewBankAccount(@PathVariable(value = "id") int id, Model model) {
		try {
			Optional<BankAccount> bankAccount = bS.listarID(id);
			model.addAttribute("listaDuenos", oS.list());
			if(!bankAccount.isPresent()) {
				model.addAttribute("mensaje","Cuenta bancaria no existe");
				return "redirect:/bankAccounts/list";
			}
			else {
				model.addAttribute("bankAccount",bankAccount.get());
				return "bankAccount/updateBankAccount";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "bankAccount/updateBankAccount";
	}
}
