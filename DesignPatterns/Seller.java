//here factory design pattern is used to determine which class is to be
//instatiated after login
//----------------------------------------
//this class is also a part of bridge design pattern.
//bridge design pattern allows to load appropriate menu for buyer or seller
public class Seller extends Person  {
	Seller(){
		type=0;
	}

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
