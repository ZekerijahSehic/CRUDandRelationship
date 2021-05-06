package crud;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudent {
    public static void main(String args[]){

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {

            int studentId = 2;

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Student student = session.get(Student.class, studentId);

            student.setLastName("phil");

            session.getTransaction().commit();

        } finally {

            sessionFactory.close();

        }
    }
}
