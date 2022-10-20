import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DateFormat;


public class SellerTradingMenu extends TradingMenu
{
    private Trading thisTrading;
    private JComboBox<Offering> CombOfferList = new JComboBox<>();
////////////////////////


    private JTextField tbTradingName = new JTextField();
    private JTextField tbDueDate = new JTextField();
    private JTextField tbSuggestedOffer = new JTextField();

    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel3 = new JLabel();
    private JButton buttonPrice = new JButton();
    private JButton buttonDes = new JButton();
    private JButton buttonClose = new JButton();

    SellerTradingMenu()
    {
        try
        {
            jbInit();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    private void jbInit() {
        jLabel1.setText("Trade Name");
        jLabel1.setBounds(new Rectangle(25, 31, 118, 18));
        this.getContentPane().setLayout(null);
        tbTradingName.setText("jTextField1");
        tbTradingName.setBounds(new Rectangle(192, 31, 341, 22));
        jLabel2.setText("Due Date");
        jLabel2.setBounds(new Rectangle(28, 90, 113, 18));
        tbDueDate.setText("tbDueDate");
        tbDueDate.setBounds(new Rectangle(195, 87, 337, 22));
        jLabel3.setText("Suggested Offer");
        jLabel3.setBounds(new Rectangle(28, 151, 118, 18));
        tbSuggestedOffer.setText("jTextField2");
        tbSuggestedOffer.setBounds(new Rectangle(197, 149, 339, 22));
        buttonPrice.setText("Price");
        buttonPrice.setBounds(new Rectangle(458, 199, 79, 29));
        buttonPrice.addActionListener(this::buttonPrice_actionPerformed);
        buttonDes.setText("Description");
        buttonDes.setBounds(new Rectangle(365, 249, 79, 29));
        buttonDes.addActionListener(this::buttonDes_actionPerformed);
        buttonClose.setText("Close");
        buttonClose.setBounds(new Rectangle(86, 253, 79, 29));
        buttonClose.addActionListener(this::buttonClose_actionPerformed);
        CombOfferList.setBounds(new Rectangle(32, 204, 413, 22));
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(tbTradingName, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(tbDueDate, null);
        this.getContentPane().add(jLabel3, null);
        this.getContentPane().add(tbSuggestedOffer, null);
        this.getContentPane().add(buttonClose, null);
        this.getContentPane().add(CombOfferList, null);
        this.getContentPane().add(buttonPrice, null);
        this.getContentPane().add(buttonDes, null);
    }
    public void ShowMenu(Trading trade, Person person)
    {
        thisTrading=trade;
        tbTradingName.setText(thisTrading.TradingName );

        DateFormat theDateFormat=DateFormat.getDateInstance(DateFormat.SHORT );
        tbDueDate.setText(theDateFormat.format(thisTrading.DueDate));
        tbSuggestedOffer.setText(thisTrading.SuggestOffering.OfferFileName );
        refreshOfferingList();
        setVisible(true);
    }

    private void buttonClose_actionPerformed(ActionEvent e)
    {
        thisTrading.TradingName = tbTradingName.getText() ;
        DateFormat tempDateFormat=DateFormat.getDateInstance(DateFormat.SHORT );
        try
        {
            thisTrading.DueDate=tempDateFormat.parse(tbDueDate.getText() );
        }catch (Exception ignored){}
        thisTrading.SuggestOffering.OfferFileName =tbSuggestedOffer.getText() ;
        dispose();
    }

    private void buttonPrice_actionPerformed(ActionEvent e)
    {
        Offering thisOffering=(Offering)CombOfferList.getSelectedItem() ;
        if (thisOffering==null)
            return;
        OfferingPriceDlg dlg=new OfferingPriceDlg();
        dlg.show(thisOffering);
        refreshOfferingList();
    }

    private void buttonDes_actionPerformed(ActionEvent e)
    {
        OfferingIterator iter=new OfferingIterator(thisTrading.thisOfferingList );
        while(iter.hasNext() )
        {
            Offering aOffer=(Offering) iter.next();
            aOffer.setDes();
        }
        refreshOfferingList();
    }
    private void refreshOfferingList()
    {
        CombOfferList.removeAllItems() ;
        OfferingIterator SolIter=new OfferingIterator(thisTrading.thisOfferingList );
        while(SolIter.hasNext() )
        {
            Offering thisOffering = (Offering) SolIter.next();
            CombOfferList.addItem(thisOffering);
        }
    }
}