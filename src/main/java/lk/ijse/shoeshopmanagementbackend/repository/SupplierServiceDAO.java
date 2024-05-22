package lk.ijse.shoeshopmanagementbackend.repository;

import lk.ijse.shoeshopmanagementbackend.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierServiceDAO extends JpaRepository<SupplierEntity,String> {
    SupplierEntity findFirstByOrderBySupplierCode();
}
