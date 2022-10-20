import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class ProductSelectDlg extends JDialog {
    private Product SelectedProduct;
    int nProductType = 0;
    private boolean m_bLogout = false;
    private JComboBox<Product> ProductNameCom = new JComboBox<>();
    private JRadioButton MeatProductRadio = new JRadioButton();
    private JRadioButton ProduceProductRadio = new JRadioButton();
    private JLabel jLabel1 = new JLabel();
    private JButton OKButton = new JButton();
    private ButtonGroup buttonGroup1 = new ButtonGroup();
    private JButton buttonLogout = new JButton();

    ProductSelectDlg() {
        try {
            jbInit();
            setSize(420, 238);
            setModal(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() {
        this.getContentPane().setLayout(null);
        ProductNameCom.setBounds(new Rectangle(155, 41, 203, 22));
        MeatProductRadio.setText("Meat Product");
        MeatProductRadio.setBounds(new Rectangle(50, 87, 103, 26));
        ProduceProductRadio.setToolTipText("");
        ProduceProductRadio.setSelected(true);
        ProduceProductRadio.setText("Produce Product");
        ProduceProductRadio.setBounds(new Rectangle(236, 88, 103, 26));
        jLabel1.setText("ProductName");
        jLabel1.setBounds(new Rectangle(39, 44, 85, 18));
        OKButton.setText("OK");
        OKButton.setBounds(new Rectangle(78, 139, 79, 29));
        OKButton.addActionListener(this::OKButton_actionPerformed);
        buttonLogout.setText("Logout");
        buttonLogout.setBounds(new Rectangle(224, 140, 73, 31));
        buttonLogout.addActionListener(this::buttonLogout_actionPerformed);
        this.getContentPane().add(ProductNameCom, null);
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(MeatProductRadio, null);
        this.getContentPane().add(ProduceProductRadio, null);
        this.getContentPane().add(OKButton, null);
        this.getContentPane().add(buttonLogout, null);
        buttonGroup1.add(MeatProductRadio);
        buttonGroup1.add(ProduceProductRadio);
    }



    Product ShowDlg(ClassProductList productList) {

        // 0 HighLevel presentation 1 LowLevel Experiment
        ProductIterator theIterator = new ProductIterator(productList);
        Product thisProduct;
        while ((thisProduct = (Product) theIterator.next()) != null) /// end of the list
        {
            ProductNameCom.addItem(thisProduct);
        }
        setVisible(true);
        return SelectedProduct;
    }

    private void OKButton_actionPerformed(ActionEvent e) {
        SelectedProduct = (Product) ProductNameCom.getSelectedItem();
        if (MeatProductRadio.isSelected())
            nProductType = 0;
        else
            nProductType = 1;
        dispose();
    }

    boolean isLogout() {
        return m_bLogout;
    }

    private void buttonLogout_actionPerformed(ActionEvent e) {
        m_bLogout = true;
        dispose();
    }
}