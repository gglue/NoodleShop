package noodleshop.data;

import noodleshop.ManualOrder;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderRepository extends PagingAndSortingRepository<ManualOrder, Long> {
}
