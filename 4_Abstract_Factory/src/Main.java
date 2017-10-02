import javax.management.relation.RelationNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //RunningApplication ra = null;
        Application ra = null;
        Computer rc = new RunningComputer();

        String currentSelection = "";

        while (!currentSelection.equals("4")) {
            System.out.println("1. Start a low res application");
            System.out.println("2. Start a high res application");
            System.out.println("3. Check if app is running");
            System.out.println("4. Exit");
            System.out.print("Enter Selection: ");
            currentSelection = sc.nextLine();
            switch (currentSelection) {
                case "1":
                    ra = rc.orderApplication("lowRes");
                    break;
                case "2":
                    ra = rc.orderApplication("highRes");
                    break;
                case "3":
                    if (ra != null) {
                        ra.display();
                    }
                    else {
                        System.out.println("There is not an application running.");
                    }
                    break;
                default:
                    System.out.println("Unknown Command, Try again.");
            }
        }
    }
}
