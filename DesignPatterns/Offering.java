import java.util.*;
public class Offering {
    String thisOfferer = "";
    String OfferFileName = "add your offer";
    Date thisSubmitData = new Date();
    int thePrice;
    private boolean offered = false;

    Offering() {
    }

    @Override
    public String toString() {
        String string;
        string = thisOfferer + "  " + OfferFileName + " Price=" + getPriceInt() + "  ";
        if (isOffered())
            string += "offered";
        else
            string += "not offered";

        return (string);
    }

    String getPriceString() {
        if (isOffered())
            return "" + thePrice;
        else
            return "-1";
    }
    void setOffer() {
        this.offered = true;
    }

    int getPriceInt() {
        return thePrice;
    }

    private boolean isOffered() {
        return offered;
    }
}
