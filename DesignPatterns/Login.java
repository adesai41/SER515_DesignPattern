import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
//this class is a part of FACADE DESIGN PATTERN.
// It is conneccted to the main facade class which acts like an interface
// and allows to navigate through different classes based on operation
//---------------------------------------
class Login extends JDialog {

    private boolean m_bExit = false;
    //creating gui for login panel
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JButton loginButton = new JButton();
    private JButton buttonExit = new JButton();
    private JTextField UserNameText = new JTextField();
    private JPasswordField PasswordText = new JPasswordField();
    private JRadioButton SellerRadio = new JRadioButton();
    private JRadioButton BuyerRadio = new JRadioButton();
    private ButtonGroup buttonGroup1 = new ButtonGroup();
    private String UserBox = null;
    private UserInfoItem.USER_TYPE UserType = UserInfoItem.USER_TYPE.Seller;//default selection
    // will be of seller


    Login() {
        try {
            jbInit();
            setSize(300, 300);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//initialize gui panel. used radio button,labels and buttons to create gui
    private void jbInit() {
        this.getContentPane().setLayout(null);
        jLabel1.setText("UserName");
        jLabel1.setBounds(new Rectangle(26, 52, 80, 18));
        jLabel2.setText("Password");
        jLabel2.setBounds(new Rectangle(23, 119, 80, 18));
        loginButton.setText("Login");
        loginButton.setBounds(new Rectangle(31, 212, 85, 28));
        loginButton.addActionListener(this::loginButton_actionPerformed);
        buttonExit.setText("Exit");
        buttonExit.setBounds(new Rectangle(180, 211, 97, 28));
        buttonExit.addActionListener(e -> buttonExit_actionPerformed());
        UserNameText.setBounds(new Rectangle(119, 52, 144, 22));
        PasswordText.setBounds(new Rectangle(118, 119, 147, 22));
        SellerRadio.setSelected(true);
        SellerRadio.setText("Seller");
        SellerRadio.setBounds(new Rectangle(37, 164, 103, 26));
        BuyerRadio.setText("Buyer");
        BuyerRadio.setBounds(new Rectangle(177, 162, 103, 26));
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(loginButton, null);
        this.getContentPane().add(buttonExit, null);
        this.getContentPane().add(UserNameText, null);
        this.getContentPane().add(PasswordText, null);
        this.getContentPane().add(SellerRadio, null);
        this.getContentPane().add(BuyerRadio, null);
        buttonGroup1.add(SellerRadio);
        buttonGroup1.add(BuyerRadio);
    }
//perform login validation on button click. Here we read
// through respective files to validate user
    private void loginButton_actionPerformed(ActionEvent e) {
        BufferedReader file;
        m_bExit = false;

        try {
            if (SellerRadio.isSelected())// seller
            {
                UserType = UserInfoItem.USER_TYPE.Seller;
                file = new BufferedReader(new FileReader("SellerInfo.txt"));

            } else// buyer
            {
                UserType = UserInfoItem.USER_TYPE.Buyer;
                file = new BufferedReader(new FileReader("BuyerInfo.txt"));
            }
            UserBox = UserNameText.getText();
            String PasswordBox = new String(PasswordText.getPassword());
            String LoginName = null;
            String aline, UserName, Password;
            while ((aline = file.readLine()) != null)
            {
                UserName = GetUserName(aline);
                Password = GetPassword(aline);
                if (UserName.compareTo(UserBox) == 0 && Password.compareTo(PasswordBox) == 0)
                    LoginName = UserName;
            }
            if (LoginName != null) {
                this.dispose();
            }
        } catch (Exception ignored) {
        }

    }


    private String GetUserName(String aline) {
        int Sep = aline.lastIndexOf(':');
        return aline.substring(0, Sep);
    }


    private String GetPassword(String aline) {
        int Sep = aline.lastIndexOf(':');
        return aline.substring(Sep + 1);
    }

    String GetUserName() {
        return UserBox;
    }


    UserInfoItem.USER_TYPE GetUserType() {
        return UserType;
    }

    boolean isExit() {
        return m_bExit;
    }

    private void buttonExit_actionPerformed() {
        m_bExit = true;
        dispose();
    }
}