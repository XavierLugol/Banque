package lulu.banque;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BanqueTest {
	private Banque banque;
	private Client xlu;

	@Before
	public void setup() {
		// Given
		banque = new Banque();
		try {
			xlu = new Client("Lugol","Xavier");
			Client xlu2 = new Client("Lugol","Xavier");
			banque.ajouteClient(xlu);
			banque.ajouteClient(new Client("Dupond","Jean"));
			banque.ajouteClient(new Client("Lugol","Xavier"));
			banque.ajouteClient(xlu2);
		}
		catch (BanqueException be) {			
		}
	}

	@Test
	public void chercheNomError() {
			// When
		Client cli = banque.getClient("Rififi","Xavier");
		//Then
		assertEquals(null,cli);
		} 
	
	@Test
	public void chercheNom() {
		// When
			Client clie = banque.getClient("Lugol","Xavier");
			//then
			assertEquals(clie.getNom(),"Lugol"); 
	}

	@Test
	public void testeNombreClients() {
		// When
		int nb = banque.getClients().size();
		//then
		assertEquals(nb,2); 
	}

	@Test
	public void testeremoveClients() {
		// When
		banque.supprimeClient(xlu);
		int nb = banque.getClients().size();
		//then
		assertEquals(nb,1); 
	}

	@Test
	public void testeremoveClientsParNom() {
		// When
		banque.supprimeClient("Lugol","Xavier");
		int nb = banque.getClients().size();
		//then
		assertEquals(nb,1); 
	}
}
