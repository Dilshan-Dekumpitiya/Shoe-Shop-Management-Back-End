package lk.ijse.hello_shoes_shop_backend.service;

import lk.ijse.hello_shoes_shop_backend.dto.OrderDto;
import lk.ijse.hello_shoes_shop_backend.dto.ReturnDto;

import java.util.List;

public interface OrderService {
    void saveOrder(OrderDto orderDto);
    String returnOrder(ReturnDto returnDto);

    String getLastOrderId();

    List<OrderDto> getAllOrders();

    String getNextReturnId();

    OrderDto searchOrder(String searchOrderId);

    Double totalSaleGet(String date);

    List<OrderDto> branchWiseOrderDetailsGet(String branch);

    List<OrderDto> employeeSaleAllOrdersGet(String empMail);

    //TODO
//    String mostSaleItemGet();


}
