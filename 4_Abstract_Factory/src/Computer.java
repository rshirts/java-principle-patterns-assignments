public abstract class Computer {


    public Application orderApplication(String type) {
        Application application;

        application = createApplication(type);

        application.display();

        return application;
    }

    protected abstract Application createApplication(String type);

}
