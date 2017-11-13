/*
 * Diners club credit card validation
 * 
 */
package creditcard;

import java.util.Calendar;
import java.util.Date;

public class OldDinersCard {
    
  protected String cardNum; 
  protected int expMM, expYY;
  
  //constructor
  public OldDinersCard(String num, int expMonth, int expYear) {
    cardNum = num; 
    expMM = expMonth; 
    expYY = expYear; 
  } 
  
  //check for valid date
    public boolean isExpDtValid() {      
    Calendar cal = Calendar.getInstance(); 
    cal.setTime(new Date()); 
    int mm = cal.get(Calendar.MONTH) + 1; 
    int yy = cal.get(Calendar.YEAR); 
    boolean result = 
      (yy > expYY) || ((yy == expYY) && (mm > expMM)); 
    return (!result); 
  } 
    //check for valid chars
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
  
  //calc checksum
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
  
  //check number of digits
  public boolean isNumOfDigitsValid() { 
    if (cardNum.length() == 14) { 
      return true; 
    } else { 
      return false; 
    } 
  } 
  
  //check prefix
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
  public boolean isAccountInGoodStand() { 
  /* 
    Make necessary DINERS CARD API calls to 
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
  
  
}  //end diners card class
