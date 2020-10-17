package pl.sda.dao;

import org.hibernate.Session;
import pl.sda.database.SessionProvider;
import pl.sda.model.Classroom;
import pl.sda.model.Department;

import java.util.List;

public class ClassroomDao extends AbstractDao <Classroom> {

    public ClassroomDao() {
        super(Classroom.class);
    }

    public List<Classroom> findByNumber(int number) {
        Session session = SessionProvider.getSession();
        List <Classroom> records = session.createQuery("from Classroom where classNumber = :number", Classroom.class)
                .setParameter("number", number)
                .list();
        session.close();
        return records;
    }

}
