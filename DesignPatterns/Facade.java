import java.io.*;
//this class implements Facade DP for the PTBS system. User is redirected here for login,
//Trading menu, offering menu, reminders, product menu.
public class Facade {
	private Product theSelectedProduct = null;
	static int nProductCategory=0;
	ClassProductList thisProductList;
	private Person thePerson;

	Facade(){

	}

	//for login operations facade will use the
	// below function and verify user according to their roles
	static boolean Login(UserInfoItem userInfoItem)
	{
		Login login = new Login();
		login.setModal(true);
		login.setVisible(true);
		userInfoItem.strUserName= login.GetUserName();
		userInfoItem.UserType=login.GetUserType();
		return login.isExit();
	}

	//to add trades for a user facade class contains below method
	void AddTrading(Product thisProduct)
	{
		TradingMenu thisTradingMenu;
		if(thePerson.type==0)//type=0 indicates seller
		{
			thisTradingMenu=new SellerTradingMenu();

		}
		else//else its a buyer
		{
			thisTradingMenu=new BuyTradingMenu();

		}
		//for selected trading display menu to trade/offer
		Trading thisTrading = new Trading();
		thisTradingMenu.ShowMenu(thisTrading,thePerson);
		thisProduct.AddTrading(thisTrading);
	}

	void ViewTrading(Trading thisTrading) {
		TradingMenu thisTradingMenu;
		if (thePerson.type == 0)/// seller=0
		{
			thisTradingMenu = new SellerTradingMenu();
			System.out.println("view trades for buyer");
		} else {
			thisTradingMenu = new BuyTradingMenu();
			System.out.println("view trades for seller");
		}
//show menu
		thisTradingMenu.ShowMenu(thisTrading, thePerson);
	}

	//display reminder of upcoming and due offers
	void Remind() {
		Reminder thisReminder = new Reminder();

		thisReminder.showReminder(thePerson.GetProductList());
	}

	void CreateUser(UserInfoItem userinfoitem) {
		if (userinfoitem.UserType == UserInfoItem.USER_TYPE.Seller)
		{
			thePerson = new Seller();
		} else
		{
			thePerson = new Buyer();
		}
		thePerson.UserName = userinfoitem.strUserName;
	}


	//create a product list and use function initializefromfile to initiate products
	void CreateProductList() {
		thisProductList = new ClassProductList();
		thisProductList.InitializeFromFile();
	}

	//map users with their products mentioned in userProduct.txt file
	void AttachProductToUser() {


		BufferedReader file;
		try {
			file = new BufferedReader(new FileReader("UserProduct.txt"));
			String aline, strUserName, strProductName;
			while ((aline = file.readLine()) != null)
			{
				strUserName = GetUserName(aline);//get user names
				strProductName = GetProductName(aline);//get their product names

				if (strUserName.compareTo(thePerson.UserName) == 0) //check for username and their related products
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
		int Sep = aline.lastIndexOf(':');//seperate by colon
		return aline.substring(0, Sep);
	}

	private String GetProductName(String aline) {
		int Sep = aline.lastIndexOf(':');//seperate by colon
		return aline.substring(Sep + 1);
	}

	boolean SelectProduct() {
		ProductSelectDlg theDlg = new ProductSelectDlg();
		theSelectedProduct = theDlg.ShowDlg(thePerson.ProductList);
		thePerson.CurrentProduct = theSelectedProduct;
		nProductCategory = theDlg.nProductType;
		return theDlg.isLogout();
	}

	boolean ProductOperation() {
		thePerson.CreateProductMenu(theSelectedProduct, nProductCategory);

		return thePerson.ShowMenu();
	}

	private Product FindProductByProductName(String strProductName) {
		ProductIterator Iterator = new ProductIterator(thisProductList);
		return (Product) Iterator.next(strProductName);
	}


	public void decideBidding() {

	}

	public void discussBidding() {

	}

	public void submitBidding() {

	}






}
