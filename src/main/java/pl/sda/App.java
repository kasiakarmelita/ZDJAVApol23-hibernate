package pl.sda;

import pl.sda.dao.ClassroomDao;
import pl.sda.dao.DepartmentDao;
import pl.sda.dao.EmployeeDao;
import pl.sda.model.Adress;
import pl.sda.model.Classroom;
import pl.sda.model.Department;
import pl.sda.model.Employee;

public class App {
    public static void main(String[] args) {
        DepartmentDao departmentDao = new DepartmentDao();
        EmployeeDao employeeDao = new EmployeeDao();
        ClassroomDao classroomDao = new ClassroomDao();

        Classroom classroomNumber1 = new Classroom(1, departmentDao.findById(1));
        classroomDao.add(classroomNumber1);

        Classroom classroomNumber2 = new Classroom(2, departmentDao.findById(2));
        classroomDao.add(classroomNumber2);

        Classroom classroomNumber3 = new Classroom(3, departmentDao.findById(2));
        classroomDao.add(classroomNumber3);

        Department itDepartment = new Department("IT");
        Department testDepartment = new Department("TEST");
        departmentDao.add(itDepartment);
        departmentDao.add(testDepartment);

        departmentDao.findAll().forEach(department -> System.out.println(department.toString()));

        Adress adressKasia = new Adress("Nowa", 60, "Wrocław", "53-239");
        Employee kasia = new Employee("Katarzyna", "Karmelita", departmentDao.findById(1), adressKasia);
//        Employee arkadiusz = new Employee("Arkadiusz", "Kowalski", departmentDao.findById(2));

        employeeDao.add(kasia);
//        employeeDao.add(arkadiusz);

        employeeDao.findAll().forEach(employee -> System.out.println(employee.toString()));

        Employee cezaryFromDatabase = employeeDao.findById(1);
        cezaryFromDatabase.setFirstName("Maciej");

        employeeDao.update(cezaryFromDatabase);
        employeeDao.findAll().forEach(employee -> System.out.println(employee.toString()));

        System.out.println(departmentDao.findByName("IT"));

        employeeDao.findByLastName("Nowak").forEach(employee -> System.out.println(employee.toString()));

        System.out.println(employeeDao.findByFirstName("Katarzyna"));

        System.out.println(classroomDao.findByNumber(1));

        employeeDao.findByLastNameAndFistrName("Kowalski", "Arkadiusz").forEach(employee -> System.out.println(employee.toString()));

        System.out.println(employeeDao.findAllByDepartmentId(2));

        employeeDao.findAllByDepartmentId(2).forEach(employee -> System.out.println(employee.toString()));

    }
}
