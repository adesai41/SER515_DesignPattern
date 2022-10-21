import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class OfferingPriceDlg extends JDialog {
    private Offering theOffering;
    private JLabel jLabel1 = new JLabel();
    private JTextField tfPrice = new JTextField();
    private JButton buttonOK = new JButton();
    private JLabel labelOfferingFileName = new JLabel();

    OfferingPriceDlg() {
        try {
            jbInit();
            setSize(316, 186);
            setModal(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() {
        jLabel1.setText("Initial Offer");
        jLabel1.setBounds(new Rectangle(23, 30, 121, 18));
        this.getContentPane().setLayout(null);
        tfPrice.setBounds(new Rectangle(25, 66, 100, 22));
        buttonOK.setText("OK");
        buttonOK.setBounds(new Rectangle(217, 67, 79, 29));
        buttonOK.addActionListener(this::buttonOK_actionPerformed);
        labelOfferingFileName.setBounds(new Rectangle(212, 34, 163, 18));
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(tfPrice, null);
        this.getContentPane().add(labelOfferingFileName, null);
        this.getContentPane().add(buttonOK, null);
    }

    void show(Offering offering) {
        theOffering = offering;
        tfPrice.setText(" this " + theOffering.getPriceInt());
        labelOfferingFileName.setText(theOffering.OfferFileName);
        setVisible(true);
    }

    private void buttonOK_actionPerformed(ActionEvent e) {
        theOffering.thePrice = Integer.parseInt(tfPrice.getText());
        dispose();
    }

}