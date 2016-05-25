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
	public Client ajouteClient(Client client) throws BanqueException{
		try {
			return this.ajouteClient(client.getNom(), client.getPrenom());
		}
		catch (BanqueException be) {
//			System.out.println(be.getMessage());
			throw be;
		}
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
				this.getClients().add(client);							
			}			
			catch (BanqueException be) {
//				System.out.println(be.getMessage());
				throw be;
			}
		} else {
			client = this.getClient(nom, prenom);
		}
		return client;
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

// Add a client in the List of client if not exists.
// Idem ajouteClient. Return true anyway
	public boolean ouvreCompte(Client client) {
		return ouvreCompte(client,0);
	}

// Add a client in the List of client if not exists.
// Idem ajouteClient, but return true instead of a client
	public boolean ouvreCompte(Client client,double depot) {
		try {
			this.ajouteClient(client);
			Compte compte = new Compte(client,depot);
			client.addCompte(compte);
			this.getComptes().add(compte) ;
		}
		catch (BanqueException be) {
			
		}
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

	public boolean supprimeClient(){
		return true;
		
	}
	private boolean existeClient(String nom, String prenom) {
		return !(this.getClient(nom,prenom) == null);
	}
	
}
