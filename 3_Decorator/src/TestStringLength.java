public class TestStringLength implements Predicate {
    @Override
    public boolean testCondition(String testString) {
        if(testString.length() > 50) {return true;}
        return false;
    }
}
