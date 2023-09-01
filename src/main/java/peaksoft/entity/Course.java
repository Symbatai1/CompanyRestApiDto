package peaksoft.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Course {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "course_gen")
    @SequenceGenerator(name = "course_gen",
            sequenceName = "course_seq",
            allocationSize = 1)
    private Long id;

    private String name;
    private ZonedDateTime dateOfStart;
    private String  description;
    @ManyToMany
    private List<Group> groups;
    @OneToMany(mappedBy = "courses",cascade = {DETACH,MERGE, PERSIST, REFRESH})
    private List<Lesson>lessons=new ArrayList<>();
    @ManyToOne(cascade = {DETACH, PERSIST, REFRESH, MERGE,REMOVE})
    private Instructor instructors;
    @ManyToOne(cascade = {DETACH, PERSIST, REFRESH, MERGE})
    private Company companies;

    public void addLesson(Lesson lesson) {
        this.lessons.add(lesson);
    }

    public void addGroup(Group group) {
        this.groups.add(group);
    }

}
