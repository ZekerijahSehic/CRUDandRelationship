package manyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Demo {
    public static void main(String args[]){

        SessionFactory sessionFactory = new Configuration().configure()
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();

            Course course = new Course("Hibernate Mapping");

            session.save(course);

            Student student1 = new Student("Neo", "Lee", "neo@java.com");
            Student student2 = new Student("Marry", "Lee", "ana@java.com");

            course.addStudent(student1);
            course.addStudent(student2);

            session.save(student1);
            session.save(student2);

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
            session.close();
        }
    }
}
