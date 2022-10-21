import java.util.ArrayList;
import java.io.*;
//this class implements visitor design pattern and iterator design pattern
public class ClassProductList extends ArrayList<Product> {
	ClassProductList(){

	}
	void InitializeFromFile() {
		try {
			BufferedReader file;
			String strProductName;
			file = new BufferedReader(new FileReader("ProductInfo.txt"));
			while ((strProductName = file.readLine()) != null) {
				String namepass[] = strProductName.split(":");
				String ProductName = namepass[1];
				String Type = namepass[0];
				//define product category
				if(Type == "Meat")
				{
					Facade.nProductCategory=0;
				}
				else {
					Facade.nProductCategory=1;
				}
				Product theProduct;
				theProduct = new Product(ProductName);

				add(theProduct);
			}
		} catch (Exception ignored) {

		}
	}




	private ProductIterator productIterator;//to implement iterator design pattern

	private ReminderVisitor reminderVisitor;


    //here accept method uses visitor design pattern
	public void accept(NodeVisitor visitor) {

	}

}
