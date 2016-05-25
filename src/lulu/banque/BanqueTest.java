package lulu.banque;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BanqueTest {
	private Banque banque;

	@Before
	public void setup() {
		// Given
		banque = new Banque();
	}

	@Test(expected=RuntimeException.class)
	public void chercheNomError() {
		// When
		banque.getClient("Lugol","Xavier");
	}
	
	@Test
	public void chercheNom() {
		// When
		try {
			Client cl = new Client("Lugol","Xavier");
			banque.ajouteClient(cl);
			Client clie = banque.getClient("Lugol","Xavier");
			String nom = clie.getNom();
//			int nb = banque.nombreClients();
			//then
			assertEquals(nom,"Lugol"); 
		}
		catch (BanqueException be){
			System.out.println(be.getMessage());
		}
	}

	@Test
	public void testeNombreClients() {
		// When
//		banque.ajouteClient(new Client("Lugol","Xavier"));
//		banque.ajouteClient(new Client("Dupond","Jean"));
		int nb = banque.getClients().size();
		//then
		assertEquals(nb,2); 
	}
}
