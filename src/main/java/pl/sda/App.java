package pl.sda;

import pl.sda.dao.DepartmentDao;
import pl.sda.dao.EmployeeDao;
import pl.sda.model.Department;
import pl.sda.model.Employee;

public class App {
    public static void main( String[] args ) {
        DepartmentDao departmentDao = new DepartmentDao();
        EmployeeDao employeeDao = new EmployeeDao();

        Department itDepartment = new Department("IT");
        Department testDepartment = new Department("TEST");
        departmentDao.add(itDepartment);
        departmentDao.add(testDepartment);

        departmentDao.findAll().forEach(department -> System.out.println(department.toString()));

        Employee cezary = new Employee("Cezary", "Nowak", departmentDao.findById(1));
        Employee arkadiusz = new Employee("Arkadiusz", "Kowalski", departmentDao.findById(2));

        employeeDao.add(cezary);
        employeeDao.add(arkadiusz);

        employeeDao.findAll().forEach(employee -> System.out.println(employee.toString()));

        Employee cezaryFromDatabase = employeeDao.findById(1);
        cezaryFromDatabase.setFirstName("Maciej");

        employeeDao.update(cezaryFromDatabase);
        employeeDao.findAll().forEach(employee -> System.out.println(employee.toString()));
    }
}
