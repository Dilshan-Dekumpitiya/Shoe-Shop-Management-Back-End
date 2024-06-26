package lk.ijse.hello_shoes_shop_backend.repository;

import lk.ijse.hello_shoes_shop_backend.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepo extends JpaRepository<ItemEntity,String> {


    @Query(value = "SELECT itemCode FROM item ORDER BY itemCode DESC LIMIT 1", nativeQuery = true)
    String getLastItemId();

    @Query(value = "SELECT itemSize FROM size where itemId=?1" ,nativeQuery = true )
   List<String> selectItemHasAllSizesGet(String itemId);



}
