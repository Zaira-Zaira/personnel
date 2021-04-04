package InterfaceApplication;
import java.util.SortedSet;

import javax.swing.JList;
import javax.swing.table.AbstractTableModel;

import InterfaceApplication.*;
import personnel.Employe;
import personnel.Ligue;

public class TableModel  extends AbstractTableModel{
    private HomePage homePage;
    private listEmployes listEmployes;
    private Employe employe;
	public int getNbLigues() {
		
		return listEmployes.getEmployes().size();
	}
	
	public JList<Employe> liguesList()
	{
		return listEmployes.list();
	}
	
	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {
		return listEmployes.getEmployes().size();
	}

	@Override
	public Object getValueAt(int indiceLigne, int indiceColonne) {
		
		switch(indiceColonne) {
		case 0 :
			return employe.getNom();
		case 1 : 
			return employe.getPrenom();
		case 2: 
			return employe.getMail();
		case 3:
			return employe.getDateArrivee();
		case 4 :
			return employe.getDateDepart();
			default: return null;
		}
	}
	
	public String getColumnName(int indiceColonne) {
		switch(indiceColonne) {
		case 0 :
			return "Nom";
		case 1 :
			return "Prénom";
		case 2 :
			return "Mail";
		case 3 :
			return "Date d'arrivée";
		case 4 :
			return "Date de départ";
			default : return null;
		}
	}
	
	public Class<?extends Object> getColumnClass(int indiceColonne){
		return getValueAt(0, indiceColonne).getClass();
	}
}
