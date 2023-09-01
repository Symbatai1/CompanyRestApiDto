package peaksoft.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor



public class Task {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "task_gen")
    @SequenceGenerator(name = "task_gen",
            sequenceName = "task_seq",
            allocationSize = 1)
    private Long id;
    @Column(name = "task_name")
    private String taskName;
    private String deadLine;
    @ManyToOne(cascade = { DETACH, PERSIST, REFRESH, MERGE}, fetch = FetchType.EAGER)
    private  Lesson lessons;
}

