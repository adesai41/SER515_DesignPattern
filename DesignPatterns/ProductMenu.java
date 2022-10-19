import javax.swing.*;

abstract class ProductMenu extends JDialog {

	Person person;
	private boolean bLogout=true;

	JRadioButton ProductRadio = new JRadioButton();
	JComboBox<Product> ProductCombox = new JComboBox<>();
	JButton ProductViewButton = new JButton();
	JButton AProductAddButton = new JButton();
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

	}
	public abstract void showMenu();

	public abstract void showAddButton();

	public abstract void showViewButton();

	public abstract void showRadioButton();

	//public abstract void showLabels();

	public abstract void showComboxes();


	boolean ifLogout()
	{
		return bLogout;
	}

}
