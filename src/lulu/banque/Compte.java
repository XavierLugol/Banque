package lulu.banque;

public class Compte {
	private String num;
	private double solde;
	private Client client;
	private static int numCompte = 0;


	public Compte(Client client) {
//		super();
		this.setClient(client);
	}
	
	public Compte(Client client,double depot) {
//		super();
		this.setClient(client);
		this.setSolde(depot);
		Compte.numCompte=Compte.numCompte + 1;
		this.setNum(new String(new Integer(Compte.numCompte).toString()));
	}
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	public void credite(double montant){
		this.setSolde(montant + this.getSolde());
		
	}
	
	public void debite(double montant){
		this.setSolde(montant - this.getSolde());
		
	}

	@Override
	public String toString() {
		return "Compte [num=" + num + ", solde=" + solde + ", client=" + client + "]";
	}
	
	
}
