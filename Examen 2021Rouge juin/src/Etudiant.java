
public class Etudiant {

	private String nom;
	private  char sexe; // 'M' --> masculin, 'F' --> feminin
	private String section;
	private int bloc; // 1, 2 ou 3
	
	public Etudiant(String nom, char sexe, String section, int bloc) {
		super();
		if(nom==null||nom.length()==0)
			throw new IllegalArgumentException();
		if(sexe!='M' && sexe!='F')
			throw new IllegalArgumentException();
		if(bloc<1||bloc>3)
			throw new IllegalArgumentException();
		this.nom = nom;
		this.sexe = sexe;
		this.section = section;
		this.bloc = bloc;
	}

	public String getNom() {
		return nom;
	}

	public char getSexe() {
		return sexe;
	}

	public String getSection() {
		return section;
	}

	public int getBloc() {
		return bloc;
	}

	@Override
	public String toString() {
		return "Etudiant [nom=" + nom + ", sexe=" + sexe + ", section="
				+ section + ", bloc=" + bloc + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Etudiant other = (Etudiant) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
	
	
}
