public interface ABRSD<E>{
	
	/**
	 * verifie si l'ABR est vide
	 * @return true si l'ABR est vide, false sinon
	 */
	public boolean estVide();

	
	/**
	 * renvoie le nombre d'elements
	 * @return le nombre d'elements 
	 */
	public int taille();
	

	
	/**
	 * renvoie le plus petit element de l'ABR
	 * @return le plus petit element ou null si l'ABR est vide
	 */
	public E elementLePlusPetit();


	/**
	 * insere l'element si l'element n'est pas present
	 * @param element l'element a inserer
	 * @return true si l'element a ete insere, false sinon
	 */
	public boolean insere(E element);

	
	/**
	 * renvoie le plus grand element qui est strictement plus petit que l'element passe en parametre
	 * @param element l'element dont on recherche l'element precedent
	 * @return l'element precedent ou null si un tel element n'existe pas
	 */
	public E elementPrecedent(E element);

	
	
}
