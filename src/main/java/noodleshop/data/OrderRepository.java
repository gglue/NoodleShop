package noodleshop.data;

import noodleshop.ManualOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<ManualOrder, Long>{
}
