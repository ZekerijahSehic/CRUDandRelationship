package oneToOneBi;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "teacher_detail")
public class TeacherDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "subject")
    private String subject;

    @Column(name = "age")
    private int age;

    @OneToOne(mappedBy = "teacherDetail",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Teacher teacher;

    public TeacherDetail() {

    }

    public TeacherDetail(String subject, int age) {
        this.subject = subject;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "TeacherDetail{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", age=" + age +
                '}';
    }
}
