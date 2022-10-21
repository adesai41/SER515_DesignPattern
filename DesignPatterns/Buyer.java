//here factory design pattern is used to determine which class is to be
//instantiated after login
//----------------------------------------------
//this class is also a part of bridge design pattern.
//bridge design pattern allows to load appropriate menu for buyer or seller
public class Buyer extends Person{
	Buyer()
	{
		type=1;
	}
//here factory design pattern is used to determine which
// class is to be instantiated after login

	public void CreateProductMenu(Product thisProduct, int thisProductType)
	{
		if(thisProductType==1)
		{
			thisProductMenu = new ProduceProductMenu();
		}
		else
		{
			thisProductMenu = new MeatProductMenu();
		}
	}

	@Override
	public boolean ShowMenu() {
		super.ShowMenu();
		showAddButton();
		showViewButton();
		showComboxes();
		showRadioButton();
		show();

		return ifLogout();

	}



}
