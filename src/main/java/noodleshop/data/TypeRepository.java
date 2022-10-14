package noodleshop.data;

import noodleshop.ItemType;
import org.springframework.data.repository.CrudRepository;

public interface TypeRepository extends CrudRepository<ItemType, Long> {}
