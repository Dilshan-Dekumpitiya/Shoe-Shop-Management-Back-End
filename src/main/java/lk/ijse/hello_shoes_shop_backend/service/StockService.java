package lk.ijse.hello_shoes_shop_backend.service;

import lk.ijse.hello_shoes_shop_backend.entity.StockEntity;

import java.util.List;

public interface StockService {
    List<StockEntity> getAllStock();
    List<String> checkItemQtySendInfo();

}
