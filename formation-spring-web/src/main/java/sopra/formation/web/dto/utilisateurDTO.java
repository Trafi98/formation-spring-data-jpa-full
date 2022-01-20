package sopra.formation.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import sopra.formation.model.Droit;

public class utilisateurDTO {
	private Long id;
	private int version;
	@NotBlank
	private String nom;
	private String prenom;
	private String email;
	private Droit droit;
	@Pattern(regexp = "\\d{10}")
	private String telephone;
	private String rue;
	private String complement;
	@Pattern(regexp = "\\d{5}")
	private String codePostal;
	private String ville;
//	private List<Filiere> filieres = new ArrayList<>();
		private String identifiant;
	private String motDePasse;
		
	public utilisateurDTO() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Droit getDroit() {
		return droit;
	}
	public void setDroit(Droit droit) {
		this.droit = droit;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getComplement() {
		return complement;
	}
	public void setComplement(String complement) {
		this.complement = complement;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	

}
