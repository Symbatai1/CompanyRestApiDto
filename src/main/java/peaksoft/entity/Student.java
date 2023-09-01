package peaksoft.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.enums.StudyFormat;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor



public class Student {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "student_gen")
    @SequenceGenerator(name = "student_gen",
            sequenceName = "student_seq",
            allocationSize = 1)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_namber")
    private String phoneNumber;
    private String email;
    @Enumerated(EnumType.STRING)
    private StudyFormat studyFormat;
    private Boolean isBlocked;

    @ManyToOne(cascade={DETACH, MERGE,PERSIST, REFRESH})
    private Group groups;

}

