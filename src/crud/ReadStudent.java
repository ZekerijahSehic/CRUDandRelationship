package crud;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudent {
    public static void main (String args[]){

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {

            Student tempStudent = new Student("joe", "malk", "joe@java.com");

            session.beginTransaction();

            session.save(tempStudent);

            session.getTransaction().commit();

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Student readStudent = session.get(Student.class, tempStudent.getId());

            System.out.println("We read student from db: " + tempStudent);

            session.getTransaction().commit();

        } finally {

            sessionFactory.close();

        }
    }
}
