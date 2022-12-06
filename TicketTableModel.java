import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TicketTableModel extends AbstractTableModel {
	
	private CancelTicketController tContl = null;
	private String[] columnNames = {"Movie Name", "Theatre", "Showtime", "Seat Number"};
	private ArrayList<Ticket> arr = null;
	
	
	public TicketTableModel(CancelTicketController tc) {
		tContl = tc;
		arr = tContl.getPurchasedTickets();
	}
	
	@Override
	public int getRowCount() {
		return arr.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	
    public String getColumnName(int col) {
        return columnNames[col];
    }
	

    public Ticket getTicketAt(int rowIndex) {
    	return arr.get(rowIndex);
    }
    
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Ticket row = arr.get(rowIndex);
		
		if(columnIndex == 0) {
			return row.getMovie();
		}else if ( columnIndex == 1){
			return row.getTheatre();
		} else if(columnIndex == 2) {
			return row.getTime();
		} else if(columnIndex == 3) {
			return row.getSeat();
		}
		
		return null;
	}
	
	public void update() {
		
		arr = tContl.getPurchasedTickets();
		this.fireTableDataChanged();
		
	}

}
