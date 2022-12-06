import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;


public class MoviesTableModel extends AbstractTableModel{

	private ViewingsController vContl = null;
	private User user = null;
	private String[] columnNames = {"Movie Name", "Theatre Name", "Showtime"};
	private ArrayList<Showtime> arr;
	private String titleFilter = "";
	private String theatreFilter = "";

	public MoviesTableModel(ViewingsController vContl) {
		this.user = user;
		this.vContl = vContl;
		arr = vContl.getFilteredList(titleFilter, theatreFilter);
	}
	
	
	@Override
	public int getRowCount() {
		//System.out.println("COLS: "  + vContl.getShowtimes().size());
		return arr.size();
	}

    public String getColumnName(int col) {
        return columnNames[col];
    }
	
	@Override
	public int getColumnCount() {
		return 3;
	}

	public Showtime getShowtimeAt(int rowIndex) {
		return arr.get(rowIndex);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		//System.out.println("get row: " + rowIndex);
		Showtime row = arr.get(rowIndex);
		
		if(columnIndex == 0) {
			return row.getMovieName();
		}else if (columnIndex == 1) {
			return row.getTheaterName();
		}else {
			return row.getTime();
		}

	}
	
	public void filterByTitle(String title) {
		titleFilter = title;
		arr = vContl.getFilteredList(titleFilter, theatreFilter);
		fireTableDataChanged();
	}
	public void filterByTheatre(String theatre) {
		theatreFilter = theatre;
		arr = vContl.getFilteredList(titleFilter, theatreFilter);
		fireTableDataChanged();
	}


}
