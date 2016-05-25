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
		Client cl = this.getClient(client.getNom(), client.getPrenom());
		if (cl == null) {
				this.getClients().add(client);			
		}
		return client;	
	}

	// Add the client in parameters in the list of clients
	// if not found in the list.
	// Return the object client created or found in the List
	// of clients
	public Client ajouteClient(String nom, String prenom) {
		try {
			Client client = new Client(nom,prenom);
			return this.ajouteClient(client);
		}
		catch (BanqueException be) {
			System.out.println(be.getMessage());
			return null;
		}
	}
	
	public boolean supprimeClient(Client client) {
		return this.getClients().remove(client);		
	}

	public boolean supprimeClient(String nom, String prenom) {
			Client client = this.getClient(nom, prenom);
			if (!(client == null)) {
				return this.getClients().remove(client);		
			}
			return false;
	}

// Add a client in the List of client.
// Idem ajouteClient, but return true instead of a client
	public boolean ouvreCompte(Client client) {
		this.ajouteClient(client);
		this.getComptes().add(new Compte(client,0)) ;
		return true;
	}

// Add a client in the List of client.
// Idem ajouteClient, but return true instead of a client
	public boolean ouvreCompte(Client client,double depot) {
		this.ajouteClient(client);
		return true;
	}

}
