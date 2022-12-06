import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.CardLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Choice;
import javax.swing.JTextPane;
import javax.swing.ListModel;

import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import org.jdatepicker.JDatePicker;
import javax.swing.DefaultComboBoxModel;
import java.awt.Cursor;


public class UserWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable ticketTable;
	private JLabel[][] seatArr = new JLabel[11][7];
	private JLabel showtimeDateLabel;
	private JLabel theatreLabel;
	private JTextPane txtpnMovieName;
	
	
	
	//private ArrayList<String> cart = new ArrayList<String>();
	private JList<String> list = null;
	private DefaultListModel<String> cart = new DefaultListModel<String>();
	private float seatPrice = (float) 20.00;
	
	private Color selectedSeat = new Color(250, 180, 63);
	private Color availableSeat = new Color(30, 144, 255);
	private Color takenSeat = new Color(169, 169, 169);
	
	
	private RegisteredUser regUser = null;
	private User ordUser = null;
	private String signedInAsStr = "Guest";
	
	private ViewingsController vContl = null;
	MoviesTableModel moviesList = null;
	private CancelTicketController tContl = new CancelTicketController(new User());

	private TicketTableModel ticketList = new TicketTableModel(tContl);
	
	Showtime selectedShowtime = null;
	
	String movieLabelFill = "";
	String showtimeDateFill = "";
	String theatreLabelFill = "";
	
	
	/**
	 * Create the frame.
	 */
	public UserWindow(RegisteredUser rUser, User oUser) {
		
		if(rUser != null) {
			signedInAsStr = rUser.getEmail();
			System.out.println("REGISTERED USER");
			tContl = new CancelTicketController(rUser);
			ticketList = new TicketTableModel(tContl);
		}
		vContl = new ViewingsController(rUser);
		moviesList = new MoviesTableModel(vContl);
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel avail_movies_panel = new JPanel();
		contentPane.add(avail_movies_panel, "name_1470442961559700");
		avail_movies_panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StartWindow startFrame = new StartWindow();
				startFrame.setVisible(true);
				closeWindow();
			}
		});
		btnNewButton.setBounds(30, 462, 89, 23);
		avail_movies_panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 78, 911, 373);
		avail_movies_panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(moviesList);
		
		ArrayList<String> movieOptions = vContl.getAllMovieNames();
		movieOptions.add(0, "All");
		JComboBox comboBox = new JComboBox(movieOptions.toArray());
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selection = (String)comboBox.getSelectedItem();
				if(selection.equals("All"))
					selection = "";
				moviesList.filterByTitle(selection);
			}
		});
		comboBox.setBounds(442, 45, 195, 22);
		comboBox.setEditable(true);
		avail_movies_panel.add(comboBox);
		
		ArrayList<String> theatreOptions = vContl.getAllTheaterNames();
		theatreOptions.add(0, "All");
		JComboBox comboBox_1 = new JComboBox(theatreOptions.toArray());
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selection = (String)comboBox_1.getSelectedItem();
				if(selection.equals("All"))
					selection = "";
				
				moviesList.filterByTheatre(selection);
			}
		});
		comboBox_1.setBounds(746, 45, 195, 22);
		avail_movies_panel.add(comboBox_1);
		
		JLabel lblNewLabel_1 = new JLabel("Movie Name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(355, 49, 77, 14);
		avail_movies_panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Theatre Name");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(647, 49, 89, 14);
		avail_movies_panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Available Movies");
		lblNewLabel_3.setFont(new Font("Vivaldi", Font.PLAIN, 35));
		lblNewLabel_3.setBounds(30, 0, 271, 34);
		avail_movies_panel.add(lblNewLabel_3);
		
		// TODO make button unavailable when there is no showtime selected
		JButton btnNewButton_1 = new JButton("View Seats for Selected Showtime");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int row = table.getSelectedRow();
				if(row == -1)
					return;
				ArrayList<Seat> disabledSeats = null;
				selectedShowtime = moviesList.getShowtimeAt(row);
				
				theatreLabel.setText(selectedShowtime.getTheaterName());
				showtimeDateLabel.setText(selectedShowtime.getTime().toLocaleString());
				txtpnMovieName.setText(selectedShowtime.getMovieName()); 
				//System.out.println(selectedShowtime.getMovieName());
				disabledSeats = DatabaseController.getTakenSeats(selectedShowtime);
				
				populateSeatGraphic(disabledSeats);
				
				CardLayout layout = (CardLayout) contentPane.getLayout();
				layout.next(contentPane);
			}
		});
		btnNewButton_1.setBounds(693, 462, 216, 40);
		avail_movies_panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cancel Tickets");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//TODO if not already signed in as registered user
				if(rUser == null) {
					oUser.email = confirmUnregisteredUserEmail();
				
					//if email not in database (or no email entered)
					if(oUser.email == null) {}						
					else if(oUser.email.length() == 0 || !DatabaseController.userExists(oUser.getEmail())) {
						System.out.println("Email " + oUser.getEmail());
						emailNotInDatabaseDiag();
					}
					else {
						LoginController lgin = LoginController.getOnlyInstance();
						
						tContl = new CancelTicketController(lgin.getUser(oUser.email));
						ticketList = new TicketTableModel(tContl);
						ticketTable.setModel(ticketList);
						//If email is validated then go to cancel tickets panel
						CardLayout layout = (CardLayout) contentPane.getLayout();
						layout.last(contentPane);
					}
				
				}
				else {
					//ticketTable.setModel(ticketList);
					//If email is validated then go to cancel tickets panel
					CardLayout layout = (CardLayout) contentPane.getLayout();
					layout.last(contentPane);
				}
				
			}
		});
		btnNewButton_2.setBounds(129, 462, 110, 23);
		avail_movies_panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_4 = new JLabel("Signed in as: " + signedInAsStr);
		lblNewLabel_4.setBounds(325, 475, 202, 14);
		avail_movies_panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("Filter by...");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(264, 45, 81, 18);
		avail_movies_panel.add(lblNewLabel);
		
		JPanel view_seats_panel = new JPanel();
		contentPane.add(view_seats_panel, "name_1541017206658600");
		view_seats_panel.setLayout(null);
		
		JPanel info_button_panel = new JPanel();
		info_button_panel.setBounds(0, 0, 232, 513);
		view_seats_panel.add(info_button_panel);
		info_button_panel.setLayout(null);
		
		JButton btnNewButton_5 = new JButton("Checkout");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(cart.size() == 0) {
					return;
				}
				
				//CHECK IF REGISTERED USER
				if(oUser != null) {
					//IF UNREGISTERED PROMPT FOR EMAIL AND THEN PAYMENT
					String email = promptUnregisteredUserEmail();
					
					//if email not in database (or no email entered)
					if(email == null) {
						return;
					}
					else if(email.length() == 0) {
						emailNotEnteredDiag();
						return;
					}
					else
						oUser.email = email;
					
				}
				//System.out.println("RUSER email: " + rUser.email)
				User user = oUser;
				if(rUser != null)
					user = rUser;
				
				//If email is validated then go to payment
				int response = StartWindow.showPayment(cart.size() * 20, user);
				
				if(response == 1) { // payment succeeded
					PurchaseController pContl = new PurchaseController(selectedShowtime);
					ArrayList<Seat> requestedSeats = new ArrayList<>();
					for(int i = 0; i < cart.size(); i++) {
						requestedSeats.add(new Seat(cart.get(i), selectedShowtime.getRoomName()));
					}
					
					//System.out.println("USER EMAIL WHEN PURCHASING: " + user.getEmail());
					
					if(user instanceof RegisteredUser) {}
					else {
						LoginController lgin = LoginController.getOnlyInstance();
						lgin.addUser(user.getEmail());
					}
					
					if(pContl.purchaseSeats(user.getEmail(), requestedSeats, cart.size() * 20, selectedShowtime.getTheaterName())) {
						paymentConfirmedDiag();
					}
					else if (rUser != null) {
						over10percentDiag();
						return;
					}
					
					
					UserWindow viewMovieFrame = new UserWindow(rUser, oUser);
					viewMovieFrame.setVisible(true);
					closeWindow();
				}
				else if(response == 0) {
					System.out.println("Response was 0");
				}
				
				
				
			}
		});
		btnNewButton_5.setBounds(6, 426, 194, 41);
		info_button_panel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Back");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout layout = (CardLayout) contentPane.getLayout();
				layout.first(contentPane);
				
				//reset contents of last panel
				resetSeatGraphic();

				
				cart.clear();
			}
		});
		btnNewButton_6.setBounds(56, 479, 101, 23);
		info_button_panel.add(btnNewButton_6);
		
		txtpnMovieName = new JTextPane();
		txtpnMovieName.setEditable(false);
		StyledDocument doc = txtpnMovieName.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		txtpnMovieName.setFont(new Font("Blackadder ITC", Font.PLAIN, 32));
		txtpnMovieName.setBackground(SystemColor.control);
		txtpnMovieName.setBounds(6, 11, 216, 132);
		info_button_panel.add(txtpnMovieName);
		
		JLabel seatTheatreLabel = new JLabel("Theatre:");
		seatTheatreLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		seatTheatreLabel.setBounds(6, 154, 62, 14);
		info_button_panel.add(seatTheatreLabel);
		
		JLabel seatShowtimeDate = new JLabel("Showtime:");
		seatShowtimeDate.setHorizontalAlignment(SwingConstants.RIGHT);
		seatShowtimeDate.setBounds(6, 179, 62, 14);
		info_button_panel.add(seatShowtimeDate);
		
		theatreLabel = new JLabel();
		theatreLabel.setBounds(78, 154, 108, 14);
		info_button_panel.add(theatreLabel);
		
		showtimeDateLabel = new JLabel();
		showtimeDateLabel.setBounds(78, 179, 149, 14);
		info_button_panel.add(showtimeDateLabel);
		
		JLabel lblNewLabel_10 = new JLabel("Seat Price:");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_10.setBounds(6, 204, 62, 14);
		info_button_panel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("$20.00");
		lblNewLabel_11.setBounds(78, 204, 49, 14);
		info_button_panel.add(lblNewLabel_11);
		
		JButton removeSeatButton = new JButton("Remove Selected");
		removeSeatButton.setEnabled(false);
		removeSeatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index = list.getSelectedIndex();
				int[] seatIndex = seatNameToIndex(cart.getElementAt(index));
				
				enableSeat(seatIndex[0], seatIndex[1]);
				//System.out.println("idx 1: " + seatIndex[0] + "idx 2: " + seatIndex[1]);
			    cart.remove(index);
						   
			    int size = cart.getSize();

			    if (size == 0) { //No households's left, disable remove.
			    	removeSeatButton.setEnabled(false);

			    } else { //Select an index.
			        if (index == cart.getSize()) {
			            //removed item in last position
			            index--;
			        }

			        list.setSelectedIndex(index);
			        list.ensureIndexIsVisible(index);
			    }

			}
		});
		removeSeatButton.setBounds(6, 359, 194, 23);
		info_button_panel.add(removeSeatButton);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(6, 252, 192, 96);
		info_button_panel.add(scrollPane_2);
		
		list = new JList<String>(cart);
		list.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_2.setViewportView(list);
		
	    ListSelectionModel listSelectionModel = list.getSelectionModel();
		listSelectionModel.addListSelectionListener(new ListSelectionListener() {
	    	public void valueChanged(ListSelectionEvent e) {
	    	    if (e.getValueIsAdjusting() == false) {

	    	        if (list.getSelectedIndex() == -1) {
	    	        //No selection, disable "... Selected" button.
	    	            removeSeatButton.setEnabled(false);
	    	        } else {
		    	    //No selection, disable "... Selected" button.
	    	        	removeSeatButton.setEnabled(true);
	    	        }
	    	    }
	    	}
	    });
		
		
		JLabel lblNewLabel_12 = new JLabel("Cart");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setBounds(6, 229, 194, 23);
		info_button_panel.add(lblNewLabel_12);
		
		JPanel seats_panel = new JPanel();
		seats_panel.setBounds(208, 0, 768, 513);
		view_seats_panel.add(seats_panel);
		seats_panel.setLayout(null);
		
		JLabel screen_label = new JLabel("Screen");
		screen_label.setHorizontalAlignment(SwingConstants.CENTER);
		screen_label.setBounds(91, 11, 587, 14);
		Border blackline = BorderFactory.createLineBorder(Color.black);
		screen_label.setBorder(blackline);
		seats_panel.add(screen_label);
		
		
		// LOOP TO ADD ALL SEATS
				
		for(int column = 0 ; column < 11 ; column++) {
			for(int row = 0; row < 7; row++) {
				JLabel seat = new JLabel();
				seat.setHorizontalAlignment(SwingConstants.CENTER);
				//seat.setForeground(Color.RED);
				char rowChar = (char) (row + 65);
				seat.setText(rowChar + Integer.toString(column + 1));
				seat.setOpaque(true);
				seat.setBackground(availableSeat);
				
					
				seat.setBounds(65 + column * 59, 45 + row * 59, 50, 50);
				
				seat.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						seatPressed(seat);
					}
				});
				
				
				seatArr[column][row] = seat;
				
				seats_panel.add(seat);
				
			}
			
		}
		
		JPanel cancel_tickets_panel = new JPanel();
		contentPane.add(cancel_tickets_panel, "name_1551264844578800");
		cancel_tickets_panel.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(41, 73, 890, 330);
		cancel_tickets_panel.add(scrollPane_1);
		
		ticketTable = new JTable();
		ticketTable.setModel(ticketList);
		ticketTable.getColumnModel().getColumn(1).setPreferredWidth(95);
		scrollPane_1.setViewportView(ticketTable);
		
		JLabel lblNewLabel_5 = new JLabel("Cancel Tickets");
		lblNewLabel_5.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 38));
		lblNewLabel_5.setBounds(37, 11, 466, 48);
		cancel_tickets_panel.add(lblNewLabel_5);
		
		JButton btnNewButton_3 = new JButton("Cancel Selected Ticket");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//get index then 
				int selection  = ticketTable.getSelectedRow();
				if(selection == -1)
					return;
				
				Ticket selTicket = ticketList.getTicketAt(selection);
				
				
				if(tContl.validateTicket(selTicket)) { // check if < 72 hours
					
					ArrayList<Ticket> refTicket = new ArrayList<>();
					refTicket.add(selTicket);
					tContl.refundTickets(refTicket);
				
					ticketCancellationConfirmationDiag();
					ticketList.update();
				}
				else {
					ticketStarts72HoursDiag();
					return;
				}
				
				
				
			}
		});
		btnNewButton_3.setBounds(717, 437, 183, 48);
		cancel_tickets_panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Back");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout layout = (CardLayout) contentPane.getLayout();
				layout.first(contentPane);
			}
		});
		btnNewButton_4.setBounds(59, 450, 89, 23);
		cancel_tickets_panel.add(btnNewButton_4);
	}
	
	private void closeWindow() {
		this.dispose();
	}
	
	private String confirmUnregisteredUserEmail() {
		//Object[] possibilities = {"ham", "spam", "yam"};
		String s = (String)JOptionPane.showInputDialog(
		                    this,
		                    "Enter the email address associated with the purchased"+
		                    		"\ntickets.",
		                    "Enter Email",
		                    JOptionPane.QUESTION_MESSAGE);
		                    //null,	// for custom icon
		                    //null,  //for drop down of options
		                    //"ham"); //whats already in textbox

		return s;
	}
	
	private String promptUnregisteredUserEmail() {
		//Object[] possibilities = {"ham", "spam", "yam"};
		String s = (String)JOptionPane.showInputDialog(
		                    this,
		                    "Enter your email address"+
		                    		"\ntickets.",
		                    "Enter Email",
		                    JOptionPane.QUESTION_MESSAGE);

		return s;
	}
	
	private void emailNotInDatabaseDiag() {
		JOptionPane.showMessageDialog(this,
			    "Email has not been used to purchase any tickets",
			    "Email error",
			    JOptionPane.ERROR_MESSAGE);
	}
	
	private void emailNotEnteredDiag() {
		JOptionPane.showMessageDialog(this,
			    "Please enter an email",
			    "Email error",
			    JOptionPane.ERROR_MESSAGE);
	}
	
	private void paymentConfirmedDiag() {
		JOptionPane.showMessageDialog(this,
			    "Payment successfully completed. Ticket will be sent to email.");
	}
	
	private void ticketStarts72HoursDiag() {
		JOptionPane.showMessageDialog(this,
			    "Tickets cannot be refunded less than 72 hours before the movie starts",
			    "Cannot Cancel Ticket",
			    JOptionPane.ERROR_MESSAGE);
	}
	
	public void ticketCancellationConfirmationDiag() {
		JOptionPane.showMessageDialog(this,
			    "Ticket was successfully cancelled. A credit will be added to your account. A confirmation email was sent.",
			    "Cancellation Successful",
			    JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void over10percentDiag() {
		JOptionPane.showMessageDialog(this,
			    "The limit of pre-annoucment seat sales has been reached",
			    "Cannot purchase ticket",
			    JOptionPane.WARNING_MESSAGE);
	}
	
	
	private void enableSeat(int x, int y) {
		seatArr[x][y].setEnabled(true);
		seatArr[x][y].setBackground(availableSeat);
	}
	
	private void seatPressed(JLabel seat) {
		if(seat.isEnabled()) {
			// mark seat as selected
			seat.setBackground(selectedSeat);
			seat.setEnabled(false);
			cart.add(0, seat.getText());
			//System.out.println("Seat pressed: " + seat.getText());
			
			// add to cart price
			
		}
	}
	
	private int[] seatNameToIndex(String name) {
		
		//System.out.println("NAME: " + name);
		int[] ret = {name.charAt(1) - 48 - 1, name.charAt(0) - 65};
		return ret;
	}
	
	private void resetSeatGraphic() {
		for(JLabel[] col : seatArr) {
			for(JLabel seat : col) {
				if(!seat.isEnabled()) {
					seat.setEnabled(true);
					seat.setBackground(availableSeat);
				}
			}
		}
	}
	
	private void populateSeatGraphic(ArrayList<Seat> occupiedSeats) {
		for(JLabel[] col : seatArr) {
			for(JLabel seat : col) {
				for(Seat occ : occupiedSeats) {
					if(seat.getText().equals(occ.getSeatId())) {
						seat.setEnabled(false);
						seat.setBackground(takenSeat);
					}
				}
			}
		}
	}
}
