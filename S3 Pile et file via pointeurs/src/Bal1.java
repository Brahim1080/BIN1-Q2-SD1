/**
 * Cette classe retient dans une liste les etudiants inscrits au bal
 * La liste contient d abord les hommes, ensuite les femmes
 * Dans chacune des sous-listes, l'ordre suit l'ordre des inscriptions
 * 
 * @author 
 *
 */
public class Bal1 {
	
	private NoeudEtudiant tete;
	private NoeudEtudiant derM;
	private NoeudEtudiant derF;
	
	/**
	 * construit un bal "vide", la liste des etudiants est vide
	 */
	public Bal1(){
		tete = null;
		derM = null;
		derF = null;
	}
	
	public String toString(){
		String aRenvoyer = "";
		NoeudEtudiant baladeur = tete;
		while(baladeur!=null){
			aRenvoyer+=" "+baladeur.etudiant.getPrenom();
			baladeur = baladeur.suivant;
		}
		return aRenvoyer;
	}
	
	/**
	 * ajoute l etudiant dans la liste en tenant compte de l'ordre prevu
	 * @param etudiant l etudiant a ajouter
	 * @throws IllegalArgumentException si l etudiant est null
	 */
	public void ajouterEtudiant(Etudiant etudiant){
		if(etudiant==null)
			throw new IllegalArgumentException("etudiant null");
		if(etudiant.getSexe() == 'M' && tete == null){
			tete = new NoeudEtudiant(etudiant);
			derM = tete;
		} else if(etudiant.getSexe() == 'M' && derF == null){
			NoeudEtudiant noeud = new NoeudEtudiant(etudiant);
			derM.suivant = noeud;
			derM = noeud;
		} else if(etudiant.getSexe() == 'M' && derM == null){
			NoeudEtudiant noeud = new NoeudEtudiant(etudiant);
			noeud.suivant = tete;
			tete = noeud;
			derM = noeud;
		} else if(etudiant.getSexe() == 'M'){
			NoeudEtudiant noeud = new NoeudEtudiant(etudiant);
			noeud.suivant = derM.suivant;
			derM.suivant = noeud;
			derM = noeud;
		} else if(etudiant.getSexe() == 'F' && tete == null){
			NoeudEtudiant noeud = new NoeudEtudiant(etudiant);
			tete = noeud;
			derF = noeud;
		} else if(etudiant.getSexe() == 'F' && derF == null){
			NoeudEtudiant noeud = new NoeudEtudiant(etudiant);
			derM.suivant = noeud;
			derF = noeud;
		} else if(etudiant.getSexe() == 'F' && derM == null){
			NoeudEtudiant noeud = new NoeudEtudiant(etudiant);
			derF.suivant = noeud;
			derF = noeud;
		} else if(etudiant.getSexe() == 'F'){
			NoeudEtudiant noeud = new NoeudEtudiant(etudiant);
			derF.suivant = noeud;
			derF = noeud;
		}
	}
	
	// classe interne
	private class NoeudEtudiant{
		
		private Etudiant etudiant;
		private NoeudEtudiant suivant;
		
		public NoeudEtudiant(Etudiant etudiant){
			this.etudiant = etudiant;
			this.suivant = null;
		}
		
		public NoeudEtudiant(Etudiant etudiant, NoeudEtudiant suivant){
			this.etudiant = etudiant;
			this.suivant = suivant;
		}
		
	}
}
