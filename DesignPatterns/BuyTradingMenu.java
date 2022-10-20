import javax.swing.*;
import java.awt.*;
import java.util.Date;


public class BuyTradingMenu extends TradingMenu {

    private boolean boolSubmit = false;

    private JLabel lTradingName = new JLabel();
    private JLabel lDueDate = new JLabel();
    private JTextField tbOffering = new JTextField();
    private JLabel lSuggestedOffering = new JLabel();
    private JLabel lPrice = new JLabel();
    private JButton bSubmit = new JButton();
    private JButton bCancel = new JButton();

    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel3 = new JLabel();
    private JLabel jLabel5 = new JLabel();
    private JLabel jLabel6 = new JLabel();
    private JLabel jLabel7 = new JLabel();

    BuyTradingMenu() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() {
        jLabel1.setText("Trade : ");
        jLabel1.setBounds(new Rectangle(20, 36, 91, 18));
        this.getContentPane().setLayout(null);
        lTradingName.setText("jLabel2");
        lTradingName.setBounds(new Rectangle(258, 35, 282, 18));
        jLabel3.setText("Due Date");
        jLabel3.setBounds(new Rectangle(21, 81, 92, 18));
        lDueDate.setText("jLabel4");
        lDueDate.setBounds(new Rectangle(254, 82, 294, 18));
        jLabel5.setText("Offer");
        jLabel5.setBounds(new Rectangle(24, 128, 93, 18));
        tbOffering.setText("jTextField1");
        tbOffering.setBounds(new Rectangle(251, 127, 211, 22));
        jLabel6.setText("Suggested Offer");
        jLabel6.setBounds(new Rectangle(24, 174, 117, 18));
        jLabel7.setText("Price");
        jLabel7.setBounds(new Rectangle(23, 224, 41, 18));
        lSuggestedOffering.setText("jLabel8");
        lSuggestedOffering.setBounds(new Rectangle(259, 169, 201, 18));
        lPrice.setText("jLabel9");
        lPrice.setBounds(new Rectangle(258, 226, 41, 18));
        bSubmit.setText("Submit");
        bSubmit.setBounds(new Rectangle(476, 124, 79, 29));
        bSubmit.addActionListener(e -> bSubmit_actionPerformed());
        bCancel.setText("Cancel");
        bCancel.setBounds(new Rectangle(475, 164, 79, 29));
        bCancel.addActionListener(e -> bCancel_actionPerformed());
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(jLabel3, null);
        this.getContentPane().add(jLabel5, null);
        this.getContentPane().add(jLabel6, null);
        this.getContentPane().add(lTradingName, null);
        this.getContentPane().add(lDueDate, null);
        this.getContentPane().add(tbOffering, null);
        this.getContentPane().add(jLabel7, null);
        this.getContentPane().add(lSuggestedOffering, null);
        this.getContentPane().add(lPrice, null);
        this.getContentPane().add(bSubmit, null);
        this.getContentPane().add(bCancel, null);
    }


    public void ShowMenu(Trading trading, Person thisPerson) {
        OfferingIterator theIter = trading.GetOfferingIterator();
        Offering thisOffering = (Offering) theIter.next(thisPerson.UserName);
        if (thisOffering == null) {
            tbOffering.setText("");
            lPrice.setText("-1");
        } else {
            tbOffering.setText(thisOffering.OfferFileName);
            lPrice.setText(thisOffering.getPriceString());

        }

        lTradingName.setText(trading.TradingName);
        lDueDate.setText(trading.DueDate.toString());
        lSuggestedOffering.setText(trading.SuggestOffering.OfferFileName);

        setVisible(true);

        if (boolSubmit) {
            if (thisOffering == null) {
                thisOffering = new Offering();
                trading.AddOffering(thisOffering);
            }
            thisOffering.thisOfferer = thisPerson.UserName;
            thisOffering.OfferFileName = tbOffering.getText();
            thisOffering.thisSubmitData = new Date();
        }
    }

    private void bSubmit_actionPerformed() {
        boolSubmit = true;
        dispose();
    }

    private void bCancel_actionPerformed() {
        boolSubmit = false;
        dispose();
    }

}