package jdbc;
import java.util.HashMap;
import java.util.Map;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Map;

import personnel.*;
import java.util.Map;
import java.util.Map;
public class JDBC implements Passerelle 
{
	Connection connection;

	public JDBC()
	{
		try
		{
			Class.forName(Credentials.getDriverClassName());
			connection = DriverManager.getConnection(Credentials.getUrl(), Credentials.getUser(), Credentials.getPassword());
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("Pilote JDBC non installÃ©.");
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}
	
	@Override
	public GestionPersonnel getGestionPersonnel() 
	{
		GestionPersonnel gestionPersonnel = new GestionPersonnel();
		try 
		{
			String requete = "select * from ligue";
			Statement instruction = connection.createStatement();
			ResultSet ligues = instruction.executeQuery(requete);
			
			while (ligues.next())
				gestionPersonnel.addLigue(ligues.getInt("num_ligue"), ligues.getString("nom_ligue"));
		//	PreparedStatement result = connection.prepareStatement("SELECT * FROM employe WHERE num_ligue = ?");
			//result.setInt(1, ligues.getInt("num_ligue"));
		//	ResultSet employe = result.executeQuery();
			//Ligue ligue = gestionPersonnel.getLigues().last();
			
			//while(employe.next()) {
				//int id = employe.getInt("id_employe");
		//		String  nom = employe.getString("nom_employe");
			//	String  prenom = employe.getString("prenom_employe");
				//String	mail = employe.getString("mail_emp");
	//			String	psw = employe.getString("password_employe");
				
		//		LocalDate dateArrivee = employe.getString("date_depart") != null ? LocalDate.parse(employe.getString("date_arrive")) : null;
			//	LocalDate dateDepart = employe.getString("date_depart") != null ? LocalDate.parse(employe.getString("date_depart")) : null;
				
			//	Employe employes = ligue.addEmploye(nom, prenom, mail, psw, dateArrivee, dateDepart, id);
			//}
			
			String requete2 = "select * from employe";
			Statement instruction2 = connection.createStatement();
			ResultSet employes = instruction2.executeQuery(requete2);
			while (employes.next())
				gestionPersonnel.addLigue(employes.getInt(1), employes.getString(2));
			
			
			
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
		return gestionPersonnel;
	}

	@Override
	public void sauvegarderGestionPersonnel(GestionPersonnel gestionPersonnel) throws SauvegardeImpossible 
	{
		close();
	}
	
	public void close() throws SauvegardeImpossible
	{
		try
		{
			if (connection != null)
				connection.close();
		}
		catch (SQLException e)
		{
			throw new SauvegardeImpossible(e);
		}
	}
	
	@Override
	public int insert(Ligue ligue) throws SauvegardeImpossible 
	{
		try 
		{
			PreparedStatement instruction;
			instruction = connection.prepareStatement("insert into ligue (nom_ligue) values(?)", Statement.RETURN_GENERATED_KEYS);
			instruction.setString(1, ligue.getNom());		
			instruction.executeUpdate();
			ResultSet id = instruction.getGeneratedKeys();
			id.next();
			return id.getInt(1);
		} 
		catch (SQLException exception) 
		{
			exception.printStackTrace();
			throw new SauvegardeImpossible(exception);
		}		
	}
	
	@Override
	public void updateLigue(Ligue ligue) throws SauvegardeImpossible 
	{
		try
		{
			PreparedStatement instruction;
			instruction = connection.prepareStatement("UPDATE ligue SET nom_ligue = ? WHERE num_ligue = ?");
			instruction.setString(1, ligue.getNom());
			instruction.setInt(2, ligue.getId());
			instruction.executeUpdate();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new SauvegardeImpossible(e);
		}
	}
	
	@Override
	public void deleteLigue(Ligue ligue) throws SauvegardeImpossible 
	{	
		try
		{
			PreparedStatement listLigue;
			listLigue = connection.prepareStatement("DELETE FROM ligue WHERE num_ligue = ?");
			listLigue.setInt(1, ligue.getId());
			listLigue.executeUpdate();
			System.out.println("Ligue " + ligue.getNom() + " supprimé");
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new SauvegardeImpossible(e);
		}
		
	}
	
	
	//new part my
	@Override
	public void insert(Employe employe) throws SauvegardeImpossible 
	{
		try {
			
			PreparedStatement instruction2;
			instruction2 = connection.prepareStatement("insert into employe (nom_employe, prenom_employe, mail_employe, password_employe, dateArrivee_employe, num_ligue) values(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			instruction2.setString(1, employe.getNom());		
			instruction2.setString(2, employe.getPrenom());	
			instruction2.setString(3, employe.getMail());
			instruction2.setString(4, employe.getPassword());
			instruction2.setString(5, String.valueOf(employe.getDateArrivee()));
			instruction2.setInt(6, employe.getLigue().getId());
			instruction2.executeUpdate();
			ResultSet id = instruction2.getGeneratedKeys();
			id.next();
		}
		catch (SQLException exception)
		{
			exception.printStackTrace();
			throw new SauvegardeImpossible(exception);
		}
	}
	
	
	
	public void updateEmploye(Employe employe, String dataList) throws SauvegardeImpossible 
	{
		try 
		{
			PreparedStatement instruction;
	        instruction = connection.prepareStatement("UPDATE employe SET " + dataList + "= ? WHERE id_employe = ?");
	
			Map <String, String> map = new HashMap<String, String>();
					map.put("nom_employe", employe.getNom());
					map.put("prenom_employe", employe.getPrenom());
					map.put("mail_employe", employe.getMail());
				    map.put("password_employe", employe.getPassword());
			     	map.put("date_arrivee", String.valueOf(employe.getDateArrivee()));
				    map.put("date_depart", String.valueOf(employe.getDateDepart()));

		instruction.setString(1, map.get(dataList));
	    instruction.setInt(2, employe.getId());
			instruction.executeUpdate();
		}
		catch (SQLException e) 
		{
			
			throw new SauvegardeImpossible(e);
	}
	}
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public void deleteEmploye(Employe employe) throws SauvegardeImpossible 
	{	
		try
		{
			PreparedStatement listEmploye;
			listEmploye = connection.prepareStatement("DELETE FROM employe WHERE num_ligue = ?");
			listEmploye.setInt(1, employe.getId());
			listEmploye.executeUpdate();
			System.out.println("Ligue " + employe.getNom() + " supprimé");
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new SauvegardeImpossible(e);
		}
		
	}

	@Override
	public void SetAdmin(Employe employe) throws SauvegardeImpossible 
	{
		try 
		{
			PreparedStatement listEmploye;
			listEmploye = connection.prepareStatement("UPDATE employe SET admin_ligue = (CASE WHEN id_employe = ? THEN 1 WHEN id_employe <> ? THEN 0 END) WHERE num_ligue = ?");
			listEmploye.setInt(1, employe.getId());
			listEmploye.setInt(2, employe.getId());
			listEmploye.setInt(3, employe.getLigue().getId());
			listEmploye.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new SauvegardeImpossible(e);
		}
	}
	
	
	
}
