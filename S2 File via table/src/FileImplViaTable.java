import java.lang.reflect.Array;
import java.util.Arrays;

// implementation de l'interface File via une table circulaire

/**
 * @author Brahim Abid
 *
 */

public class FileImplViaTable<E> implements File<E>{

	private Object[] table;  // ne modifiez pas cet identifiant, la classe test l'utilise					
	private int indiceTete;  // ne modifiez pas cet identifiant, la classe test l'utilise			
	private int taille;		// ne modifiez pas cet identifiant, la classe test l'utilise	
	// N'ajoutez pas d'autres attributs, la classe test risquerait de ne pas fonctionner
	

	public FileImplViaTable(){
		table = new Object[4];
		taille = 0;
		indiceTete = 0;
	}
	

	public boolean estVide(){
		return taille == 0;
	}


	public int taille(){
		return taille;
	}

	public E premier()throws FileVideException{
		if (this.estVide())
			throw new FileVideException();
		E elem = (E) table[indiceTete];

		return elem;

		
	}


	public E defile() throws FileVideException{
		if (this.estVide())
			throw new FileVideException();

		E elem = (E) table[indiceTete];

		indiceTete++;

		if (indiceTete == table.length){
			indiceTete = 0 ;
		}
		taille--;
		return elem;

	}


	public void enfile(E element){

		int indiceAjout  =  taille + indiceTete ;
		if ( taille == table.length ){

			Object[] tableTemp = new Object[table.length * 2] ;

			int cpt = 0;
			for (int i = indiceTete; i < table.length ; i++) {
				tableTemp [cpt] = table[i];
				cpt++;
			}
			for (int i = 0; i < indiceTete   ; i++) {
				tableTemp [cpt] = table[i];
				cpt++;
			}
			indiceTete = 0;
			table = tableTemp;
			table[taille] = element;
			taille ++ ;
		}else {
			if (indiceAjout >= table.length && taille < table.length){
				indiceAjout = indiceAjout % table.length;
				table[indiceAjout] = element;
				taille++;

			}else{
				table[indiceAjout] = element;
				taille++;

			}
		}









	}

} 
