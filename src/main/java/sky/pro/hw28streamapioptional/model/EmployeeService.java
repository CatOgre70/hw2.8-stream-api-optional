package sky.pro.hw28streamapioptional.model;

public interface EmployeeService {

    Employee addEmployee(String firstName, String middleName, String lastName, int department, double salary);
    Employee removeEmployee(String firstName, String middleName, String lastName);
    Employee findEmployee(String firstName, String middleName, String lastName);
    Employee[] allEmployeeList();

    Employee[] departmentEmployeeList(int department);
    Employee findEmployeeWithMaxSalary(int department);

    Employee findEmployeeWithMinSalary(int department);

    Employee[] allDepartmentsEmployeeList();
}
