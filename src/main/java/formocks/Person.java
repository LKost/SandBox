package formocks;

public abstract class Person {

    public abstract String getName();

    public int getAge() {
        return 25;
    }

    public static int staticMethodForMocks() {
        return 354;
    }
}
