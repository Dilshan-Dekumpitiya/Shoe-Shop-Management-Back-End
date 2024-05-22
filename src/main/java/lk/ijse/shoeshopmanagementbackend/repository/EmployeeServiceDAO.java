package lk.ijse.shoeshopmanagementbackend.repository;

import lk.ijse.shoeshopmanagementbackend.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeServiceDAO extends JpaRepository<EmployeeEntity,String> {
    EmployeeEntity findFirstByOrderByEmployeeCodeDesc();
}