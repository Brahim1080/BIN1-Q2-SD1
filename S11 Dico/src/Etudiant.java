/**
 *
 * @author ABID Brahim
 *
 */
import java.time.LocalDateTime;

public class Etudiant implements Comparable <Etudiant>{
	
	private int numeroMatricule;
	private String nom;
	private String prenom;
	private LocalDateTime dateArrive;
	
	
	public Etudiant(int numeroMatricule, String nom, String prenom) {
		super();
		this.numeroMatricule = numeroMatricule;
		this.nom = nom;
		this.prenom = prenom;
		this.dateArrive = LocalDateTime.now();
	}

	public LocalDateTime getDateArrive() {
		return dateArrive;
	}

	public int getNumeroMatricule() {
		return numeroMatricule;
	}


	public String getNom() {
		return nom;
	}


	public String getPrenom() {
		return prenom;
	}


	// A NE PAS MODIFIER : le numero de matricule est l'identifiant unique
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Etudiant other = (Etudiant) obj;
		if (numeroMatricule != other.numeroMatricule)
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		return numeroMatricule;
	}
	
	@Override
	public String toString() {
		return "Etudiant [numeroMatricule=" + numeroMatricule + ", nom=" + nom
				+ ", prenom=" + prenom + "]";
	}


	@Override
	public int compareTo(Etudiant etudiant) {
		if (this.numeroMatricule>etudiant.numeroMatricule)
			return 1;

		if (this.numeroMatricule == etudiant.numeroMatricule)
			return 0;
		return -1;
	}
}
