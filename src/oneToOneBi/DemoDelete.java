package oneToOneBi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DemoDelete {
    public static void main(String args[]) {

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Teacher.class)
                .addAnnotatedClass(TeacherDetail.class).buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();

            int theId = 2;
            TeacherDetail teacherDetail = session.get(TeacherDetail.class, theId);

            teacherDetail.getTeacher().setTeacherDetail(null);

            session.delete(teacherDetail);

            session.getTransaction().commit();

        } catch (Exception exception){

            exception.printStackTrace();

        } finally {

            session.close();
            sessionFactory.close();

        }


    }
}
