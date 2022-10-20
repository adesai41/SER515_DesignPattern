import java.util.*;
public class Offering {
    String thisOfferer = "";
    String OfferFileName = "";
    Date thisSubmitData = new Date();
    int thePrice;
    private boolean offered = false;

    Offering() {
    }

    @Override
    public String toString() {
        String string;
        string = thisOfferer + "  " + OfferFileName + " Price=" + getPriceInt() + "  ";
        if (isReported())
            string += "offered";
        else
            string += "not offered";

        return (string);
    }

    String getPriceString() {
        if (isReported())
            return "" + thePrice;
        else
            return "-1";
    }
    void setDes() {
        this.offered = true;
    }

    int getPriceInt() {
        return thePrice;
    }

    void setReported() {
        this.offered = true;
    }

    private boolean isReported() {
        return offered;
    }
}
