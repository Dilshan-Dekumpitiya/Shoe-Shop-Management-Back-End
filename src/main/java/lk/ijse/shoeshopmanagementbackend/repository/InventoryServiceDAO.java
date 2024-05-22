package lk.ijse.shoeshopmanagementbackend.repository;

import lk.ijse.shoeshopmanagementbackend.entity.GenderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryServiceDAO extends JpaRepository<GenderEntity,String> {
}

