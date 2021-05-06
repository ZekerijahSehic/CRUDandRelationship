package crud;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudent {

    public static void main (String args[]){

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();

            List<Student> studentsList = session.createQuery("from Student").list();

            System.out.println("Students :");

            displayStudents(studentsList);

            studentsList = session.createQuery("from Student student where student.lastName='doe'").getResultList();

            System.out.println("Students with last name 'Doe' :");
            displayStudents(studentsList);

            session.getTransaction().commit();

        } finally {

            sessionFactory.close();

        }
    }

    private static void displayStudents(List<Student> studentsList) {
        for (Student student : studentsList) {
            System.out.println(student);
        }
    }
}
