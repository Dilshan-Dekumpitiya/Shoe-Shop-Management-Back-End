package lk.ijse.shoeshopmanagementbackend.repository;

import lk.ijse.shoeshopmanagementbackend.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerServiceDAO extends JpaRepository<CustomerEntity,String> {
    CustomerEntity findFirstByOrderByCustomerIdDesc();
}
