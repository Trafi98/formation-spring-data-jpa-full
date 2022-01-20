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
import sopra.formation.model.Formateur;


@Controller
@RequestMapping("/formateur")
public class FormateurController {
	

		@Autowired
		private IUtilisateurDao utilisateurDao;

		@GetMapping("")
		public String list(Model model) {
			List<Formateur> formateurs = utilisateurDao.findAllFormateur();

			model.addAttribute("formateurs", formateurs);

			return "utilisateur/list";
		}

		@GetMapping("/add")
		public String add(Model model) {
			model.addAttribute("formateur", new Formateur());

			return "formateur/form";
		}

		@GetMapping("/edit")
		public String edit(@RequestParam Long id, Model model) {
			Optional<Formateur> optFormateur = utilisateurDao.findFormateurById(id);

			if (optFormateur.isPresent()) {
				model.addAttribute("formateur", optFormateur.get());
			}


			return "formateur/form";
		}

		
		@PostMapping("/save")
		public String saveBis(@ModelAttribute("formateur") Formateur formateur) {
			
			formateur.setDroit(Droit.FORMATEUR);
			utilisateurDao.save(formateur);

			return "redirect:/utilisateur";
		}

		@GetMapping("/cancel")
		public String cancel() {
			return "forward:/formateur";
		}

		@GetMapping("/delete")
		public String delete(@RequestParam Long id) {
			utilisateurDao.deleteById(id);

			return "redirect:/formateur";
		}

}
