package sky.pro.hw28streamapioptional.model;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeBook {

    Map<String, Employee> eBook;

    public EmployeeBook() {
        this.eBook = new HashMap<>();
    }

    public Employee add(Employee e){

        if(e != null) {
            String key = e.getKey();
            eBook.put(key, e);
            return eBook.get(key);
        } else {
            throw new NullPointerException("Employee object is null");
        }
    }

    public Employee add(String fistName, String middleName, String lastName, int department, double salary){
        Employee e = new Employee(fistName, middleName, lastName, department, salary);
        String key = e.getKey();
        eBook.put(key, e);
        return eBook.get(key);
    }

    public Employee remove(String fistName, String middleName, String lastName) {
        String key = fistName + middleName + lastName;
        if(eBook.containsKey(key)){
            return eBook.remove(key);
        } else {
            throw new RuntimeException("Employee with such name, middle name and second name is not " +
                    "found in the employee book");
        }
    }

    public Employee find(String fistName, String middleName, String lastName){
        String key = fistName + middleName + lastName;
        if(eBook.containsKey(key)){
            return eBook.get(key);
        } else {
            throw new RuntimeException("Employee with such name, middle name and second name is not " +
                    "found in the employee book");
        }
    }

    public List<Employee> list(){
        return eBook.keySet().stream()
                .map(s -> eBook.get(s))
                .collect(Collectors.toList());

    }

    public Map<String, Set<Employee>> listOfDepartment(int department){
        Map<Integer, Set<Employee>> map =  eBook.keySet().stream()
                .filter(s -> eBook.get(s).getDepartment() == department)
                .map(s -> eBook.get(s))
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toSet()));
        return map.keySet().stream()
                .collect(Collectors.toMap(s -> EmployeeServiceImpl.dBook.findName(s), map::get));
    }

    public Employee findEmployeeWithMaxSalary(int department) {

        String key = eBook.keySet().stream()
                        .filter(s -> eBook.get(s).getDepartment() == department)
                        .max(Comparator.comparingDouble(s -> eBook.get(s).getSalary()))
                        .orElseThrow(() -> new RuntimeException("Wrong department number in the " +
                                "findEmployeeWithMaxSalary method"));
        return eBook.get(key);

    }

    public Employee findEmployeeWithMinSalary(int department) {

        String key = eBook.keySet().stream()
                .filter(s -> eBook.get(s).getDepartment() == department)
                .min(Comparator.comparingDouble(s -> eBook.get(s).getSalary()))
                .orElseThrow(() -> new RuntimeException("Wrong department number in the " +
                        "findEmployeeWithMaxSalary method"));
        return eBook.get(key);

    }

    public Map<String, Set<Employee>> allDepartmentsEmployeeList(){
        Map<Integer, Set<Employee>> map = eBook.keySet().stream()
                .map(s -> eBook.get(s))
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toSet()));
        return map.keySet().stream()
                .collect(Collectors.toMap(s -> EmployeeServiceImpl.dBook.findName(s), map::get));
    }

}
