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

	private OfferingList offeringList;

	private Product product;

	public void accept(NodeVisitor visitor) {
	visitor.visitTrading(this);
	}

}
