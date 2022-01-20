package sopra.formation.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sopra.formation.dao.ICoursDao;
import sopra.formation.model.Cours;
import sopra.formation.model.Niveau;

@Controller
@RequestMapping("/cours")
public class CoursController {
	
	private ICoursDao coursDao;
	
	@GetMapping("")
	public String list(Model model) {
		List<Cours> cours = coursDao.findAllCours();

		model.addAttribute("cours", cours);

		return "cours/list";
	}

	@GetMapping("/add")
	public String add(Model model) {
//		List<Formateur> formateurs = utilisateurDao.findAllFormateur();
//		List<Matiere> matieres = matiereDao.findAllMatiere();
		
		model.addAttribute("niveau", Niveau.values());
//		model.addAttribute("formateurs", formateurs);
//		model.addAttribute("matieres", matieres);
		model.addAttribute("cours", new Cours());

		return "cours/form";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam Long id, Model model) {
		Optional<Cours> optCours = coursDao.findCoursById(id);

		if (optCours.isPresent()) {
			model.addAttribute("cours", optCours.get());
		}

		model.addAttribute("cours", new Cours());

		return "cours/form";
	}
	
	@PostMapping("/save")
	public String saveBis(@ModelAttribute("cours") @Valid Cours cours) {
		coursDao.save(cours);

		return "redirect:/cours";
	}

	@GetMapping("/cancel")
	public String cancel() {
		return "forward:/cours";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Long id) {
		coursDao.deleteById(id);

		return "redirect:/cours";
	}

}
