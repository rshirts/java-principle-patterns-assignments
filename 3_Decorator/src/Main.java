import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        //Create Output File
        FileWriter outputFile = null;

        try {
            File outFile = new File("decoratedOutput.dat") ;
            outputFile = new FileWriter(outFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Create Output with wrappers
        Output output = new StreamOutput(outputFile);

        //capture Menu input
        String choice = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //Provide menu.
        while( choice == null || !choice.equals("") ) {
            //reset choice
            choice = "";
            //present menu
            System.out.println("1. Wrap with LineOutput class.");
            System.out.println("2. Wrap with numberedOutput class.");
            System.out.println("3. Wrap with TeeOutput class.");
            System.out.println("4. Wrap with FilterOuput class.");
            System.out.println("Enter a number to add wrapper.");
            System.out.println("Press enter with empty selection to continue with processing file.");
            try {
                choice = br.readLine();
            } catch (IOException e) {
                System.out.println("Unable to read that line.");
            }
            if (choice.equals("1")) {
                output = new LineOutput(output);
                System.out.println("Added LineOutput Wrapper. (each line is on a new line).\n");
            } else if (choice.equals("2")) {
                output = new NumberedOutput(output);
                System.out.println("Added NumberedOutput Wrapper. (lines will be preceeded by a number)\n");
            } else if (choice.equals("3")) {

                //Prompt for sedond output.
                String choiceTeeOuput = "";
                BufferedReader brTeeOutput = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Name of output file (blank for console): ");
                try {
                    choiceTeeOuput = brTeeOutput.readLine();
                } catch (IOException e) {
                    System.out.println("Unable to read that line.");
                }
                //create second output
                if(choiceTeeOuput.equals("")) {
                    //add console as an output
                    Output output2 = new StreamOutput(new PrintWriter(System.out));
                    output = new TeeOutput(output, output2);
                } else {
                    //create another output
                    try {
                        File outFile2 = new File(choiceTeeOuput) ;
                        Output teeOutputFile = new StreamOutput(new FileWriter(outFile2));
                        output = new TeeOutput(output, teeOutputFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else if (choice.equals("4")) {
                String choiceFilterOutput = null;
                BufferedReader brFilterOutput = new BufferedReader(new InputStreamReader(System.in));
                //reset choice
                choiceFilterOutput = "";
                //present menu
                System.out.println("1. Use contains a number filter.");
                System.out.println("2. Line Length filter.");
                try {
                    choiceFilterOutput = brFilterOutput.readLine();
                } catch (IOException e) {
                    System.out.println("Unable to read that line.");
                }

                //Apply filter
                if (choiceFilterOutput.equals("1")){
                    output = new FilterOutput(output, new TestContainsNumber());
                    System.out.println("Number filter applied.");
                } else if (choiceFilterOutput.equals("2")){
                    output = new FilterOutput(output, new TestStringLength());
                    System.out.println("Line length filter applied.");
                } else {
                    System.out.println("No filter applied.");
                }
            }
        }
        String filename = null;
        boolean opened = false;
        File inFile = null;
        BufferedReader brInFile = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = null;
        String currentLine;

        while (filename == null || opened == false) {
            System.out.print("Please enter a file name to process: ");
            try {
                filename = brInFile.readLine();
                inFile = new File(filename);
                scanner = new Scanner(inFile);
            } catch (FileNotFoundException e) {
                System.out.println("Unable to open file with name: " + inFile.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (scanner != null) {
                opened = true;
            }
        }
        if (opened) {
            System.out.println("Processing File...");
            while (scanner.hasNextLine()) {
                currentLine = scanner.nextLine();
                output.writeString(currentLine);
            }
        }
    }
}
