package oneToManyBi;

import oneToManyBi.TeacherDetail;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_detail_id")
    private TeacherDetail teacherDetail;

    @OneToMany(mappedBy = "teacher", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Course> courses;




    public Teacher() {
    }

    public Teacher(String firstName, String last_name, String email) {
        this.firstName = firstName;
        this.last_name = last_name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TeacherDetail getTeacherDetail() {
        return teacherDetail;
    }

    public void setTeacherDetail(TeacherDetail teacherDetail) {
        this.teacherDetail = teacherDetail;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void add(Course course){
        if(courses == null) {
            courses = new ArrayList<>();
        }
        courses.add(course);
        course.setTeacher(this);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "firstName='" + firstName + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", teacherDetail=" + teacherDetail +
                '}';
    }
}
