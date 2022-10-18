package noodleshop.data;

import noodleshop.CustomItem;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface CustomItemRepository extends CrudRepository<CustomItem, Long> {

    /**
    @Transactional
    @Query(value="SELECT SUM(PRICE) AS TOTAL_PRICE FROM\n" +
            "(SELECT distinct CUSTOM_ITEM.ID , ITEM.PRICE FROM CUSTOM_ITEM\n" +
            "INNER JOIN\n" +
            "ITEM ON CUSTOM_ITEM.ITEM_ID = ITEM.ID\n" +
            "UNION\n" +
            "SELECT CUSTOM_ITEM_ID as ID, SUM(PRICE) as PRICE\n" +
            "FROM CUSTOM_ITEM_EXTRAS\n" +
            "INNER JOIN EXTRA ON EXTRA.ID = CUSTOM_ITEM_EXTRAS.EXTRAS_ID\n" +
            "GROUP BY CUSTOM_ITEM_ID)\n" +
            "WHERE ID = ?1\n" +
            "GROUP BY ID", nativeQuery = true)
    public int evaluateTotalItemPrice(Long itemID);

    @Transactional
    @Modifying
    @Query(value="UPDATE CUSTOM_ITEM\n" +
            "SET TOTAL_PRICE = ?2\n" +
            "WHERE ID = ?1", nativeQuery = true)
    public void updateTotalItemPrice(Long itemID, int price);

    @Transactional
    @Query(value="SELECT SUM(TOTAL_PRICE) FROM CUSTOM_ITEM", nativeQuery = true)
    public int getSumOfItemPrices();
    **/

}
