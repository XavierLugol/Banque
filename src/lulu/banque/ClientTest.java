package lulu.banque;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ClientTest {
	private Client client;
	@Before
	public void setup() {
		// Given
		client = new Client("Lugol","Xavier");
	}

	@Test
	public void afficheNom() {
		// When
		String res = client.getNom();
		// Then
		assertEquals("Lugol", res);
	}
	
	@Test
	public void nombreCompte() {
		// Given
		client.addCompte(new Compte(client));
		client.addCompte(new Compte(client));
		// When
		int res = client.numberComptes();
		// Then
		assertEquals(2, res);
	}

}