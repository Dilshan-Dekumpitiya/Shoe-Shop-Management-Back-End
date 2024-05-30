package lk.ijse.hello_shoes_shop_backend.service;

import lk.ijse.hello_shoes_shop_backend.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> getAllCustomers();
    void saveCustomer(CustomerDto customerDto);
    CustomerDto searchCustomer(String searchCustomerId);
    String updateCustomer(String updateCustomerId, CustomerDto updateCustomerDetailsDto);
    String deleteCustomer(String deleteCustomerId);

}
