package peaksoft.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "lessons")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Lesson {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "lesson_gen")
    @SequenceGenerator(name = "lesson_gen",
            sequenceName = "lesson_seq",
            allocationSize = 1)

    private Long id;
    private String name;
    @OneToMany(mappedBy = "lessons",cascade = {DETACH, MERGE, PERSIST, REFRESH})
    private List<Task>tasks;
    @ManyToOne(cascade = {DETACH, MERGE, PERSIST, REFRESH})
    private Course courses;

    public void addTask(Task task) {
        this.tasks.add(task);
    }

}
