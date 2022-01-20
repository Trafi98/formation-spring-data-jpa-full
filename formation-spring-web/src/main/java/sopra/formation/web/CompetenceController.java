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

import sopra.formation.dao.ICompetenceDao;
import sopra.formation.dao.IMatiereDao;
import sopra.formation.dao.IUtilisateurDao;
import sopra.formation.model.Competence;
import sopra.formation.model.Formateur;
import sopra.formation.model.Matiere;
import sopra.formation.model.Niveau;

@Controller
@RequestMapping("/competence")
public class CompetenceController {
	
	@Autowired
	private ICompetenceDao competenceDao;
	private IUtilisateurDao utilisateurDao;
	private IMatiereDao matiereDao;
	
	@GetMapping("")
	public String list(Model model) {
		List<Competence> competences = competenceDao.findAll();

		model.addAttribute("competences", competences);

		return "competence/list";
	}

	@GetMapping("/add")
	public String add(Model model) {
//		List<Formateur> formateurs = utilisateurDao.findAllFormateur();
//		List<Matiere> matieres = matiereDao.findAllMatiere();
		
		model.addAttribute("niveau", Niveau.values());
//		model.addAttribute("formateurs", formateurs);
//		model.addAttribute("matieres", matieres);
		model.addAttribute("competence", new Competence());

		return "competence/form";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam Long id, Model model) {
		Optional<Competence> optCompetence = competenceDao.findCompetenceById(id);

		if (optCompetence.isPresent()) {
			model.addAttribute("competence", optCompetence.get());
		}

		model.addAttribute("competence", new Competence());

		return "competence/form";
	}
	
	@PostMapping("/save")
	public String saveBis(@ModelAttribute("competence") @Valid Competence competence) {
		competenceDao.save(competence);

		return "redirect:/competence";
	}

	@GetMapping("/cancel")
	public String cancel() {
		return "forward:/competence";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Long id) {
		competenceDao.deleteById(id);

		return "redirect:/competence";
	}
	
}
