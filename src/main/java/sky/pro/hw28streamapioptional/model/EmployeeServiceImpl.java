package sky.pro.hw28streamapioptional.model;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    public static DepartmentBook dBook;
    private EmployeeBook eBook;

    public EmployeeServiceImpl(){

        dBook = new DepartmentBook();
        eBook = new EmployeeBook();

        dBook.add("Отдел кадров");
        dBook.add("Бухгалтерия");
        dBook.add("Финансовый отдел");
        dBook.add("Производственный отдел");
        dBook.add("Отдел логистики");
        dBook.add("Отдел закупок");
        dBook.add("Маркетинговый отдел");
        dBook.add("Отдел продаж");

        eBook.add(new Employee("Иван", "Иванович", "Иванов", 0, 50_000));
        eBook.add(new Employee("Петр", "Иннокентьевич", "Петров", 0, 150_000));
        eBook.add(new Employee("Семен", "Семенович", "Горбунков", 1, 101_000));
        eBook.add(new Employee("Иннокентий", "Борисович", "Чулков", 1, 120_000));
        eBook.add(new Employee("Сергей", "Ануфриевич", "Ябеда", 2, 40_000));
        eBook.add(new Employee("Иосиф", "Вахтангович", "Гришин", 2, 91_000));
        eBook.add(new Employee("Иван", "Иванович", "Иванов", 3, 50_000));
        eBook.add(new Employee("Алибек", "Джунгарович", "Хомяков", 3, 42_000));
        eBook.add(new Employee("Рустам", "Ибрагимович", "Сулейбеков", 4, 22_000));
        eBook.add(new Employee("Зухра", "Петровна", "Джугашвилли", 4, 173_000));
        eBook.add(new Employee("Казбек", "Дмитриевич", "Светлый", 5, 17_500));
        eBook.add(new Employee("Сулейман", "Мыколович", "Беспамятный", 5, 23_700));
        eBook.add(new Employee("Михайло", "Дмитриевич", "Главко", 6, 110_300));
        eBook.add(new Employee("Елена", "Арменовна", "Акопян", 6, 199_999.99));
        eBook.add(new Employee("Гюльчатай", "Зурабовна", "Сухова", 7, 69_000));
        eBook.add(new Employee("Наталья", "Альбертовна", "Рабинович", 7, 29_794));

    }


    @Override
    public Employee addEmployee(String firstName, String middleName, String lastName, int department, double salary) {
        eBook.add(firstName, middleName, lastName, department, salary);
        return eBook.find(firstName, middleName, lastName);
    }

    @Override
    public Employee removeEmployee(String firstName, String middleName, String lastName) {
        return eBook.remove(firstName, middleName, lastName);
    }

    @Override
    public Employee findEmployee(String firstName, String middleName, String lastName) {
        return eBook.find(firstName, middleName, lastName);
    }

    @Override
    public Employee[] allEmployeeList() {
        return eBook.list();
    }

    @Override
    public Employee[] departmentEmployeeList(int department) {
        return eBook.listOfDepartment(department);
    }

    public Employee findEmployeeWithMaxSalary(int department){
        return eBook.findEmployeeWithMaxSalary(department);
    }

    @Override
    public Employee findEmployeeWithMinSalary(int department) {
        return eBook.findEmployeeWithMinSalary(department);
    }

    @Override
    public Employee[] allDepartmentsEmployeeList() {
        return eBook.allDepartmentsEmployeeList();
    }

}
