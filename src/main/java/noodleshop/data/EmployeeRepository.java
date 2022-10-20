package noodleshop.data;

import noodleshop.EmployeeUser;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<EmployeeUser, Long> {
    EmployeeUser findByUsername(String username);
}