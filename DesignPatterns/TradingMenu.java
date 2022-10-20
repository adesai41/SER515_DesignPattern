import javax.swing.*;
abstract  class TradingMenu extends JDialog {
    abstract void ShowMenu(Trading trade, Person thisPerson);
    TradingMenu()
    {
        setModal(true);
        setSize(575,330);
    }

}
