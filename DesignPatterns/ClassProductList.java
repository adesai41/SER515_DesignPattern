import java.util.Collection;
public class ClassProductList extends ArrayList {

	private ProductIterator productIterator;

	private ReminderVisitor reminderVisitor;

	private Collection<Product> product;

	public void accept(NodeVisitor visitor) {

	}

}
