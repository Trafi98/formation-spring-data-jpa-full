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
import sopra.formation.model.Utilisateur;


@Controller
@RequestMapping("/utilisateur")
public class UtilisateurController {
	

		@Autowired
		private IUtilisateurDao utilisateurDao;

		@GetMapping("")
		public String list(Model model) {
			List<Utilisateur> utilisateurs = utilisateurDao.findAllUtilisateur();

			model.addAttribute("utilisateurs", utilisateurs);

			return "utilisateur/list";
		}

		@GetMapping("/add")
		public String add(Model model) {
			model.addAttribute("utilisateur", new Utilisateur());

			return "utilisateur/form";
		}

		@GetMapping("/edit")
		public String edit(@RequestParam Long id, Model model) {
			Optional<Utilisateur> optUtilisateur = utilisateurDao.findUtilisateurById(id);

			if (optUtilisateur.isPresent()) {
				model.addAttribute("utilisateur", optUtilisateur.get());
			}


			return "utilisateur/form";
		}

		
		@PostMapping("/save")
		public String saveBis(@ModelAttribute("utilisateur") Utilisateur utilisateur) {
			
			utilisateur.setDroit(Droit.GESTIONNAIRE);
			utilisateurDao.save(utilisateur);

			return "redirect:/utilisateur";
		}

		@GetMapping("/cancel")
		public String cancel() {
			return "forward:/utilisateur";
		}

		@GetMapping("/delete")
		public String delete(@RequestParam Long id) {
			utilisateurDao.deleteById(id);

			return "redirect:/utilisateur";
		}

}
