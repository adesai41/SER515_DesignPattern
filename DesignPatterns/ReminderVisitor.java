import java.util.*;
//this class uses visitor design pattern. This provides capacity for the reminder class to
// visit products and trades

public class ReminderVisitor extends NodeVisitor {

	private Reminder m_Reminder;

	ReminderVisitor(Reminder reminder) {
		m_Reminder = reminder;
	}

	public void visitFacade(Facade facade) {
		ProductIterator productList = new ProductIterator(facade.thisProductList);
		while (productList.hasNext()) {
			Product product = (Product) productList.next();
			product.accept(this);
		}
	}

	public void visitProduct(Product product) {
		for (Trading trade : product.TradingList) {
			trade.accept(this);
		}
	}

	public void visitTrading(Trading trading) {
		Date today = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		int ntoday = calendar.get(Calendar.DAY_OF_YEAR);
		calendar.setTime(trading.DueDate);
		int nDueDate = calendar.get(Calendar.DAY_OF_YEAR);
		if (nDueDate <= (ntoday + 1) && nDueDate >= ntoday) /// upcoming
		{

			m_Reminder.listUpcoming.add("today is " + today + " " + trading.TradingName + " Due Date is "
					+ trading.getDueDateString());
		}
		if (nDueDate < ntoday) {
			// put to the
			m_Reminder.listOverdue.add(trading.TradingName + " Due Date is " + trading.getDueDateString());
		}

	}

}