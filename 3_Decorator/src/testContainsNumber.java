public class TestContainsNumber implements Predicate {
    @Override
    public boolean testCondition(String testString) {
        for (char c: testString.toCharArray()) {
            if(Character.isDigit(c)) {return true;}
        }
        return false;
    }
}
