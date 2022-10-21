import java.util.Iterator;
//this class uses iterator design pattern where user can loop through
// each product using next, hasNext,movetohead function
public class ProductIterator implements Iterator  {

	private ClassProductList ProductList;
	private int CurrentproductNumber=-1;

	ProductIterator(ClassProductList productList)
	{
		ProductList=productList;
	}

	public boolean hasNext()
	{
		return CurrentproductNumber < ProductList.size()-1;
	}

	public Object next() {
		if(hasNext())
		{
			CurrentproductNumber++;
			return  ProductList.get(CurrentproductNumber);
		}
		else
		{
			return  null;
		}
	}

	public void MoveToHead() {

	}

	public void remove() {
		ProductList.remove(CurrentproductNumber);
	}

	Object next(String ProductName)
	{
		Product thisProduct;
		thisProduct=(Product)next();
		while(thisProduct!=null)
		{
			if(ProductName.compareTo(thisProduct.toString())==0)
			{
				return thisProduct;
			}
			thisProduct=(Product)next();
		}
		return null;
	}

}
