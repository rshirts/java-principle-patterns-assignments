/*
 * Program to verify credit cards
 * this is the driver program
 */
package creditcard;

public class OldClient {
  public static void main(String[] args) { 
   
      //visa card
    System.out.println("Visa Card Info:"); 
    OldVisaCard myVisa =
    new OldVisaCard("4321563234125", 11, 2018);
    if (myVisa.isValid()) 
      System.out.println("Valid Credit Card Information");
    
    //diner card
        
    System.out.println("\nDiner Card Info:"); 
      OldDinersCard myDiner =
      new OldDinersCard("38520000023237", 11, 2018);
      if (myDiner.isValid()) 
        System.out.println("Valid Credit Card Information");
    
    // master card
    System.out.println("\nMaster Card Info:"); 
    OldMasterCard myMaster =
    new OldMasterCard("5555555555554444", 11, 2018);
    if (myMaster.isValid()) 
      System.out.println("Valid Credit Card Information");
    
    
    
    
  } 
}