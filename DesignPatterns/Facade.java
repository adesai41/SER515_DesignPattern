import java.io.*;
public class Facade {
	private Product theSelectedProduct = null;
	private int nProductType=0;
	ClassProductList thisProductList;
	private Person thisPerson;

	Facade(){}

	static boolean Login(UserInfoItem userInfoItem)
	{
		Login login = new Login();
		login.setModal(true);
		login.setVisible(true);
		userInfoItem.strUserName= login.GetUserName();
		userInfoItem.UserType=login.GetUserType();
		return login.isExit();
	}

	void AddTrading(Product thisProduct)
	{
		TradingMenu thisTradingMenu;
		if(thisPerson.type==0)
		{
			thisTradingMenu=new BuyTradingMenu();

		}
		else
		{
			thisTradingMenu=new SellerTradingMenu();

		}
		Trading thisTrading = new Trading();
		thisTradingMenu.ShowMenu(thisTrading,thisPerson);
		thisProduct.AddTrading(thisTrading);
	}

	void ViewTrading(Trading thisTrading) {
		TradingMenu thisTradingMenu;
		if (thisPerson.type == 0)/// seller
		{
			thisTradingMenu = new BuyTradingMenu();
		} else {
			thisTradingMenu = new SellerTradingMenu();
		}

		thisTradingMenu.ShowMenu(thisTrading, thisPerson);
	}

	void Remind() {
		Reminder thisReminder = new Reminder();
		thisReminder.showReminder(thisPerson.GetProductList());
	}

	void CreateUser(UserInfoItem userinfoitem) {
		if (userinfoitem.UserType == UserInfoItem.USER_TYPE.Seller)
		{
			thePerson = new Buyer();
		} else
		{
			thePerson = new Seller();
		}
		thisPerson.UserName = userinfoitem.strUserName;
	}


	void CreateProductList() {
		thisProductList = new ClassProductList();
		thisProductList.InitializeFromFile();
	}

	void AttachProductToUser() {
		BufferedReader file;
		try {
			file = new BufferedReader(new FileReader("UserProduct.txt"));
			String aline, strUserName, strProductName;
			while ((aline = file.readLine()) != null) // not the EOF
			{
				strUserName = GetUserName(aline);
				strProductName = GetProductName(aline);
				if (strUserName.compareTo(thePerson.UserName) == 0) /// the UserName mateches
				{
					theSelectedProduct = FindProductByProductName(strProductName);
					if (theSelectedProduct != null)
					{
						thePerson.AddProduct(theSelectedProduct);
					}
				}
			}
		} catch (Exception ignored) {
		}
	}

	private String GetUserName(String aline) {
		int Sep = aline.lastIndexOf(':');
		return aline.substring(0, Sep);
	}

	private String GetProductName(String aline) {
		int Sep = aline.lastIndexOf(':');
		return aline.substring(Sep + 1);
	}

	boolean SelectProduct() {
		ProductSelectDlg theDlg = new ProductSelectDlg();
		theSelectedProduct = theDlg.ShowDlg(thisPerson.ProductList);
		thisPerson.CurrentProduct = theSelectedProduct;
		nProductType = theDlg.nProductType;
		return theDlg.isLogout();
	}

	boolean ProductOperation() {
		thisPerson.CreateProductMenu(theSelectedProduct, nProductType);
		return thisPerson.ShowMenu();
	}

	private Product FindProductByProductName(String strProductName) {
		ProductIterator Iterator = new ProductIterator(theProductList);
		return (Product) Iterator.next(strProductName);
	}

	private int UserType;

	private int nProductCategory;

	private ClassProductList theProductList;

	private Person thePerson;

	public boolean login() {
		return false;
	}

	public void addTrading() {

	}

	public void viewTrading() {

	}

	public void decideBidding() {

	}

	public void discussBidding() {

	}

	public void submitBidding() {

	}

	public void remind() {

	}

	public void createUser(UserInfoItem userinfoitem) {

	}

	public void createProductList() {

	}



	public void productOperation() {

	}

}
