package oneToOneUni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Demo {
    public static void main(String args[]) {

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Teacher.class)
                .addAnnotatedClass(TeacherDetail.class).buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {

            Teacher teacher = new Teacher("Jane", "Doe", "joe@teacher.com");
            TeacherDetail teacherDetail = new TeacherDetail("Math", 35);

            teacher.setTeacherDetail(teacherDetail);

            session.beginTransaction();
            session.save(teacher);
            session.getTransaction().commit();

        } finally {

            sessionFactory.close();

        }


    }
}
