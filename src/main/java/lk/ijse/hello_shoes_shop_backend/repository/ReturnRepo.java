package lk.ijse.hello_shoes_shop_backend.repository;

import lk.ijse.hello_shoes_shop_backend.entity.ReturnEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnRepo extends JpaRepository<ReturnEntity,String> {
}
