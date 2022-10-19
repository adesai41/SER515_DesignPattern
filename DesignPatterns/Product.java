import  java.util.*;
import java.util.ArrayList;

public class Product {

	private String ProductName;
	ArrayList<Trading> TradingList = new ArrayList<>();


	public Product(String strProduct) {
		this.ProductName = strProduct;
	}

	public String toString()
	{
		return ProductName;
	}
	void AddTrading(Trading newTrading)
	{
		TradingList.add(newTrading);
	}
	void accept(NodeVisitor visitor)
	{
		visitor.visitProduct(this);
	}
	//private ClassProductList classProductList;
	//private Trading trading;

}
