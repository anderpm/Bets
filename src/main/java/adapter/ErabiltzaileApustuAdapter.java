package adapter;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import businessLogic.BLFacade;
import domain.Bet;
import domain.Bezeroa;
import domain.TMBet;
import domain.Transaction;
import gui.MainGUI;

public class ErabiltzaileApustuAdapter extends AbstractTableModel{

	private final Vector<TMBet> apustuak = new Vector<TMBet>();
	private Bezeroa bezeroa;
	private String[] colNames = new String[] {"Event", "Question", "EventDate", "Bet"};
	 
	
	public ErabiltzaileApustuAdapter(Bezeroa b) {
		this.bezeroa = b;
	}
	
	public void apusutakGehitu() {
		Vector<Transaction> tran = this.bezeroa.getMugimenduak();
		int i = 0;
		while(i<tran.size()) {
			if(tran.get(i) instanceof TMBet) {
				TMBet t = (TMBet)tran.get(i);
				apustuak.add(t);
			}
		}
	}
	
	@Override
	public int getRowCount() {
		return 1;
	}

	@Override
	public int getColumnCount() {
		return 4;
	}
	
	@Override
    public String getColumnName(int col) {
        return colNames[col];
    }

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {
			case 0: return ((Object) this.bezeroa.getUserName());
			case 1: return ((Object) this.bezeroa.getCash());
			case 2: return ((Object) this.bezeroa.getUserName());
			case 3: return ((Object) this.bezeroa.getCash());
		}
		return null;
	}

}
