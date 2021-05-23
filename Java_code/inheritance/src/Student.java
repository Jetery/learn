/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.05.23
 */
public class Student extends Person{

    private String major;

    public Student(String name, String major) {
        super(name);
        this.major = major;
    }

    @Override
    public String getDescription() {
        return super.getName() + " majoring in " + this.major;
    }
}
