import javax.swing.*;
//this class is a part of facade design pattern.
// It is conneccted to the main facade class which acts like an interface
// and allows to navigate through different classes based on operation
abstract  class TradingMenu extends JDialog {
    abstract void ShowMenu(Trading trade, Person thisPerson);
    TradingMenu()
    {
        setModal(true);
        setSize(575,330);
    }

}
