//Author : Aakanksha Desai
//SER515 Design Pattern
//we will use this class as a start to our PTBS system. this class contains main
// method which will be triggered when run
public class Auction {

    static Facade theFacade = new Facade();

    public Auction() {
        //constructor for Auction
    }

    public static void main(String[] args) {
//fetching user info and validating user based on two roles i.e Buyer or Seller
        UserInfoItem userinfoitem = new UserInfoItem();
        //creating a productlist  which will contain products mapped to user signed in
        theFacade.CreateProductList();
        while (true) {
            boolean bExit;
            bExit = Facade.Login(userinfoitem);//using facade DP for login
            if (bExit)
                break;

            theFacade.CreateUser(userinfoitem);
            theFacade.AttachProductToUser();
            if (userinfoitem.UserType == UserInfoItem.USER_TYPE.Buyer)//if user is  buyer , we will remind him of upcoming offer due as soon as they log in
                theFacade.Remind();

            boolean bLogout = false;
            while (!bLogout) {
                //when logged in ask display product list
                bLogout = theFacade.SelectProduct();
                if (bLogout)
                    break;
                bLogout = theFacade.ProductOperation();
            }
        }
        //exit
    System.out.println("exit" );
    }
}
