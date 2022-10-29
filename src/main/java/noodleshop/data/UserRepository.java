package noodleshop.data;

import noodleshop.NoodleUser;
import org.springframework.data.repository.CrudRepository;
public interface UserRepository extends CrudRepository<NoodleUser, Long> {

    NoodleUser findByUsername(String username);
}