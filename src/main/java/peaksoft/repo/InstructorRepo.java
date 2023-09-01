package peaksoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.entity.Instructor;

public interface InstructorRepo extends JpaRepository<Instructor,Long> {
}
