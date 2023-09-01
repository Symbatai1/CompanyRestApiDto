package peaksoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.entity.Course;

public interface CourseRepo extends JpaRepository<Course, Long> {
}
