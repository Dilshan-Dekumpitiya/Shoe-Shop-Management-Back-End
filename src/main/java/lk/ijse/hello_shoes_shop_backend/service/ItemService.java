package lk.ijse.hello_shoes_shop_backend.service;

import lk.ijse.hello_shoes_shop_backend.dto.ItemDto;

import java.util.List;

public interface ItemService {
    List<ItemDto> getAllItems();
    void saveItem(String itemSupplierId,ItemDto itemDto,String size,String qty);
    void updateItem(String updateItemId , ItemDto itemDto,String supplierId);
    void deleteItem(String deleteItemId);

    ItemDto searchItem(String searchItemId);

    String getLastItemId();

    List<String> selectItemHasAllSizesGet(String selectItemId);

}
