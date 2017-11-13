  /*
 * Validate Master card number
 */
package creditcard;
import java.util.Calendar;
import java.util.Date;   

public class OldMasterCard {
  protected String cardNum; 
  protected int expMM, expYY; 
  //constructor  
  public OldMasterCard(String num, int expMonth, int expYear) {
    cardNum = num; 
    expMM = expMonth; 
    expYY = expYear; 
  } 
  
   public boolean isExpDtValid() { 
      
      
    Calendar cal = Calendar.getInstance(); 
    cal.setTime(new Date()); 
    int mm = cal.get(Calendar.MONTH) + 1; 
    int yy = cal.get(Calendar.YEAR); 
    boolean result = 
      (yy > expYY) || ((yy == expYY) && (mm > expMM)); 
    return (!result); 
  } 
  private boolean hasValidChars() { 
    String validChars = "0123456789";
    boolean result = true; 
    for (int i = 0; i < cardNum.length(); i++) { 
      if (validChars.indexOf(cardNum.substring(i, i + 1)) <
          0) { 
        result = false; 
        break; 
      } 
    } 
    return result; 
    } 
  
  
  private boolean isValidCheckSum() { 
  boolean result = true; 
  int sum = 0; 
  int multiplier = 1; 
  int strLen = cardNum.length(); 
  for (int i = 0; i < strLen; i++) { 
    String digit = cardNum.substring(strLen - i - 1, 
                 strLen - i);
    int currProduct = 
      new Integer(digit).intValue() * multiplier; 
    if (currProduct >= 10) 
      sum += (currProduct% 10) + 1; 
    else 
      sum += currProduct; 
    if (multiplier == 1) 
      multiplier++; 
    else 
      multiplier -- ; 
    } 
    if ((sum% 10) != 0) 
      result = false; 
    return result; 
  } 
  
  public boolean isNumOfDigitsValid() { 
    if (cardNum.length() == 16) { 
      return true; 
    } else { 
      return false; 
    } 
  } 
  public boolean isValidPrefix() { 
    String prefix = cardNum.substring(0, 1); 
    String nextChar = cardNum.substring(1, 2); 
    String validChars = "12345";
    //51-55 
    if ((prefix.equals("5")) &&
        (validChars.indexOf(nextChar) >= 0)) { 
      return true; 
    } else { 
      return false; 
    } 
  } 
  public boolean isAccountInGoodStand() { 
    /* 
      Make necessary MASTER CARD API calls to 
      perform other checks.
    */ 
    return true; 
  } 
  
  public boolean isValid() { 
    if (!isExpDtValid()) { 
      System.out.println(" Invalid Exp Dt. ");
      return false; 
    } 
    if (!isNumOfDigitsValid()) { 
      System.out.println(" Invalid Number of Digits ");
      return false; 
    } 
    if (!isValidPrefix()) { 
      System.out.println(" Invalid Prefix ");
      return false; 
    }
    if (!hasValidChars()) { 
      System.out.println(" Invalid Characters ");
      return false; 
    } 
    if (!isValidCheckSum()) { 
      System.out.println(" Invalid Check Sum ");
      return false; 
    } 
    if (!isAccountInGoodStand()) { 
      System.out.println( 
        " Account is Inactive/Revoked/Over the Limit ");
      return false; 
    } 
    return true; 
  } 
  
}