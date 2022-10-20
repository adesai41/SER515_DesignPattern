import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

abstract class ProductMenu extends JDialog {

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
		buttonChangeProduct.setText("ChangeProduct");
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
	public void ShowMenu(){}

	public abstract void showAddButton();

	public abstract void showViewButton();

	public abstract void showRadioButton();

	public abstract void showLabels();

	public abstract void showComboxes();

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
		bLogout=false;
		dispose();
	}

	boolean ifLogout()
	{
		return bLogout;
	}

}
