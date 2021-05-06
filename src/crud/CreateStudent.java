package crud;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudent {
    public static void main(String args[]){

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {

            System.out.println("Create studnet");
            Student student = new Student("jane", "doe", "jane.doe@java.com");

            session.beginTransaction();

            System.out.println("Saving the student");
            session.save(student);

            session.getTransaction().commit();

            System.out.println("Success! ");

        } finally {

            sessionFactory.close();

        }
    }

}
