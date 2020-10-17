package pl.sda.dao;

import org.hibernate.Session;
import pl.sda.database.SessionProvider;
import pl.sda.model.Department;

import java.util.List;

public class DepartmentDao extends AbstractDao<Department> {



    public DepartmentDao() {
        super(Department.class);
    }

    public List<Department> findByName(String name) {
        Session session = SessionProvider.getSession();
        List <Department> records = session.createQuery("from Department where name = :name", Department.class)
                .setParameter("name", name)
                .list();
        session.close();
        return records;
    }
}
