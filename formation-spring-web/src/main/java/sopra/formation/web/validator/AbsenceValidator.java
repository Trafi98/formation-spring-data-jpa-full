package sopra.formation.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import sopra.formation.model.Absence;


public class AbsenceValidator implements Validator{
	@Override
	public boolean supports(Class<?> clazz) {
		return Absence.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Absence absence = (Absence) target;
		

	}
}
