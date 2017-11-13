/*
 * validate visa card
 * 
 */
package creditcard;

public class VisaCard extends ChargeCard {

    //Constructor
    public VisaCard(String num, int expMonth, int expYear) {
        super(num, expMonth, expYear);
    }
    //check number of digits
    @Override
    public boolean isNumOfDigitsValid() {
        if ((cardNum.length() == 13) ||
                (cardNum.length() == 16)) {
            return true;
        } else {
            return false;
        }
    }

    //check prefix
    @Override
    public boolean isValidPrefix() {
        String prefix = cardNum.substring(0, 1);
        if (prefix.equals("4")) {
            return true;
        } else {
            return false;
        }
    }
    //Verify good standing specific to each card.
    @Override
    public boolean isAccountInGoodStand() {
        /*
          Make necessary VISA API calls to
          perform other checks.
        */
        return true;
    }
} //end visa class
