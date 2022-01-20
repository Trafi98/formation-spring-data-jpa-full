package sopra.formation.model;

public enum Droit {
	ADMIN("Administrateur"), GESTIONNAIRE("Gestionnaire"), STAGIAIRE("Stagiaire"), FORMATEUR("Formateur");	

	private final String label;

	private Droit(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
