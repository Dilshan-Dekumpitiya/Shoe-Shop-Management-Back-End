package lk.ijse.shoeshopmanagementbackend.service;

import lk.ijse.shoeshopmanagementbackend.dto.CustomerDTO;
import lk.ijse.shoeshopmanagementbackend.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);

    CustomerDTO getCustomer(String id);

    List<CustomerDTO> getAllCustomers();

    void deleteCustomer(String id);

    void updateCustomer(String id,CustomerDTO customerDTO);
}
