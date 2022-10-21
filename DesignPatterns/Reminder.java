//this class is implemented in both facade and visitor pattern
//--------FACADE DESIGN PATTERN-----------
// It is conneccted to the main facade class which acts like an interface
// and allows to navigate through different classes based on operation
//---------------------------------------
//-------VISITOR DESIGN PATTERN-----------
//This class will use the visitor to visit all the
//products and trading of a given user.
//---------------------------------------
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

class Reminder extends JDialog {
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    java.awt.List listUpcoming = new java.awt.List();
    java.awt.List listOverdue = new java.awt.List();
    private Button buttonOK = new Button();

    Reminder() {
        try {
            jbInit();
            setModal(true);
            setSize(400, 386);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() {
        jLabel1.setText("Upcoming trades");
        jLabel1.setBounds(new Rectangle(38, 40, 159, 17));
        this.getContentPane().setLayout(null);
        jLabel2.setText("OverDue trades");
        jLabel2.setBounds(new Rectangle(39, 160, 161, 17));
        listUpcoming.setBounds(new Rectangle(29, 65, 340, 79));
        listOverdue.setBounds(new Rectangle(31, 187, 337, 85));
        buttonOK.setLabel("OK");
        buttonOK.setBounds(new Rectangle(149, 308, 67, 37));
        buttonOK.addActionListener(this::buttonOK_actionPerformed);
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(listUpcoming, null);
        this.getContentPane().add(listOverdue, null);
        this.getContentPane().add(buttonOK, null);
    }

    void showReminder(ClassProductList products) {
        ReminderVisitor visitor = new ReminderVisitor(this);
        products.InitializeFromFile();
        visitor.visitFacade(Auction.theFacade);
        setVisible(true);
    }

    private void buttonOK_actionPerformed(ActionEvent e) {
        dispose();
    }
}