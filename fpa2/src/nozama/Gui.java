package nozama;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import nozama.Controller.sendRechts;
import nozama.Controller.sendLinks;
import nozama.Controller.Order;//Von Controller Implementier Funktion

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;


public class Gui extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel Label1;
	private JLabel Label2;
	private JLabel Label3;
	
	private JButton btnRechts;
	private JButton btnLinks;
	private JButton btnOrder;
	
	protected JList list1;
	protected JList list2;
	
	private JTextField textField;

	
	public Gui()
	{
		initialize();
	}
	private void initialize() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 793, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLabel1());
		contentPane.add(getBtnRechts());
		contentPane.add(getBtnLinks());
		contentPane.add(getLabel2());
		contentPane.add(getLabel3());
		contentPane.add(getTextField());
		contentPane.add(getList1());
		contentPane.add(getList2());
		contentPane.add(getBtnOrder());
		setVisible(true);//des kopiern andere löschen
	}
	private JLabel getLabel1() {
		if (Label1 == null) {
			Label1 = new JLabel("Nozama");
			Label1.setFont(new Font("Tahoma", Font.PLAIN, 23));
			Label1.setBounds(46, 34, 122, 34);
		}
		return Label1;
	}
	private JButton getBtnRechts() {
		if (btnRechts == null) {
			btnRechts = new JButton("---->");
			btnRechts.setBounds(345, 139, 85, 21);
		}
		return btnRechts;
	}
	private JButton getBtnLinks() {
		if (btnLinks == null) {
			btnLinks = new JButton("<-----");
			btnLinks.setBounds(345, 194, 85, 21);
		}
		return btnLinks;
	}
	private JLabel getLabel2() {
		if (Label2 == null) {
			Label2 = new JLabel("Warenkorb");
			Label2.setFont(new Font("Tahoma", Font.PLAIN, 18));
			Label2.setBounds(467, 81, 133, 21);
		}
		return Label2;
	}
	private JLabel getLabel3() {
		if (Label3 == null) {
			Label3 = new JLabel("Kundenname");
			Label3.setFont(new Font("Tahoma", Font.PLAIN, 18));
			Label3.setBounds(35, 374, 133, 21);
		}
		return Label3;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
			textField.setBounds(173, 372, 198, 23);
			textField.setColumns(10);
		}
		return textField;
	}
	JList getList1() {
		if (list1 == null) {
			list1 = new JList();
			list1.setBounds(51, 108, 268, 208);
		}
		return list1;
	}
	JList getList2() {
		if (list2 == null) {
			list2 = new JList();
			list2.setBounds(440, 112, 268, 208);
		}
		return list2;
	}
	private JButton getBtnOrder() {
		if (btnOrder == null) {
			btnOrder = new JButton("Bestellung abschicken");
			btnOrder.setBounds(488, 377, 171, 21);
		}
		return btnOrder;
	}
	
	public void setListener(sendRechts kaufen)
	{
		getBtnRechts().addActionListener(kaufen);
	}
	
	public void setListener(sendLinks Entfernen)
	{
		getBtnLinks().addActionListener(Entfernen);
	}
	
	public void setListener(Order order)
	{
		getBtnOrder().addActionListener(order);
	}
}
