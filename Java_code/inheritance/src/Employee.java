import java.time.LocalDate;

public class Employee extends Person{

    private double salary;
    private LocalDate hireday;

    public Employee(String n, double s, int year, int month, int day) {
        super(n);
        this.salary = s;
        this.hireday = LocalDate.of(year, month, day);
    }

    @Override
    public String getDescription() {
        return String.format(super.getName() + " earns %.2f",this.salary);
    }

    public String getName() {
        return super.getName();
    }

    public double getSalary() {
        return this.salary;
    }

    public LocalDate getHireday() {
        return this.hireday;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + super.getName() + '\'' +
                ", salary=" + salary +
                ", hireday=" + hireday +
                '}';
    }
}
