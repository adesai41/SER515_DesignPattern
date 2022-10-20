public class Seller extends Person  {
	Seller(){
		type=0;
	}

	public void CreateProductMenu(Product thisProduct, int thisProductType)
	{
		if(thisProductType==0)
		{
			thisProductMenu = new ProduceProductMenu();
		}
		else
		{
			thisProductMenu = new MeatProductMenu();
		}
	}

	public boolean showMenu() {
		super.ShowMenu();
		showAddButton();
		showViewButton();
		showComboxes();
		showRadioButton();
		show();

		return ifLogout();

	}

	public ProductMenu CreateProductMenu() {
		return null;
	}

}
