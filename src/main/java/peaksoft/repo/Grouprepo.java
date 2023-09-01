package peaksoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.entity.Group;

public interface Grouprepo extends JpaRepository<Group,Long> {
}
