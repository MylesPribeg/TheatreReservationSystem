import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Dialog;

import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class StartWindow extends JFrame {

	private JPanel startCards;
	private JPasswordField passwordField;
	private JTextField emailField;
	private JTextField textField_2;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private RegisteredUser regUser = null;
	private LoginController loginContl = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	     try {
			UIManager.setLookAndFeel(
			         UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartWindow frame = new StartWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StartWindow() {
		
		loginContl  = LoginController.getOnlyInstance();
		
		setTitle("Theatre Seat Reservation System");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		startCards = new JPanel();
		startCards.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(startCards);
		startCards.setLayout(new CardLayout(0, 0));
				
		JPanel Start_page = new JPanel();
		startCards.add(Start_page, "name_1466254807188200");
		Start_page.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Theatre Seat Reservation");
		lblNewLabel_4.setBounds(68, 40, 287, 25);
		lblNewLabel_4.setFont(new Font("Magneto", Font.PLAIN, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		Start_page.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("System");
		lblNewLabel_5.setBounds(136, 71, 151, 25);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Magneto", Font.PLAIN, 20));
		Start_page.add(lblNewLabel_5);
		
		JButton Guest_button = new JButton("Guest");
		Guest_button.setBounds(176, 102, 71, 23);
		Guest_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				User guestUser = new User();
				
				//Open MovieSelection window
				UserWindow viewMovieFrame = new UserWindow(null, guestUser);
				viewMovieFrame.setVisible(true);
				closeWindow();
			}
		});
		Start_page.add(Guest_button);
		
		JButton Sign_up_button = new JButton("Sign-Up");
		Sign_up_button.setBounds(176, 131, 71, 23);
		Sign_up_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CardLayout layout = (CardLayout) startCards.getLayout();
				layout.last(startCards);
			}
		});
		Start_page.add(Sign_up_button);
		
		JButton Sign_in_button = new JButton("Sign-in");
		Sign_in_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CardLayout layout = (CardLayout) startCards.getLayout();
				layout.next(startCards);
			}
		});
		Sign_in_button.setBounds(176, 160, 71, 23);
		Start_page.add(Sign_in_button);
		
		JButton btnNewButton_1 = new JButton("Admin...");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPasswordField pf = new JPasswordField();
				int okCxl = JOptionPane.showConfirmDialog(null, pf, "Enter Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

				if (okCxl == JOptionPane.OK_OPTION) {
				  String password = new String(pf.getPassword());
				  if(password.compareTo("12345") == 0) {
					    JTextArea textArea = new JTextArea(20, 60);
					    textArea.setLineWrap(true);
					    textArea.setWrapStyleWord(true);
					    int send = JOptionPane.showConfirmDialog(null, new JScrollPane( textArea), 
					    		"Send movie news", JOptionPane.OK_CANCEL_OPTION);
					    if(send == JOptionPane.OK_OPTION) {
					    	System.out.println(textArea.getText());
					    }
					  
				  }
				}
			}
		});
		btnNewButton_1.setBounds(353, 229, 73, 23);
		Start_page.add(btnNewButton_1);
		
		JPanel Sign_in_page = new JPanel();
		startCards.add(Sign_in_page, "name_1466395766158100");
		Sign_in_page.setLayout(null);
		
		JLabel welcome_label = new JLabel("Welcome");
		welcome_label.setBounds(166, 11, 241, 51);
		welcome_label.setFont(new Font("Snap ITC", Font.PLAIN, 39));
		Sign_in_page.add(welcome_label);
		
		JLabel email_box_label = new JLabel("Email");
		email_box_label.setBounds(74, 99, 47, 14);
		Sign_in_page.add(email_box_label);
		
		emailField = new JTextField();
		emailField.setBounds(166, 96, 241, 20);
		Sign_in_page.add(emailField);
		emailField.setColumns(10);
		
		JLabel password_box_label = new JLabel("Password");
		password_box_label.setBounds(74, 141, 47, 14);
		Sign_in_page.add(password_box_label);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(166, 138, 241, 20);
		Sign_in_page.add(passwordField);
		
		JButton sign_in_validate_button = new JButton("Sign-in");
		sign_in_validate_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RegisteredUser user = loginContl.RUSignIn(emailField.getText(), passwordField.getText());
				
				if(user != null && !user.checkMemberExpired()) { //if valid account and has paid
					UserWindow viewMovieFrame = new UserWindow(user, null);
					viewMovieFrame.setVisible(true);
					closeWindow();
				}
				else if(user != null && user.checkMemberExpired()) { // TODO asks for payment
					regUser = user;
					if(promptForRePayment() == 1) {
						user.payMemberFee();
						UserWindow viewMovieFrame = new UserWindow(user, null);
						viewMovieFrame.setVisible(true);
						closeWindow();
						
					} 
					else
						return;
				}
				else { //TODO non valid account message
					loginFailedDiag();
				}
				
				

			}
		});
		sign_in_validate_button.setBounds(166, 226, 241, 23);
		Sign_in_page.add(sign_in_validate_button);
		
		
		JPanel Sign_up_page = new JPanel();
		startCards.add(Sign_up_page, "name_1466530594384900");
		Sign_up_page.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Sign-Up");
		lblNewLabel_3.setBounds(159, 6, 162, 70);
		lblNewLabel_3.setFont(new Font("Parchment", Font.PLAIN, 65));
		Sign_up_page.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setBounds(64, 97, 89, 14);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		Sign_up_page.add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(159, 94, 236, 20);
		Sign_up_page.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(64, 123, 89, 14);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		Sign_up_page.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Confirm Password");
		lblNewLabel_2.setBounds(64, 149, 89, 14);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		Sign_up_page.add(lblNewLabel_2);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(159, 146, 236, 20);
		Sign_up_page.add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(159, 120, 236, 20);
		Sign_up_page.add(passwordField_2);
		
		JButton btnNewButton = new JButton("Continue to Payment");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO *check details (same password, has a password)* and add user
				if(passwordField_1.getPassword().toString().length() == 0)
					return;
				
				String p1 = new String(passwordField_1.getPassword());
				String p2 = new String(passwordField_2.getPassword());
				
				if(p1.compareTo(p2) != 0) {
					
					passwordsNoMatchDiag();
					return;
				}
				
				if(loginContl.emailExists(textField_2.getText())) {
					dupEmailDiag();
					return;
				}
				
				CreditCard empty = new CreditCard("none", null, 0, 0);
				RegisteredUser newUsr = new RegisteredUser(textField_2.getText(), 
						p1, null, null, empty, 0, null);
				
				System.out.println("company: " + newUsr.getCreditCard().getCompany());
				
				regUser = newUsr;
				
				//TODO price of subscription
				int response = showPayment(20, regUser);
				System.out.println("company regUser: " + regUser.getCreditCard().getNumber());
				if(response == 1) { // payment succeeded
										
					if(loginContl.registerUser(regUser)) {// only checks if email exists					
						UserWindow viewMovieFrame = new UserWindow(regUser, null);
						viewMovieFrame.setVisible(true);
						closeWindow();
					}
				
				}
				else if(response == 0) {
					//System.out.println("Response was 0");
				}

				
				
			}
		});
		btnNewButton.setBounds(159, 206, 162, 23);
		Sign_up_page.add(btnNewButton);
		

	}
	
	static int showPayment(float price, User user) { //TODO CC NUM
		PaymentDialog paymentFrame = new PaymentDialog(price, user);
		paymentFrame.setVisible(true);
		
		return paymentFrame.getPaymentStatus();
		
	}
	
	private int promptForRePayment() {
		JOptionPane.showMessageDialog(this,
			    "Your account is due for a payment. Please proceed with payment to continue to have "
			    + "access to registered user features.",
			    "Account Payment Expired",
			    JOptionPane.WARNING_MESSAGE);
		
		//TODO price of account
		return showPayment(20, this.regUser);
	}
	
	private void loginFailedDiag() {
		JOptionPane.showMessageDialog(this,
			    "Incorrect email or password",
			    "Login failed",
			    JOptionPane.ERROR_MESSAGE);
		
	}
	
	private void dupEmailDiag() {
		JOptionPane.showMessageDialog(this,
			    "An account is already associated with this email address",
			    "Sign-up failed",
			    JOptionPane.ERROR_MESSAGE);
		
	}
	
	private void passwordsNoMatchDiag() {
		JOptionPane.showMessageDialog(this,
			    "Passwords must match",
			    "Sign-up failed",
			    JOptionPane.ERROR_MESSAGE);
		
	}
	
	private void closeWindow() {
		this.dispose();
	}
}
