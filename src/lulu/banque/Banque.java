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
	
	public Client getClient(String nom, String prenom) {
		for (Client client:this.getClients()){
			if (client.getNom().equals(nom) && client.getPrenom().equals(prenom)) {
				return client;
			}
		}
		throw new RuntimeException("Cette personne n'est pas cliente de la banque");
	}	

	public Compte getCompte(String num) {
		for (Compte compte:this.getComptes()){
			if (compte.getNum().equals(num)) {
				return compte;
			}
		}
		throw new RuntimeException("Cette compte n'existe pas");
	}	

	public Client ajouteClient(Client client) {
		this.getClients().add(client);
		return client;	
	}

	public Client ajouteClient(String nom, String prenom) {
		try {
			Client client = new Client(nom,prenom);
			return this.ajouteClient(client);
		}
		catch (BanqueException be) {
			System.out.println(be.getMessage());
		}
		return null;
	}
	
	public boolean supprimeClient(Client client) {
		return this.getClients().remove(client);		
	}
	
}
