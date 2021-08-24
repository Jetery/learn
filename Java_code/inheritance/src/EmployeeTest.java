/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.05.20
 */
public class EmployeeTest {



    public static void main(String[] args) {
        Manager manager = new Manager("小张", 50000, 1988,12, 8);
        manager.setBonus(7000);
        Employee[] staff = new Employee[3];
        staff[0] = manager;
        staff[1] = new Employee("小王",30000, 1990, 5, 20);
        staff[2] = new Employee("小李",20000, 2000, 3, 1);

        for (Employee e : staff) {
            System.out.println(e.getName() + " " + e.getSalary());
        }

    }


}
