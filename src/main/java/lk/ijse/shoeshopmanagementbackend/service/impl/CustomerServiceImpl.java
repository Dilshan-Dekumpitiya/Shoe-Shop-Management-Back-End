package lk.ijse.shoeshopmanagementbackend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.shoeshopmanagementbackend.dto.CustomerDTO;
import lk.ijse.shoeshopmanagementbackend.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    @Override
    public void saveCustomer(CustomerDTO customerDTO) {

    }

    @Override
    public CustomerDTO getCustomer(String id) {
        return null;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return null;
    }

    @Override
    public void deleteCustomer(String id) {

    }

    @Override
    public void updateCustomer(String id, CustomerDTO customerDTO) {

    }
}
