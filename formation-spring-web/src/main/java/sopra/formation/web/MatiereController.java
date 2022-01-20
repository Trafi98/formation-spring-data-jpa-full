package sopra.formation.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sopra.formation.dao.IMatiereDao;
import sopra.formation.model.Matiere;

@Controller
@RequestMapping("/matiere")
public class MatiereController {
	
	@Autowired
	private IMatiereDao matiereDao;
	
	@GetMapping("")
	public String list(Model model) {
		List<Matiere> matieres = matiereDao.findAll();

		model.addAttribute("matieres", matieres);

		return "matiere/list";
	}

	@GetMapping("/add")
	public String add(Model model) {

		model.addAttribute("matiere", new Matiere());

		return "matiere/form";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam Long id, Model model) {
		Optional<Matiere> optMatiere = matiereDao.findMatiereById(id);

		if (optMatiere.isPresent()) {
			model.addAttribute("matiere", optMatiere.get());
		}

		model.addAttribute("matiere", new Matiere());

		return "matiere/form";
	}
	
	@PostMapping("/save")
	public String saveBis(@ModelAttribute("matiere") @Valid Matiere matiere) {
		matiereDao.save(matiere);

		return "redirect:/matiere";
	}

	@GetMapping("/cancel")
	public String cancel() {
		return "forward:/matiere";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Long id) {
		matiereDao.deleteById(id);

		return "redirect:/matiere";
	}

}
