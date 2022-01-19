package sopra.formation.web;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sopra.formation.dao.IUtilisateurDao;

@Controller
public class HomeController {
	
//	@Autowired
//	private IPersonneDao personneDao;
	
	@Autowired
	private IUtilisateurDao utilisateurDao;
	
//	@Autowired
//	private IUtilisateurRoleDao utilisateurRoleDao;

	@GetMapping("")
	public String defaut() {
		return "redirect:/home";
	}

	@GetMapping("/home")
	public String home(Model model, @RequestParam(required = false) String username) {

		model.addAttribute("utilisateur", username);
		model.addAttribute("dtJour", LocalDate.now());

		return "home";
	}

//	@GetMapping("/inscriptionClient")
//	public String inscriptionClientForm(Model model) {
//		model.addAttribute("civilites", Civilite.values());
//		model.addAttribute("clientDTO", new InscriptionClientDTO());
//
//		return "inscription/client";
//	}
//
//	@PostMapping("/inscriptionClient")
//	public String inscriptionClientSave(@ModelAttribute("clientDTO") @Valid InscriptionClientDTO clientDTO,
//			BindingResult result, Model model) {
//
//		if (result.hasErrors()) {
//			model.addAttribute("civilites", Civilite.values());
//			return "inscription/client";
//		}
//
//		Utilisateur utilisateur = new Utilisateur(clientDTO.getIdentifiant(), clientDTO.getMotDePasse(), true);
//		utilisateur = utilisateurDao.save(utilisateur);
//		
//		UtilisateurRole utilisateurRole = new UtilisateurRole(utilisateur, Role.CLIENT);
//		utilisateurRoleDao.save(utilisateurRole);
//
//		Client client = new Client(clientDTO.getCivilite(), clientDTO.getNom(), clientDTO.getPrenom(),
//				clientDTO.getAge(), clientDTO.getDateNaissance());
//		client.setAdresse(new Adresse(clientDTO.getRue(), clientDTO.getComplement(), clientDTO.getCodePostal(),
//				clientDTO.getVille()));
//		client.setUtilisateur(utilisateur);
//		
//		personneDao.save(client);
//
//		return "redirect:/client";
//	}
}
