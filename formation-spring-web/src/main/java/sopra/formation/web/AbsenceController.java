package sopra.formation.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sopra.formation.dao.IAbsenceDao;
import sopra.formation.dao.IUtilisateurDao;
import sopra.formation.model.Absence;
import sopra.formation.model.Formateur;
import sopra.formation.web.validator.AbsenceValidator;


@Controller
@RequestMapping("/absence")
public class AbsenceController {
	

		@Autowired
		private IAbsenceDao absenceDao;
		@Autowired
		private IUtilisateurDao utilisateurDao;

		@GetMapping("")
		public String list(Model model) {
			List<Absence> absences = absenceDao.findAll();

			model.addAttribute("absences", absences);


			return "absence/list";
		}

		@GetMapping("/add")
		public String add(Model model) {
			List<Formateur> formateurs = utilisateurDao.findAllFormateur();
			model.addAttribute("formateurs", formateurs);
			
			model.addAttribute("absence", new Absence());
			


			return "absence/form";
		}

		@GetMapping("/edit")
		public String edit(@RequestParam Long id, Model model) {
			Optional<Absence> optAbsence = absenceDao.findById(id);

			if (optAbsence.isPresent()) {
				model.addAttribute("absence", optAbsence.get());
			}
			List<Formateur> formateurs = utilisateurDao.findAllFormateur();
			model.addAttribute("formateurs", formateurs);

			return "absence/form";
		}

		
		@PostMapping("/save")
		public String saveBis(@ModelAttribute("absence") @Valid Absence absence, BindingResult result, Model model) {
			new AbsenceValidator().validate(absence, result);
			List<Formateur> formateurs = utilisateurDao.findAllFormateur();
			
			if(result.hasErrors()) {
				model.addAttribute("formateurs", formateurs);
				return "absence/form";
			}

			if (absence.getFormateur() != null && absence.getFormateur().getId() == null) {
				absence.setFormateur(null);
			}
			
			absenceDao.save(absence);

			return "redirect:/absence";
		}

		@GetMapping("/cancel")
		public String cancel() {
			return "forward:/absence";
		}

		@GetMapping("/delete")
		public String delete(@RequestParam Long id) {
			absenceDao.deleteById(id);

			return "redirect:/absence";
		}

}
