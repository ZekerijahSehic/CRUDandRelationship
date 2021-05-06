package oneToManyBi;

import oneToManyBi.Teacher;
import oneToManyBi.TeacherDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Demo {
    public static void main(String args[]) {

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Teacher.class)
                .addAnnotatedClass(TeacherDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();

            int theId = 2;
            Teacher teacher = session.get(Teacher.class, theId);

            Course course1 = new Course("Web Developent");
            Course course2 = new Course("Databases");

            teacher.add(course1);
            teacher.add(course2);

            session.save(course1);
            session.save(course2);

            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();

        }


    }
}
