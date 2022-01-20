package sopra.formation.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import sopra.formation.dao.IUtilisateurDao;
import sopra.formation.model.Droit;
import sopra.formation.model.Stagiaire;


@Controller
@RequestMapping("/stagiaire")
public class StagiaireController {
	

		@Autowired
		private IUtilisateurDao utilisateurDao;

		@GetMapping("")
		public String list(Model model) {
			List<Stagiaire> stagiaires = utilisateurDao.findAllStagiaire();

			model.addAttribute("stagiaires", stagiaires);

			return "utilisateur/list";
		}

		@GetMapping("/add")
		public String add(Model model) {
			model.addAttribute("stagiaire", new Stagiaire());

			return "stagiaire/form";
		}

		@GetMapping("/edit")
		public String edit(@RequestParam Long id, Model model) {
			Optional<Stagiaire> optStagiaire = utilisateurDao.findStagiaireById(id);

			if (optStagiaire.isPresent()) {
				model.addAttribute("stagiaire", optStagiaire.get());
			}


			return "stagiaire/form";
		}

		
		@PostMapping("/save")
		public String saveBis(@ModelAttribute("stagiaire") Stagiaire stagiaire) {
			
			stagiaire.setDroit(Droit.STAGIAIRE);
			utilisateurDao.save(stagiaire);

			return "redirect:/utilisateur";
		}

		@GetMapping("/cancel")
		public String cancel() {
			return "forward:/stagiaire";
		}

		@GetMapping("/delete")
		public String delete(@RequestParam Long id) {
			utilisateurDao.deleteById(id);

			return "redirect:/stagiaire";
		}

}
