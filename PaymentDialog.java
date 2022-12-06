import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Dialog;
import javax.swing.SwingConstants;

public class PaymentDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField ccNumField;
	private JTextField expDateField;
	private JTextField addrField;
	private JTextField nameField;
	private JTextField CVVField;
	private int paymentStatus = -1; 
	private double price = 0;
	private double credit = 0;
	

	/**
	 * Create the dialog.
	 */
	public PaymentDialog(double pr, User user) {
		
		price = pr;
		credit = user.getCredit();
		
		String nameFill = "";
		String ccNumFill = "";
		String cvvFill = "";
		String expDateFill = "";
		String addrFill = "";
		
		if(user instanceof RegisteredUser) {
			
			nameFill = ((RegisteredUser) user).getName();
			ccNumFill = ((RegisteredUser) user).getCreditCard().getNumber();
			if(((RegisteredUser) user).getCreditCard().getCvv() != 0){
				cvvFill = Integer.toString(((RegisteredUser) user).getCreditCard().getCvv());
				expDateFill = Integer.toString(((RegisteredUser) user).getCreditCard().getExpiryDate());
			}
			addrFill = ((RegisteredUser) user).getAddress();
		}
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new CardLayout(0, 0));
		this.setModalityType(Dialog.DEFAULT_MODALITY_TYPE);
		
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, "name_1548777399827300");
			panel.setLayout(null);
			
			
			JLabel lblNewLabel_5 = new JLabel("Total: ");
			lblNewLabel_5.setBounds(119, 62, 52, 22);
			lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
			panel.add(lblNewLabel_5);
			
			JLabel lblNewLabel_6 = new JLabel("$" + (price - calcCreditUsed()));
			lblNewLabel_6.setBounds(176, 62, 135, 22);
			lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
			panel.add(lblNewLabel_6);
			
			JLabel lblNewLabel_4 = new JLabel("Name");
			lblNewLabel_4.setBounds(142, 95, 29, 14);
			panel.add(lblNewLabel_4);
			
			nameField = new JTextField(nameFill);
			nameField.setBounds(177, 92, 232, 20);
			panel.add(nameField);
			nameField.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("Credit Card Number");
			lblNewLabel.setBounds(74, 126, 97, 14);
			panel.add(lblNewLabel);
			
			ccNumField = new JTextField(ccNumFill);
			ccNumField.setBounds(177, 123, 232, 20);
			panel.add(ccNumField);
			ccNumField.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("CVV");
			lblNewLabel_1.setBounds(151, 157, 20, 14);
			panel.add(lblNewLabel_1);
			
			
			JLabel lblNewLabel_2 = new JLabel("Expiry Date (MM/YY)");
			lblNewLabel_2.setBounds(236, 157, 105, 14);
			panel.add(lblNewLabel_2);
			

			CVVField = new JTextField(cvvFill);
			CVVField.setBounds(177, 154, 49, 20);
			panel.add(CVVField);
			
			expDateField = new JTextField(expDateFill);
			expDateField.setBounds(343, 154, 66, 20);
			panel.add(expDateField);
			expDateField.setColumns(10);
						
			
			JLabel lblNewLabel_3 = new JLabel("Address");
			lblNewLabel_3.setBounds(131, 182, 40, 14);
			panel.add(lblNewLabel_3);
			
			addrField = new JTextField(addrFill);
			addrField.setBounds(177, 179, 232, 20);
			panel.add(addrField);
			addrField.setColumns(10);
			
			JLabel lblNewLabel_7 = new JLabel("Subtotal:");
			lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_7.setBounds(123, 11, 48, 14);
			panel.add(lblNewLabel_7);
			
			JLabel lblNewLabel_8 = new JLabel("Credit Used:");
			lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_8.setBounds(97, 36, 74, 14);
			panel.add(lblNewLabel_8);
			
			JLabel lblNewLabel_9 = new JLabel("$" + price);
			lblNewLabel_9.setBounds(176, 11, 48, 14);
			panel.add(lblNewLabel_9);
			
			JLabel lblNewLabel_10 = new JLabel("$" + calcCreditUsed());
			lblNewLabel_10.setBounds(176, 36, 48, 14);
			panel.add(lblNewLabel_10);
		
		
			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						paymentStatus = 0;
						closeWindow();
					}
				});
				cancelButton.setActionCommand("OK");
				buttonPane.add(cancelButton);
				getRootPane().setDefaultButton(cancelButton);
			}
			{
				JButton confirmButton = new JButton("Confirm");
				confirmButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String expDate = expDateField.getText();
						
						if(nameField.getText().length() == 0 || addrField.getText().length() == 0
								|| ccNumField.getText().length() == 0 || CVVField.getText().length() != 3 
								|| !expDate.matches("[0-9]{2}/[0-9]{2}") 
								) {
							
							incorrectInputDiag();
							return;
						}
						
						expDate = new String(expDate.substring(0, 2) + expDate.substring(3,4));
						
						if(user instanceof RegisteredUser) {
							((RegisteredUser) user).setName(nameField.getText());
							((RegisteredUser) user).setAddress(addrField.getText());
							CreditCard card = new CreditCard("none", ccNumField.getText(),
									Integer.parseInt(expDate), Integer.parseInt(CVVField.getText())); 
							
							((RegisteredUser) user).setCreditCard(card);
							
						}
						
						

						
						paymentStatus = 1;
						closeWindow();
					}
				});
				confirmButton.setActionCommand("Cancel");
				buttonPane.add(confirmButton);
			}
		}
	}
	
	public int getPaymentStatus() {
		return paymentStatus;
	}
	
	public double calcCreditUsed() {
		
		if(credit > price) {
			return price;
		}
		
		else
			return credit;
		
	}
	
	private void incorrectInputDiag() {
		JOptionPane.showMessageDialog(this,
			    "Please check your input",
			    "Input error",
			    JOptionPane.ERROR_MESSAGE);
	}
	
	private void closeWindow() {
		this.dispose();
	}
}
