import java.util.*;
import java.text.DateFormat;
public class Trading {
	String TradingName;
	OfferingList thisOfferingList=new OfferingList();
	Date DueDate=new Date();
	Offering SuggestOffering=new Offering();

	public Trading(){

	}

	void AddOffering(Offering thisOffering)
	{
		thisOfferingList.add(thisOffering);
	}

	OfferingIterator GetOfferingIterator()
	{
		return new OfferingIterator(thisOfferingList);
	}

	public String toString()
	{
		return TradingName;
	}

	String getDueDateString()
	{
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
		return dateFormat.format(DueDate);
	}


	//private Product product;

	public void accept(NodeVisitor visitor) {
	visitor.visitTrading(this);
	}

}
