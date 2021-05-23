/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.05.20
 */
public class Manager extends Employee{
    private double bonus;

    public Manager(String name, double salary, int year, int month, int day){
        super(name, salary, year, month, day);
        bonus = 0;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getSalary(){
        double baseSalary = super.getSalary();
        return baseSalary + this.bonus;
    }

    @Override
    public String toString() {
        String s = super.toString();
        return "Manager{ " +
                s +
                " bonus=" + bonus +
                '}';
    }
}
