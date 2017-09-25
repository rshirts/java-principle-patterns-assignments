import javax.sound.sampled.Line;
import java.io.*;

public class MainTwo {

    public static void main(String[] args) throws IOException {

        Writer writer =  new PrintWriter(System.out);

        Output myOutput = new LineOutput(new StreamOutput(writer));

        Output oldOutput = new StreamOutput(writer);

        String testing = "testing 1 2 3...";

        oldOutput.writeString(testing);
        oldOutput.writeString(testing);

        System.out.println();

        myOutput.writeString(testing);
        myOutput.writeString(testing);

    }
}
