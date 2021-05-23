/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.05.23
 */
public abstract class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public abstract String getDescription();

    public String getName() {
        return name;
    }
}
