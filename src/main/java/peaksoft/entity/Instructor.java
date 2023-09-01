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
@Table(name = "instructors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Instructor {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "instructor_gen")
    @SequenceGenerator(name = "instructor_gen",
            sequenceName = "instructor_seq",
            allocationSize = 1)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String specialization;
    @ManyToMany(cascade ={DETACH, MERGE, PERSIST, REFRESH})
    private List<Company> companies=new ArrayList<>();
    @OneToMany(mappedBy = "instructors",cascade = CascadeType.ALL)
    private List<Course>courses=new ArrayList<>();
    public void addCompany(Company company) {
        this.companies.add(company);
    }

    public void addCourse(Course course) {
        this.courses.add(course);

    }
}
