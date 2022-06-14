package sky.pro.hw28streamapioptional.model;

public class Employee {

    private String key;
    private final String firstName;
    private final String middleName;
    private final String secondName;
    private int department;
    private double salary;

    public Employee(String firstName, String middleName, String secondName, int department, double salary) {
        if(firstName == null || secondName == null || salary <= 0 || !EmployeeServiceImpl.dBook.checkId(department)){
            throw new IllegalArgumentException("Wrong argument(s) in Employee class constructor");
        }
        this.firstName = firstName;
        this.middleName = middleName;
        this.secondName = secondName;
        this.department = department;
        this.salary = salary;
        this.key = firstName + middleName + secondName;

    }

    public String getKey() {
        return key;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}
