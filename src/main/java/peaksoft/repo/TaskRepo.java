package peaksoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.entity.Task;

public interface TaskRepo extends JpaRepository<Task,Long> {
}
