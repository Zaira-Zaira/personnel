package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import commandLine.DateInvalideException;
import personnel.*;


class testEmploye 
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
	void getDateDepart() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("nomLigue");
		Employe employe = ligue.addEmploye("Joseph", "Mozart", "josephmozart@gmail.com", "admin", LocalDate.parse("2016-10-05"), LocalDate.parse("2017-07-15"));
		assertEquals(LocalDate.parse("2018-12-30"), employe.getDateDepart());
	}
	
	@Test
	void setDateDepart() throws SauvegardeImpossible, DateInvalideException
	{
		try {
			Ligue ligue = gestionPersonnel.addLigue("nomLigue");
			Employe employe = ligue.addEmploye("Joseph", "Mozart", "josephmozart@gmail.com", "admin", LocalDate.parse("2016-10-05"), LocalDate.parse("2017-09-20"));
			employe.setDateDepart(LocalDate.parse("2019-01-21"));
			assertEquals(LocalDate.parse("2019-01-21"), employe.getDateDepart());
			employe.setDateDepart(null);
			assertEquals(null, employe.getDateDepart());
			employe.setDateDepart(LocalDate.parse("2019-01-13"));
		}
		catch (DateInvalideException err) {
			assertTrue(err instanceof DateInvalideException);
		}
	}
	
	@Test
	void getDateArrivee() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("nomLigue");
		Employe employe = ligue.addEmploye("Joseph", "Mozart", "josephmozart@gmail.com", "admin", LocalDate.parse("2016-10-05"), LocalDate.parse("2017-07-15"));
		assertEquals(LocalDate.parse("2019-04-18"), employe.getDateArrivee());
	}
	
	@Test
	void setDateArrivee() throws SauvegardeImpossible, DateInvalideException
	{
		try {
			Ligue ligue = gestionPersonnel.addLigue("nomLigue");
			Employe employe = ligue.addEmploye("Joseph", "Mozart", "josephmozart@gmail.com", "admin", LocalDate.parse("2016-10-05"), LocalDate.parse("2017-09-20"));
			employe.setDateDepart(LocalDate.parse("2016-01-21"));
			assertEquals(LocalDate.parse("2016-01-21"), employe.getDateArrivee());
			employe.setDateArrivee(null);
			assertEquals(null, employe.getDateArrivee());
			employe.setDateArrivee(LocalDate.parse("2016-01-13"));
		} 
		catch (DateInvalideException err) {
			assertTrue(err instanceof DateInvalideException);
		}
	}
	
	
}


