public class Auction {
    static Facade theFacade = new Facade();

    public Auction() {
    }

    public static void main(String[] args) {
//		String strUsername;
//		String strUserType = null;
        UserInfoItem userinfoitem = new UserInfoItem();
        theFacade.CreateProductList();
        while (true) {
            boolean bExit;
            bExit = Facade.Login(userinfoitem);
            if (bExit)
                break;
            // userinfoitem.strUserName = "Inst1";
            // userinfoitem.UserType = 1;
            theFacade.CreateUser(userinfoitem);
            theFacade.AttachProductToUser();
            if (userinfoitem.UserType == UserInfoItem.USER_TYPE.Seller) // if is a seller remind him of the due date
                theFacade.Remind();
            boolean bLogout = false;
            while (!bLogout) {
                bLogout = theFacade.SelectProduct();
                if (bLogout)
                    break;
                bLogout = theFacade.ProductOperation();
            }
        }
//    System.out.println(userinfoitem.strUserName +userinfoitem.UserType );
    }
}
