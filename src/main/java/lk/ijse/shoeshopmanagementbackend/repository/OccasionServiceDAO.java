package lk.ijse.shoeshopmanagementbackend.repository;

import lk.ijse.shoeshopmanagementbackend.entity.OccasionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OccasionServiceDAO extends JpaRepository<OccasionEntity,String> {
}

