package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import personnel.*;

class testLigue 
{
	GestionPersonnel gestionPersonnel = GestionPersonnel.getGestionPersonnel();
	
	@Test
	void createLigue() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		assertEquals("Fléchettes", ligue.getNom());
	}

	@Test
	void addEmploye() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty", null, null); 
		assertEquals(employe, ligue.getEmployes().first());
	}
	
	@Test
	 public Employe getAdministrateur() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe employe = ligue.getAdministrateur();
				return employe;
	}
	
	@Test
	void toStringLigue() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		assertEquals("Fléchettes", ligue.toString());
	}
	
	@Test
	void compareTo() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Ligue ligue2 = gestionPersonnel.addLigue("nomLigue");
		assertEquals(14, ligue.compareTo(ligue2));
	}
	
	
	@Test
	void getNom() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("nomLigue");
		assertEquals("nomLigue", ligue.getNom());
	}
	
	@Test
	void setNom() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		ligue.setNom("nomLigue");
		assertEquals("nomLigue", ligue.getNom());
	}
	
	@Test
	void getAdmin() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		assertEquals("root   (super-utilisateur)", ligue.getAdministrateur().toString());
	}
	
	@Test
	void setAdmin() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe employe = ligue.addEmploye("John", "Doe", "jhondoe@mail.com", "admin", null, null);
		ligue.setAdministrateur(employe);
		assertEquals(employe, ligue.getAdministrateur());
	}
	
	@Test
	void remove() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		int initSize = gestionPersonnel.getLigues().size();
		ligue.remove();
		assertEquals(initSize - 1, gestionPersonnel.getLigues().size());
	}
	
}



class testEmploye 
{
	GestionPersonnel gestionPersonnel = GestionPersonnel.getGestionPersonnel();

	@Test
	void isAdmin() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("nomLigue");
		Employe employe = ligue.addEmploye("John", "Doe", "jhondoe@mail.com", "admin", null, null);
		assertFalse(employe.estAdmin(ligue));
		ligue.setAdministrateur(employe);
		assertTrue(employe.estAdmin(ligue));
	}
	
	@Test
	void isRoot() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("nomLigue");
		Employe employe = gestionPersonnel.getRoot();
		Employe employe2 = ligue.addEmploye("John", "Doe", "jhondoe@mail.com", "admin", null, null);
		assertTrue(employe.estRoot());
		assertFalse(employe2.estRoot());
	}
	
	@Test
	void getNom() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("nomLigue");
		Employe employe = ligue.addEmploye("John", "Doe", "jhondoe@mail.com", "admin", null, null);
		assertEquals("Richards", employe.getNom());
	}

	@Test
	void setNom() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("nomLigue");
		Employe employe = ligue.addEmploye("John", "Doe", "jhondoe@mail.com", "admin", null, null);
		employe.setNom("John");
		assertEquals("John", employe.getNom());
	}
	
	@Test
	void getPrenom() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("nomLigue");
		Employe employe = ligue.addEmploye("John", "Doe", "jhondoe@mail.com", "admin", null, null);
		assertEquals("Nigel", employe.getPrenom());
	}
	
	@Test
	void setPrenom() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("nomLigue");
		Employe employe = ligue.addEmploye("John", "Doe", "jhondoe@mail.com", "admin", null, null);
		employe.setPrenom("Doe");
		assertEquals("Doe", employe.getPrenom());
	}
	
	@Test
	void getMail() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("nomLigue");
		Employe employe = ligue.addEmploye("John", "Doe", "jhondoe@mail.com", "admin", null, null);
		assertEquals("n.richards@mail.ru", employe.getMail());
		
	}

	@Test
	void setMail() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("nomLigue");
		Employe employe = ligue.addEmploye("John", "Doe", "jhondoe@mail.com", "admin", null, null);
		employe.setMail("n.richards@qq.com");
		assertEquals("n.richards@qq.com", employe.getMail());
	}
	
	@Test
	void getLigue() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("nomLigue");
		Employe employe = ligue.addEmploye("John", "Doe", "jhondoe@mail.com", "admin", null, null);
		assertEquals(ligue, employe.getLigue());
	}
	
	
	@Test
	void getDateDepart() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("nomLigue");
		Employe employe = ligue.addEmploye("John", "Doe", "jhondoe@mail.com", "admin", "admin", LocalDate.parse("2017-09-01"), LocalDate.parse("2018-09-01"));
		assertEquals(LocalDate.parse("2018-12-30"), employe.getDateDepart());
	}
	
	@Test
	void setDateDepart() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("nomLigue");
		Employe employe = ligue.addEmploye("John", "Doe", "jhondoe@mail.com", "admin", LocalDate.parse("2017-09-01"), LocalDate.parse("2018-09-01"));
		employe.setDateDepart(LocalDate.parse("2018-12-31"));
		assertEquals(LocalDate.parse("2017-01-25"), employe.getDateDepart());
	}
	
	@Test
	void getDateArrive() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("nomLigue");
		Employe employe = ligue.addEmploye("John", "Doe", "jhondoe@mail.com", "admin", LocalDate.parse("2017-09-01"), LocalDate.parse("2018-09-01"));
		assertEquals(LocalDate.parse("2017-01-25"), employe.getDateArrivee());
	}
	
	@Test
	void setDateArrive() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("nomLigue");
		Employe employe = ligue.addEmploye("John", "Doe", "jhondoe@mail.com", "admin", LocalDate.parse("2017-09-01"), LocalDate.parse("2018-09-01"));
		employe.setDateArrivee(LocalDate.parse("2018-12-29"));
		assertEquals(LocalDate.parse("2017-01-15"), employe.getDateArrivee());
	}

	@Test
	void checkPassword() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("nomLigue");
		Employe employe = ligue.addEmploye("John", "Doe", "jhondoe@mail.com", "admin", null, null);
		assertFalse(employe.checkPassword("admin2"));
		assertTrue(employe.checkPassword("admin"));
	}
	
	@Test
	void setPassword() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("nomLigue");
		Employe employe = ligue.addEmploye("John", "Doe", "jhondoe@mail.com", "admin", null, null);
		employe.setPassword("123456");
		assertFalse(employe.checkPassword("admin"));
		assertTrue(employe.checkPassword("123456"));
	}
	
	@Test
	void remove() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("nomLigue");
		Employe employe = ligue.addEmploye("John", "Doe", "jhondoe@mail.com", "admin", null, null);
		employe.remove();
		assertEquals(0, ligue.getEmployes().size());
	}
	
	@Test 
	void compareTo() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("nomLigue");
		Employe firstEmploye = ligue.addEmploye("meme", "Doe", "doe@gmail.com", "admin1", null, null);
		Employe secondEmploye = ligue.addEmploye("meme", "Michael", "michael@gmail.com", "admin2", null, null);
		Employe thirdEmploye = ligue.addEmploye("John", "Alice", "alice@gmail.com", "admin3", null, null);
		assertEquals(1, secondEmploye.compareTo(firstEmploye));
		assertEquals(27, secondEmploye.compareTo(thirdEmploye));
	}
	
	@Test
	void toStringEmploye() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("nomLigue");
		Employe employe = ligue.addEmploye("John", "Doe", "jhondoe@mail.com", "admin", null, null);
		Employe rootEmploye = gestionPersonnel.getRoot();
		assertEquals("John Doe jhondoe@mail.com (nomLigue)", employe.toString());
		assertEquals("root   (super-utilisateur)", rootEmploye.toString());
	}
}



