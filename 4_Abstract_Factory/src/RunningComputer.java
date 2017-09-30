import factories.ApplicationResFactory;
import factories.HRApplicationResFactory;
import factories.LRApplicationResFactory;

public class RunningComputer extends Computer {
    @Override
    protected Application createApplication(String type) {
        Application application = null;


        //Because we only want one instance running at a time using a single computer to run either of these factories
        //This is also applying the lessons from chapter 4 Decorating

        if (type.equals("highRes")) {
            application = new RunningApplication(new HRApplicationResFactory());
            application.prepare();
        }

        if (type.equals("lowRes")) {
            application = new RunningApplication(new LRApplicationResFactory());
            application.prepare();
        }

        return application;
    }
}
