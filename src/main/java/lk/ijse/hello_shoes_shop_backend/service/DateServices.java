package lk.ijse.hello_shoes_shop_backend.service;

import java.time.LocalDate;
import java.util.Date;

public interface DateServices {
    LocalDate orderLastReturnDay(Date orderPurchaseDate);
}
