import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//this class is a part of FACADE DESIGN PATTERN.
// It is conneccted to the main facade class which acts like an interface
// and allows to navigate through different classes based on operation
//---------------------------------------
//this class also implements FACTORY DESIGN PATTERN. It determines which
// classes are to be instatiated based on the fucntion called
abstract class ProductMenu extends JDialog {
//creaating a gui for menu
	Product thisProduct;
	private boolean bLogout=true;

	JRadioButton TradingRadio = new JRadioButton();
	JComboBox<Trading> TradingCombox = new JComboBox<Trading>();
	JButton TradingViewButton = new JButton();
	JButton TradingAddButton = new JButton();
	JRadioButton OptionRadio = new JRadioButton();
	JComboBox OptionCombo = new JComboBox();
	JButton OptionViewButton = new JButton();
	JButton OptionAddButton = new JButton();
	private JButton buttonChangeProduct = new JButton();
	private JButton buttonLogout = new JButton();
	ProductMenu()
	{

		try
		{
			jbInit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		setModal(true);
		setSize(503,294);
	}

	private void jbInit() {
		buttonChangeProduct.setText("Change");
		buttonChangeProduct.setBounds(new Rectangle(101, 211, 73, 37));
		buttonChangeProduct.addActionListener(this::buttonChangeProduct_actionPerformed);
		this.getContentPane().setLayout(null);
		this.setTitle("");
		buttonLogout.setText("Logout");
		buttonLogout.setBounds(new Rectangle(267, 215, 73, 37));
		buttonLogout.addActionListener(this::buttonLogout_actionPerformed);
		this.getContentPane().add(buttonChangeProduct, null);
		this.getContentPane().add(buttonLogout, null);
	}


	abstract void showAddButton();

	abstract void showViewButton();

	abstract void showRadioButton();

	abstract void showLabels();

	abstract void showComboxes();

	void TradingViewButton_actionPerformed()
	{
		Trading thisTrade = (Trading) TradingCombox.getSelectedItem();
		Auction.theFacade.ViewTrading(thisTrade);
	}


	void TradingAddButton_actionPerformed()
	{
		Auction.theFacade.AddTrading(thisProduct);
		refresh();
	}

	void refresh()
	{
		TradingCombox.removeAllItems();

		for(Trading trading : thisProduct.TradingList)
		{
			TradingCombox.addItem(trading);
		}

	}

	private void buttonChangeProduct_actionPerformed(ActionEvent e)
	{
		bLogout=false;
		dispose();
	}
	private void buttonLogout_actionPerformed(ActionEvent e)
	{
		bLogout=true;
		dispose();
	}

	boolean ifLogout()
	{
		return bLogout;
	}

}
