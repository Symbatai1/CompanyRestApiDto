package peaksoft.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CacheStoreMode.REFRESH;
import static jakarta.persistence.CascadeType.DETACH;
import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.GenerationType.SEQUENCE;
import static javax.swing.JFormattedTextField.PERSIST;

@Entity
@Table(name="groups")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Group {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "group_gen")
    @SequenceGenerator(name = "group_gen",
            sequenceName = "group_seq",
            allocationSize = 1)
    private Long id;
    @Column(name="group_name")
    private String groupName;
    @Column(name="image_link")
    private String imageLink;
    private String  description;

    @ManyToMany(mappedBy = "groups",cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    private List<Course>courses=new ArrayList<>();

    @OneToMany(mappedBy = "groups",cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    private List<Student>students=new ArrayList<>();
    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

}
