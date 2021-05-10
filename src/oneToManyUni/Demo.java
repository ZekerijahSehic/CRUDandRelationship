package oneToManyUni;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Demo {
    public static void main(String args[]){

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Teacher.class)
                .addAnnotatedClass(TeacherDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();

            int theId = 10;
            Course course = session.get(Course.class, theId);

            course.addReview(new Review("I love this course"));
            course.addReview(new Review("Excelent"));
            course.addReview(new Review("Not great not terible"));

            session.save(course);

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
            session.close();
        }
    }
}
