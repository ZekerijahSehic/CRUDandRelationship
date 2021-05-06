package oneToOneBi;

import oneToOneBi.Teacher;
import oneToOneBi.TeacherDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Demo {
    public static void main(String args[]) {

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Teacher.class)
                .addAnnotatedClass(TeacherDetail.class).buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();

            int theId = 4;
            TeacherDetail teacherDetail = session.get(TeacherDetail.class, theId);

            System.out.println("Teacher details:" + teacherDetail);
            System.out.println("This informations are about:" + teacherDetail.getTeacher());

            session.getTransaction().commit();

        } catch (Exception exception){

            exception.printStackTrace();

        } finally {

            session.close();
            sessionFactory.close();

        }


    }
}
