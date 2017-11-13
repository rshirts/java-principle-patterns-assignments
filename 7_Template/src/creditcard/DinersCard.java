/*
 * Diners club credit card validation
 * 
 */
package creditcard;

public class DinersCard extends ChargeCard {

  //constructor
  public DinersCard(String num, int expMonth, int expYear) { 
    super(num, expMonth, expYear);
  }

    //check number of digits
    @Override
    public boolean isNumOfDigitsValid() {
        if (cardNum.length() == 14) {
            return true;
        } else {
            return false;
        }
    }

    //check prefix
    @Override
    public boolean isValidPrefix() {
        String prefix = cardNum.substring(0, 1);
        String nextChar = cardNum.substring(1, 2);
        String validChars = "068";  //2nd char must be a 0 or 6, or 8
        //51-55
        if ((prefix.equals("3")) &&   //prefix must be
                (validChars.indexOf(nextChar) >= 0)) {
            return true;
        } else {
            return false;
        }
    }

    //Verify good standing specific to each card.
    @Override
    public boolean isAccountInGoodStand() {
        /*
        Make necessary DINERS CARD API calls to
        perform other checks.
        */
        return true;
    }
}  //end diners card class
