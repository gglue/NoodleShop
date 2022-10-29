package noodleshop.data;

import noodleshop.NoodleUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;

public interface UserRepository extends CrudRepository<NoodleUser, Long> {

    NoodleUser findByUsername(String username);
}