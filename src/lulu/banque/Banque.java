package lulu.banque;

import java.util.ArrayList;
import java.util.List;

public class Banque {
	private List<Compte> comptes = new ArrayList<>();
	private List<Client> clients = new ArrayList<>();	
	
	public List<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	
	public List<Client> getClients() {
		return clients;
	}
	
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
// Return the object Client having the same nom and prenom
// that the parameters in the List of clients. Return null if not found
	public Client getClient(String nom, String prenom) {
		for (Client client:this.getClients()){
			if (client.getNom().equals(nom) && client.getPrenom().equals(prenom)) {
				return client;
			}
		}
		return null;
	}	

// Return the object Compte having the same num
// that the parameters in the List of comptes. Return null if not found
	public Compte getCompte(String num) {
		for (Compte compte:this.getComptes()){
			if (compte.getNum().equals(num)) {
				return compte;
			}
		}
		return null;
	}	

	// Add the client in parameters in the list of clients
	// if not found in the list.
	// Return the client in parameter ???
	public Client ajouteClient(Client client) {
		if (!this.existeClient(client.getNom(), client.getPrenom())) {
				this.getClients().add(client);							
		} 
		return client;
	}

	// Add the client in parameters in the list of clients
	// if not found in the list.
	// Return the object client created or found in the List
	// of clients
	public Client ajouteClient(String nom, String prenom) throws BanqueException {
		Client client;
		if (!this.existeClient(nom, prenom)) {
			try {
				client = new Client(nom,prenom);
			}			
			catch (BanqueException be) {
				throw be;
			}
		} else {
			client = this.getClient(nom, prenom);
		}
		return this.ajouteClient(client);
	}
	
	public boolean supprimeClient(Client client) {
		boolean result = false;
		
		if (!(client == null)) {
			for (Compte compte:client.getComptes()) {
				this.getComptes().remove(compte);
			}
			result = this.getClients().remove(client);
		}
		return result;
	}

	public boolean supprimeClient(String nom, String prenom) {
		Client client = this.getClient(nom, prenom);
		return this.supprimeClient(client);		
	}

// Add a client in the List of client if not exists.
// Idem ajouteClient. Return true anyway
	public boolean ouvreCompte(Client client) {
		return ouvreCompte(client,0);
	}

// Add a client in the List of client if not exists.
// Idem ajouteClient, but return true instead of a client
	public boolean ouvreCompte(Client client,double depot) {
		this.ajouteClient(client);
		Compte compte = new Compte(client,depot);
		client.addCompte(compte);
		this.getComptes().add(compte) ;			
		return true;
	}

	public boolean ouvreCompte(String nom, String prenom) {
		return this.ouvreCompte(nom, prenom, 0);
	}

	public boolean ouvreCompte(String nom, String prenom, double depot) {
		try {
			this.ajouteClient(nom, prenom);
			Client client = this.getClient(nom, prenom);
			return this.ouvreCompte(client, depot);
		}
		catch (BanqueException be) {
			System.out.println(be.getMessage());
			return false;
		}
	}

	public boolean fermeCompte(String num) {
		// Recherche du compte correspondant ) num
		for (Compte compte:this.getComptes()) {
			if (compte.getNum().equals(num)) {
				return fermeCompte(compte);
			}
		}
		return false;
	}
	
	public boolean fermeCompte(Compte compte) {
		boolean result = false; 
		result = compte.getClient().getComptes().remove(compte);
		for (Compte compteliste:this.getComptes()) {
			if (compteliste.getNum().equals(compte.getNum())) {
				return this.getComptes().remove(compteliste);
			}
		}
		return result;
	}

	public String toString() {
		return "Banque avec " + this.getClients().size() + " clients et "
				+ this.getComptes().size() + " comptes";
	}
	
	private boolean existeClient(String nom, String prenom) {
		return !(this.getClient(nom,prenom) == null);
	}
	
}
