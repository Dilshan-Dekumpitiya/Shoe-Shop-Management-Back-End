package lk.ijse.hello_shoes_shop_backend.api;

import lk.ijse.hello_shoes_shop_backend.dto.OrderDto;
import lk.ijse.hello_shoes_shop_backend.dto.ReturnDto;
import lk.ijse.hello_shoes_shop_backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:63342")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    @RequestMapping("/save")
    public void saveOrder(@RequestBody OrderDto orderDto){
        System.out.println(orderDto);
        orderService.saveOrder(orderDto);
    }

    @PostMapping
    @RequestMapping("/return")
    public String returnOrder(@RequestBody ReturnDto returnDto){
        String massage = orderService.returnOrder(returnDto);
        return massage;
    }


    @GetMapping
    @RequestMapping("/newOrderId")
    public String nextOrderIdGet(){
        return orderService.getLastOrderId();
    }

    @GetMapping
    @RequestMapping("/getAllOrders")
    @PreAuthorize("hasRole('ADMIN')")
    public List<OrderDto> getAllOrders(){
        List<OrderDto> allOrders = orderService.getAllOrders();
        return allOrders;
    }

    @GetMapping
    @RequestMapping("/returnNextId")
    public String getReturnOrderIdNext(){
        String nextReturnId = orderService.getNextReturnId();
        return nextReturnId;
    }

    @GetMapping
    @RequestMapping("/searchOrder/{id}")
    public OrderDto searchOrder(@PathVariable ("id") String searchOrderId){
        OrderDto orderDto = orderService.searchOrder(searchOrderId);
        return orderDto;
    }

    @GetMapping
    @RequestMapping("/getTotalSale/{date}")
    public Double  getTotal(@PathVariable ("date") String date){
        Double totalSaleSelectDate = orderService.totalSaleGet(date);
        return totalSaleSelectDate;
    }

    @GetMapping
    @RequestMapping("/branchWiseOrderDetailsGet/{branch}")
    @PreAuthorize("hasRole('ADMIN')")
    public List<OrderDto> branchWiseOrderDetailsGet(@PathVariable ("branch") String branch){
        List<OrderDto> orderDtos = orderService.branchWiseOrderDetailsGet(branch);
        return orderDtos;
    }

    @GetMapping
    @RequestMapping("/employeeSaleOrders/{mail}")
    @PreAuthorize("hasRole('USER')")
    public List<OrderDto> employeeSaleAllOrdersGet(@PathVariable ("mail") String empMail) {
        List<OrderDto> employeeSaleOrders = orderService.employeeSaleAllOrdersGet(empMail);
        return employeeSaleOrders;
    }

    //TODO
//    @GetMapping
//    @RequestMapping("/saleMostItem")
//    public String getMostSaleItemImg(@RequestParam("date") String date) {
////        String mostSaleItemGet = orderService.mostSaleItemGet();
//        return mostSaleItemGet;
//    }
}
