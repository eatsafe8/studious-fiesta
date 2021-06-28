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

import pe.edu.upc.entities.DetailPromotion;
import pe.edu.upc.service.IDetailPromotionService;
import pe.edu.upc.service.IProductService;
import pe.edu.upc.service.IPromotionService;

@Controller
@RequestMapping("/detailpromotions")
public class DetailPromotionController {
	@Autowired
	private IDetailPromotionService dpS;
	
	@Autowired
	private IPromotionService prS;
	
	@Autowired
	private IProductService pdS;
	
	
	@GetMapping("/new")
	public String newDetailPromotion(Model model) {
		model.addAttribute("detailpromotion", new DetailPromotion());
		model.addAttribute("listaPromociones", prS.list());
		model.addAttribute("listaProductos", pdS.list());
		return "detailpromotion/detailpromotion";
	}
	
	@PostMapping("/save")
	public String saveDetailPromotion(@Valid @ModelAttribute(value = "detailpromotion") DetailPromotion detailpromotion, BindingResult result,
			Model model, SessionStatus status) throws Exception {
		if (result.hasErrors()) {
			return "detailpromotion/detailpromotion";
		} else {
			dpS.insert(detailpromotion);
			model.addAttribute("mensaje", "Se realizó bien!!");
			status.setComplete();
			return "redirect:/detailpromotions/list";
		}
	}
	
	@GetMapping("/list")
	public String listDetailPromotion(Model model) {
		try {
			model.addAttribute("listaDetallePromociones", dpS.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "detailpromotion/listDetailPromotion";
	}
	
	@RequestMapping("/delete")
	public String deleteDetailPromotion(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if(id!=null && id>0) {
				dpS.delete(id);
				model.put("mensaje", "Se eliminó correctamente!!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrió un error");
		}
		return "redirect:/detailpromotions/list";
	}
	
	@GetMapping("/detalle/{id}")
	public String viewDetailProm(@PathVariable(value = "id") int id, Model model) {
		try {
			Optional<DetailPromotion> detailpromotion = dpS.listarID(id);
			model.addAttribute("listaPromociones", prS.list());
			model.addAttribute("listaProductos", pdS.list());
			if(!detailpromotion.isPresent()) {
				model.addAttribute("mensaje","Detalle Promocion no existe");
				return "redirect:/detailpromotions/list";
			}
			else {
				model.addAttribute("detailpromotion",detailpromotion.get());
				return "detailpromotion/updateDetailProm";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "detailpromotion/updateDetailProm";
	}
}
