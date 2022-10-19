import java.util.Collection;
import java.util.ArrayList;
import java.io.*;
public class ClassProductList extends ArrayList<Product> {
	ClassProductList(){

	}
	//// initialize the list by reading from the file.
	void InitializeFromFile() {
		try {
			BufferedReader file;
			String strProductName;
			file = new BufferedReader(new FileReader("ProductInfo.txt"));
			while ((strProductName = file.readLine()) != null) {
				Product theProduct;
				theProduct = new Product(strProductName);

				add(theProduct);
			}
		} catch (Exception ignored) {
		}
	}


	//private ProductIterator productIterator;

	//private ReminderVisitor reminderVisitor;

	//private Collection<Product> product;

	//public void accept(NodeVisitor visitor) {

	//}

}
