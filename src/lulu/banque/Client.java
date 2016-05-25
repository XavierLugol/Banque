package lulu.banque;

import java.util.ArrayList;
import java.util.List;

public class Client {
	private String nom;
	private String prenom;
	private String nomComplet;
	private List<Compte> comptes = new ArrayList<>();
	
	public Client(String nom,String prenom){
		this.setNom(nom);
		this.setPrenom(prenom);
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNomComplet() {
		return nomComplet;
	}
	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}
	public List<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(List comptes) {
		this.comptes = comptes;
	}
	public void addCompte(Compte compte) {
		this.comptes.add(compte);
	}

	public void removeCompte(Compte compte) {
		this.comptes.remove(compte);
	}

	public int numberComptes() {
		return this.comptes.size();
	}
	
	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + "]";
	}
	

}
