/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.05.23
 */
public class PersonTest {

    public static void main(String[] args) {

        Person[] people = new Person[2];
        people[0] = new Employee("小张", 50000, 1988,12, 8);
        people[1] = new Student("小李","Computer");

        for (Person p : people) {
            System.out.println(p.getDescription());
        }

    }

}
