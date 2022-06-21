package sky.pro.hw28streamapioptional.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface EmployeeService {

    Employee addEmployee(String firstName, String middleName, String lastName, int department, double salary);
    Employee removeEmployee(String firstName, String middleName, String lastName);
    Employee findEmployee(String firstName, String middleName, String lastName);
    List<Employee> allEmployeeList();

    Map<String, Set<Employee>> departmentEmployeeList(int department);
    Employee findEmployeeWithMaxSalary(int department);

    Employee findEmployeeWithMinSalary(int department);

    Map<String, Set<Employee>> allDepartmentsEmployeeList();
}
