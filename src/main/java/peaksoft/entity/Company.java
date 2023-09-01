package peaksoft.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.GenerationType.SEQUENCE;
@Entity
@Table(name="companies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Company {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "company_gen")
    @SequenceGenerator(name = "company_gen",
            sequenceName = "company_seq",
            allocationSize = 1)
    private Long id;
    @Column(unique = true)
    private String name;
    private String country;
    private String address;
    private String phoneNumber;
    @ManyToMany(mappedBy = "companies",cascade = {DETACH, PERSIST, REFRESH, MERGE})
    private List<Instructor> instructors;
    @OneToMany(mappedBy = "companies", cascade = {DETACH, MERGE, PERSIST, REFRESH})
    private List<Course>courses=new ArrayList<>();


    public void addInstructor(Instructor instructor) {
        this.instructors.add(instructor);
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }


}
