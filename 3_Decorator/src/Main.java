import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {
        //Input
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        //Output
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        File fileOut = null;

        //FileOutputStream fos2 = null;

        Writer writer = null;
        File fileOut2 = null;

        //Custom Output
        StreamOutput so = null;

        try {
            //inputs
            fis = new FileInputStream("decorator.dat");
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);

            //output files
            fileOut = new File("decoratorOut.dat");
            fileOut2 = new File( "decoratorOut2.dat");

            //Standard outputs
            fos = new FileOutputStream(fileOut);
            osw = new OutputStreamWriter(fos);
            bw = new BufferedWriter(osw);

            //custom Outputs
            //fos2 = new FileOutputStream(fileOut2);
            //so = new StreamOutput(fos2);
            String currentLine;
            while((currentLine = br.readLine()) != null) {
                bw.write(currentLine);
                bw.newLine();
            }


            //Close Resources
            br.close();
            isr.close();
            fis.close();

            bw.close();
            osw.close();
            fos.close();
            //fos2.close();


        } catch(Exception e) {
            System.out.println("There was a problem with the imput stream reader.");
        }
    }
}
