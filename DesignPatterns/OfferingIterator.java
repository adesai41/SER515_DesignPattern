import java.util.Iterator;
//this class uses iterator design pattern where user can loop through
// each offer using next, hasnext,movetohead function
public class OfferingIterator implements Iterator {

	private OfferingList offeringList;

	private int CurrentOfferingNumber=-1;

	OfferingIterator(OfferingList thisOfferingList)
	{
		offeringList=thisOfferingList;
		MoveToHead();
	}
	public boolean hasNext() {
		return CurrentOfferingNumber < offeringList.size()-1;
	}

	public Object next() {
		if(hasNext())
		{
			CurrentOfferingNumber++;
			return offeringList.get(CurrentOfferingNumber);
		}
		else
		{
			return null;
		}
	}

	Object next(String UserName)
	{
		Offering thisOffering;
		thisOffering=(Offering)next();
		while(thisOffering!=null)
		{
			if(UserName.compareTo(thisOffering.thisOfferer)==0)
			{
				return thisOffering;
			}
			thisOffering=(Offering)next();
		}
		return null;
	}


	public void MoveToHead() {
	CurrentOfferingNumber=-1;
	}

	public void Remove() {
		offeringList.remove(CurrentOfferingNumber);
	}

}
