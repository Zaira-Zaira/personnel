package InterfaceApplication;
import java.util.SortedSet;

import javax.swing.JList;
import javax.swing.table.AbstractTableModel;

import InterfaceApplication.*;
import personnel.Ligue;

public class TableModel  extends AbstractTableModel{
    private HomePage homePage;
    
	public int getNbLigues() {
		
		return homePage.getLigues().size();
	}
	
	public JList<Ligue> liguesList()
	{
		return homePage.listLigues();
	}
	
	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		return homePage.getLigues().size();
	}

	@Override
	public Object getValueAt(int indiceLigne, int indiceColonne) {
		
		switch(indiceColonne) {
		case 0 :
			return homePage.getLigues();
		case 1 : 
			return "Supprimer";
		case 2: 
			return "Modifier";
			default: return null;
		}
	}
	
	public String getColumnName(int indiceColonne) {
		switch(indiceColonne) {
		case 0 :
			return "ligue";
		case 1 :
			return "";
		case 2 :
			return "";
			default : return null;
		}
	}
	
	public Class<?extends Object> getColumnClass(int indiceColonne){
		return getValueAt(0, indiceColonne).getClass();
	}
}
