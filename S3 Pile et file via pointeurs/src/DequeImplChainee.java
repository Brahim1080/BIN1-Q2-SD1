/**
 * @author Brahim Abid
 *
 */
public class DequeImplChainee<E> implements Deque<E> {

	private Noeud tete ;
	private Noeud queue ;
	private int taille ;
	
	public DequeImplChainee(){
		tete=null;
		queue=null;
		taille=0;
	}
	
	// A NE PAS MODIFIER --> POUR LES TESTS!!!
	// tete 'a' 'b' 'c' queue : ['a','b','c']
	public DequeImplChainee(Object[] table) {
		if(table == null)
			throw new IllegalArgumentException();
		taille = 0 ;
		tete = null ;
		queue = null ;
		if(table.length==0)
			return;
		for (int i = table.length-1; i>=0;i--) {
			this.ajouterEnPremier((E) table[i]) ;
		}
	}
	
	public String toString(){
		String aRenvoyer="";
		Noeud baladeur=tete;
		int cpt = 0;
		while(baladeur!=null) {
			cpt++;
			if(cpt>taille){
				aRenvoyer = "boucle infinie dans toString(), chainage a verifier";
			}
			aRenvoyer+=baladeur.element;
			if (baladeur.suivant !=null)
				aRenvoyer += " " ;
			baladeur=baladeur.suivant;
		}
		return aRenvoyer;
	}
	
	public String parcoursInverse(){
		String aRenvoyer="";
		Noeud baladeur=queue;
		int cpt = 0;
		while(baladeur!=null) {
			cpt++;
			if(cpt>taille){
				aRenvoyer = "boucle infinie dans toString(), chainage a verifier";
			}
			aRenvoyer+=baladeur.element;
			if (baladeur.precedent !=null)
				aRenvoyer += " " ;
			baladeur=baladeur.precedent;
		}
		return aRenvoyer;
	}
	

	public int taille() {
		return this.taille ;
	}
	

	public boolean estVide() {
		return (taille==0) ;
	}

	// A NE PAS MODIFIER --> POUR LES TESTS!!!
	public void ajouterEnPremier(E element) {
		if (estVide()) {
			tete = new Noeud(element,null,null) ;
			queue = tete ;
		} else {
			tete.precedent = new Noeud(element,null,tete) ;
			tete = tete.precedent;
		}
		taille = taille + 1 ;
	}
	

	public E retirerPremier() {
		if (this.estVide())
			throw new DequeVideException();
		E premier = tete.element;

		if (taille ==1){
			tete = null;
			queue = null;
		} else{
			tete = tete.suivant;
			tete.precedent = null;
		}
		taille--;
		return premier;//ok
	}


	public void ajouterEnDernier(E element) {
		Noeud noeud = new Noeud(element,queue , null);
		if (taille == 0 ){
			queue = noeud ;
			tete = noeud;
		} else {
			queue.suivant = noeud;
			queue = noeud;
		}
		taille++;
	}


	public E retirerDernier() throws DequeVideException {
		if (this.estVide()) throw  new DequeVideException();
		E dernier = queue.element;
		if (taille ==1){
			tete = null;
			queue = null;
		} else{
			queue = queue.precedent;
			queue.suivant = null;
		}
		taille--;
		return dernier;
	}


	public E premier()throws DequeVideException {
		if (this.estVide()) throw  new DequeVideException();
		return (E) tete.element;//ok
	}


	public E dernier()throws DequeVideException {
		if (this.estVide()) throw  new DequeVideException();
		return (E) queue.element;//ok
	}
	
	// classe interne
	private class Noeud{
		private E element;
		private Noeud suivant;
		private Noeud precedent;

		private Noeud(E element, Noeud precedent, Noeud suivant){
				this.element = element;
				this.suivant = suivant;
				this.precedent = precedent ;
		}
	}

}
