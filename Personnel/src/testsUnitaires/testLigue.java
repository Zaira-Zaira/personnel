package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;

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
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty", "15/02/2020", ""); 
		assertEquals(employe, ligue.getEmployes().first());
	}
	
	@Test
	 String getNom() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		String employe = ligue.getNom();
		return employe;
	}
	
	@Test
	 public Employe getAdministrateur() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe employe = ligue.getAdministrateur();
				return employe;
	}
}


class testEmploye
{
	GestionPersonnel gestionPersonnel = GestionPersonnel.getGestionPersonnel();
	void createEmploye() throws SauvegardeImpossible
	{
		Employe employe = gestionPersonnel.addEmploye("John", "Doe", "johndoe@gmail.com", "john1234", "07/06/2020", "");
		assertEquals("Fléchettes", employe.getNom());
	}
	@Test
	public String getNom()  throws SauvegardeImpossible
	{
	   Ligue ligue = gestionPersonnel.addEmploye();
       String employeNom = ligue.getNom();
       return employeNom;
	}
	
	@Test
	public String getPrenom()  throws SauvegardeImpossible
	{
	   Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
       String employePrenom = ligue.getNom();
       return employePrenom;
	}
	
	@Test
	void setPrenom()  throws SauvegardeImpossible
	{
	   Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
       String employePrenomSettled = ligue.setNom("Alice");
       assertEquals(employePrenomSettled, ligue.getNom());
	}
	
	@Test
	public String getMail()  throws SauvegardeImpossible
	{
	   Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
       String employeMail = ligue.getMail();
       return employeMail;
	}
	
	@Test 
	void setMail()  throws SauvegardeImpossible
	{
	   Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
       String employePrenomSettled = gestionPersonnel.setMail("Alice@gmail.com");
	}
	
	@Test
	public boolean checkPassword() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe employe = gestionPersonnel.checkPassword("alica@gmail.com");
	}
	
	@Test
	void setPassword()  throws SauvegardeImpossible
	{
	   Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
       String employePassword = ligue.setPassword("Alice124");
	}
	@Test
	public Employe getLigue() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe employe = ligue.getLigue()
		return employe;
	}
	
	@Test
	public String getDateArrivee() 
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		String employe = ligue.getDateArrivee();
	}
	
	public String getDateDepart()
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		String employe = ligue.getDateDepart();
	}
	
}


