package commandLine;

import static commandLineMenus.rendering.examples.util.InOut.getString;

import java.time.LocalDate;

import commandLineMenus.ListOption;
import commandLineMenus.Menu;
import commandLineMenus.Option;
import personnel.Employe;




public class EmployeConsole 
{
	
	private Option afficher(final Employe employe)
	{
		return new Option("Afficher l'employé", "l", () -> {System.out.println(employe);});
	}

	ListOption<Employe> editerEmploye()
	{
		return (employe) -> editerEmploye(employe);		
	}

	Option editerEmploye(Employe employe)
	{
			Menu menu = new Menu("Gérer le compte " + employe.getNom(), "c");
			menu.add(afficher(employe));
			menu.add(changerNom(employe));
			menu.add(changerPrenom(employe));
			menu.add(changerMail(employe));
			menu.add(changerPassword(employe));
			menu.add(changeDateArrivee(employe));
			menu.add(changeDateDepart(employe));
		//	menu.add(changerAdministrateur(employe));
			menu.addBack("q");
			return menu;
	}

	
	private Option changerNom(final Employe employe)
	{
		return new Option("Changer le nom", "n", 
				() -> {employe.setNom(getString("Nouveau nom : "));}
			);
	}
	
	
	private Option changerPrenom(final Employe employe)
	{
		return new Option("Changer le prénom", "p", () -> {employe.setPrenom(getString("Nouveau prénom : "));});
	}
	
	
	private Option changerMail(final Employe employe)
	{
		return new Option("Changer le mail", "e", () -> {employe.setMail(getString("Nouveau mail : "));});
	}
	
	private Option changerPassword(final Employe employe)
	{
		return new Option("Changer le password", "x", () -> {employe.setPassword(getString("Nouveau password : "));});
	}
	
	
	private Option changeDateArrivee(final Employe employe) {
		
		return new Option("Changer la date d'arriv�e", "d", ()->{
			try {
			    
				employe.setDateArrivee(LocalDate("Votre date d'arriv�e :"));
		    } 
			catch (commandLine.DateInvalideException e) {
			e.printStackTrace();
		}});
	}
	
	
	private Option changeDateDepart(final Employe employe) {
		return new Option("Changer la date de d�part", "b", ()->{
			try {
			  employe.setDateDepart(LocalDate("Votre date de d�part :"));
		 } 
			catch (DateInvalideException e) {
			e.printStackTrace();
		}});
	}
	
	//private Option changerAdministrateur(final Employe employe) {
	//	  return new Option("Changer l'administrateur", "a", ()->{employe.setAdministrateur(Employe(Employe administrateur)););
	//} 

	private LocalDate LocalDate(String string) {
		return null;
	}
	
	
	

}
