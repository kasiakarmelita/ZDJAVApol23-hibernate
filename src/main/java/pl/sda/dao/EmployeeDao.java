package pl.sda.dao;

import org.hibernate.Session;
import pl.sda.database.SessionProvider;
import pl.sda.model.Department;
import pl.sda.model.Employee;

import java.util.List;

public class EmployeeDao extends AbstractDao<Employee> {

    public EmployeeDao() {
        super(Employee.class);
    }

    public List<Employee> findByFirstName(String firstName) {
        Session session = SessionProvider.getSession();
        List<Employee> records = session.createQuery("from Employee where firstName = :firstName", Employee.class)
                .setParameter("firstName", firstName)
                .list();
        session.close();
        return records;
    }

    public List<Employee> findByLastName(String lastName) {
        Session session = SessionProvider.getSession();
        List<Employee> records = session.createQuery("from Employee where lastName = :lastName", Employee.class)
                .setParameter("lastName", lastName)
                .list();
        session.close();
        return records;
    }

    public List<Employee> findByLastNameAndFistrName(String lastName, String firstName) {
        Session session = SessionProvider.getSession();
        List<Employee> records = session.createQuery("from Employee where lastName = :lastName & firstName = :firstName", Employee.class)
                .setParameter("lastName", lastName)
                .setParameter("firstName", firstName)
                .list();
        session.close();
        return records;
    }

    public List<Employee> findAllByDepartmentId (int departmentId){
        Session session = SessionProvider.getSession();
        List <Employee> list = session.createQuery("from Employee where department.id=: departmentId" ,Employee.class)
                .setParameter("departmentId",departmentId)
                .list();
        session.close();
        return list;
    }
}

