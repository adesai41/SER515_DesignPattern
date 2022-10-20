public class Buyer extends Person{
	Buyer()
	{
		type=1;
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
