
public class Reservation {
	
	private String client;
	private int nombreMenusDemandes;

	/**
	 * 
	 * @param client
	 * @param nombreMenusDemandes
	 */
	public Reservation(String client, int nombreMenusDemandes) {
		super();
		this.client = client;
		setNombreMenusDemandes(nombreMenusDemandes);
	}

	public String getClient() {
		return client;
	}

	public int getNombreMenusDemandes() {
		return nombreMenusDemandes;
	}

	public void setNombreMenusDemandes(int nombreMenusDemandes) {
		if(nombreMenusDemandes<0)
			throw new IllegalArgumentException();
		this.nombreMenusDemandes = nombreMenusDemandes;
	}

	@Override
	public String toString() {
		return "Reservation [client=" + client + ", nombreMenusDemandes="
				+ nombreMenusDemandes + "]";
	}
	
	

	
	
	
}
