package commandLine;

import static commandLineMenus.rendering.examples.util.InOut.getString;

import java.time.LocalDate;

import commandLineMenus.ListOption;
import commandLineMenus.Menu;
import commandLineMenus.Option;
import personnel.Employe;
import personnel.SauvegardeImpossible;




public class EmployeConsole 
{
	
	private Option afficher(final Employe employe)
	{
		return new Option("Afficher l'employÃ©", "l", () -> {System.out.println(employe);});
	}

	ListOption<Employe> editerEmploye()
	{
		return (employe) -> editerEmploye(employe);		
	}

	
	Option editerEmploye(Employe employe)
	{
			Menu menu = new Menu("GÃ©rer le compte " + employe.getNom(), "c");
			menu.add(afficher(employe));
			menu.add(changerNom(employe));
			menu.add(changerPrenom(employe));
			menu.add(changerMail(employe));
			menu.add(changerPassword(employe));
			menu.add(changeDateArrivee(employe, null));
			menu.add(changeDateDepart(employe, null));
			menu.addBack("q");
			return menu;
	}

	
	private Option changerNom(final Employe employe)
	{
		return new Option("Changer le nom", "n", 
				() -> {employe.setNom(getString("Nouveau nom : "));
				try {
					employe.update("nom_employe");
				} catch (SauvegardeImpossible e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			);
	}
	
	
	private Option changerPrenom(final Employe employe)
	{
		return new Option("Changer le prÃ©nom", "p", () -> {employe.setPrenom(getString("Nouveau prÃ©nom : "));
		try {
			employe.update("prenom_employe");
		} catch (SauvegardeImpossible e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		});
	}
	
	
	private Option changerMail(final Employe employe)
	{
		return new Option("Changer le mail", "e", () -> {employe.setMail(getString("Nouveau mail : "));
		try {
			employe.update("mail_employe");
		} catch (SauvegardeImpossible e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		});
	}
	
	
	
	private Option changerPassword(final Employe employe)
	{
		return new Option("Changer le password", "x", () -> {employe.setPassword(getString("Nouveau password : "));
		try {
			employe.update("password_employe");
		} catch (SauvegardeImpossible e) {
			e.printStackTrace();
		}
		});
	}
	
	
	
	private Option changeDateArrivee(final Employe employe, LocalDate dateArrivee) {
		
		return new Option("Changer la date d'arrivée", "d", ()->
		{
			try {
			    System.out.println("Date d'arrivée");
				employe.setDateArrivee(LocalDate.parse(getString("Date d'arrivée (YYYY-MM-DD) : ")));
				employe.update("dateArrivee_employe");
		    } 
			catch (commandLine.DateInvalideException e) {
				System.out.println("Date d'arrivée incorrecte. ");
		} catch (SauvegardeImpossible e) {
				e.printStackTrace();
			}});
	}
	
	
	private Option changeDateDepart(final Employe employe, LocalDate dateDepart) {
		return new Option("Changer la date de départ", "b", ()->
		{
			try {
			  employe.setDateDepart(dateDepart);
			  employe.update("dateDepart_employe");
		 } 
			catch (DateInvalideException e) {
			e.printStackTrace();
		} catch (SauvegardeImpossible e) {
				e.printStackTrace();
			}});
	}
	
	


}
