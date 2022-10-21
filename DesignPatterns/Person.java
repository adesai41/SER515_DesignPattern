import java.util.*;
//here bridge design pattern. the
//bridge will help to load the appropriate menu for either buyer or seller
abstract public class Person {
	int type =0;
	String UserName;
	ClassProductList ProductList;
	ProductMenu thisProductMenu;
	Product CurrentProduct;

	Person(){
		ProductList=new ClassProductList();
	}

	abstract public void CreateProductMenu(Product thisProduct, int thisProductType);



	void showAddButton(){
		thisProductMenu.showAddButton();
	}

	void showViewButton(){
		thisProductMenu.showViewButton();
	}
	void showComboxes() {thisProductMenu.showComboxes();	}

	void showRadioButton(){
		thisProductMenu.showRadioButton();
	}
	void show(){
		thisProductMenu.setVisible(true);
	}

	boolean ifLogout()
	{
		return thisProductMenu.ifLogout();
	}

	public boolean ShowMenu(){
		Iterator theIter = CurrentProduct.TradingList.iterator();
		thisProductMenu.thisProduct = CurrentProduct;
		Trading thisTrading;
		while (theIter.hasNext()) {
			thisTrading = (Trading) theIter.next();
			thisProductMenu.TradingCombox.addItem(thisTrading);
		}
		return false;
	}

	ClassProductList GetProductList() {
		return ProductList;
	}

	void AddProduct(Product thisProduct) {
		ProductList.add(thisProduct);
	}

	void showLabels(){}



}
