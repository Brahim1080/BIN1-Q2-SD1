import java.util.*;
/**
 *
 * @author ABID Brahim
 *
 */
public class SessionDeVente {

    private PriorityQueue<Client> filePriorite;
    private HashSet<Client> ensembleClientsActuellementDansFile;
    private HashMap<Client, Commande> mapClientCommande;
    private ArrayList<Commande> listeCommandes;
    private int nombreCasiersRestants;
    public final static int MAX_CASIERS_CLIENT = 3;
    public static Comparator<Client> comparator = new ComparateurClient();

    /**
     * debute une session de vente
     *
     * @param nombreCasiersMisEnVente le nombre de casiers mis en vente
     * @throws IllegalArgumentException s'il n'y a pas au moins un casier a vendre
     */
    public SessionDeVente(int nombreCasiersMisEnVente) {
        if (nombreCasiersMisEnVente <= 0)
            throw new IllegalArgumentException();
        this.nombreCasiersRestants = nombreCasiersMisEnVente;

        filePriorite = new PriorityQueue<Client>(comparator);

        ensembleClientsActuellementDansFile = new HashSet<Client>();
        mapClientCommande = new HashMap<Client, Commande>();
        listeCommandes = new ArrayList<Commande>();
    }


    public int getNombreCasiersRestants() {
        return nombreCasiersRestants;
    }

    /**
     * ajoute, si possible, le client dans la file d'attente
     * le client ne peut pas deja y etre
     * si client a deja une commande lors de cette session de vente, le max de casiers autorise n'est pas deja atteint
     * s'il reste encore des casiers a vendre
     *
     * @param client le client a ajouter
     * @return true si l'ajout a pu se faire, false sinon
     * @throws IllegalArgumentException si le client est null ou vide
     */
    public boolean placerDansFileAttente(Client client) {
        if (client.equals(""))
            throw new IllegalArgumentException();
        if (nombreCasiersRestants == 0)
            return false;
        if (ensembleClientsActuellementDansFile.contains(client))
            return false;

        if (mapClientCommande.containsKey(client)) {
            Commande commande = mapClientCommande.get(client);
            if (commande.getNombreCasiersDemandes() == MAX_CASIERS_CLIENT) {
                return false;
            }
        }


        ensembleClientsActuellementDansFile.add(client);

        filePriorite.add(client);

        return true;
    }

    /**
     * retire de la file d'attente le client de tete
     *
     * @return le client de tete ou null si la file est vide
     */
    public Client selectionnerClientSuivant() {
        if (ensembleClientsActuellementDansFile.isEmpty())
            return null;
        Client client = filePriorite.poll();
        ensembleClientsActuellementDansFile.remove(client);

        return client;
    }

    /**
     * ajoute, si possible, une nouvelle commande
     * le nombre de casiers restants doit etre suffisant pour satisfaire completement la commande
     * (il n'y a pas de commande partielle)
     * le nombre de casiers demandes ne peut depasser le max autorise
     *
     * @param client                le client qui fait la demande
     * @param nombreCasiersDemandes le nombre de casiers demandes
     * @return true si la commande a pu etre faite, false sinon
     * @throws IllegalArgumentException si le client est null ou vide
     *                                  ou si le nombre de casiers demandés est <=0
     * @throws IllegalStateException    si le client a deja fait une commande
     */
    public boolean passerNouvelleCommande(Client client, int nombreCasiersDemandes) {
        if (client.equals("") || nombreCasiersDemandes <= 0)
            throw new IllegalArgumentException();

        if (mapClientCommande.containsKey(client))
            throw new IllegalStateException();

        if (nombreCasiersDemandes>nombreCasiersRestants || nombreCasiersDemandes > MAX_CASIERS_CLIENT )
            return false;

        Commande commande = new Commande(client, nombreCasiersDemandes);
        mapClientCommande.put(client,commande);
        listeCommandes.add(commande);
        nombreCasiersRestants -=  nombreCasiersDemandes;
        mapClientCommande.put(client,commande);

        //diminue de 1 la priorite
        client.setPriorite(client.getPriorite()-1);

        return true;
    }

    public void cloturerSession(){
        System.out.println("Cloture***************************");
        System.out.println(filePriorite.size());

        for (Client client : filePriorite) {
            if (!mapClientCommande.containsKey(client)){
                int prioriteChange =client.getPriorite()+1;
                client.setPriorite(prioriteChange);
                System.out.println("client.getNom() = " + client.getNom());
                System.out.println("XXXXXXXXXXXXX");
            }


        }
    }


    /**
     * modifie, si possible, une commande existante
     * le nombre de casiers restants doit etre suffisant
     * (il n'y a pas de commande partielle)
     * le nombre total de casiers apres ajout de ce nombre de casiers supplementaires ne peut depasser le max autorise
     *
     * @param client                      le client qui veut modifier sa commande
     * @param nombreCasiersDemandesEnPlus le nombre de casiers a ajouter au nombre de casiers deja commande
     * @return true si la commande a pu etre modifiee, false sinon
     * @throws IllegalArgumentException si le client est null ou vide
     *                                  ou si le nombre de casiers demandes est <= 0
     * @throws IllegalStateException    si le client n'a pas encore fait de commande lors de cette session de commande
     */
    public boolean modifierCommande(Client client, int nombreCasiersDemandesEnPlus) {
        if (client.equals("") || nombreCasiersDemandesEnPlus <= 0)
            throw new IllegalArgumentException();

        if (!mapClientCommande.containsKey(client))
           throw new IllegalStateException();
       Commande commande = mapClientCommande.get(client);
       int nombreCommandeClient = commande.getNombreCasiersDemandes();
       if (nombreCasiersDemandesEnPlus+nombreCommandeClient>MAX_CASIERS_CLIENT || nombreCasiersRestants == 0)
           return false;
       commande.setNombreCasiersDemandes(nombreCommandeClient+nombreCasiersDemandesEnPlus);
       nombreCasiersRestants -= nombreCasiersDemandesEnPlus;

       return true;
    }


    public String toString() {
        // cette methode ne sera pas evaluee
        // elle peut-etre interessante a appeler en cas de bug
        // n'hesitez pas a la completer
        String texte ="le nombre de casiers restants : " + nombreCasiersRestants
                + "\nla file d'attente : ";
        for (Client client : filePriorite) {
             texte += client.getNom() +" priorite = " + client.getPriorite() + "   ";
        }

        texte +=  "\nles commandes " + listeCommandes;
        return  texte;
    }

}

		
	
	
	
	
	

