package lk.ijse.hello_shoes_shop_backend.service;

import lk.ijse.hello_shoes_shop_backend.dto.SupplierDto;

import java.util.List;

public interface SupplierService {

    List<SupplierDto> getAllSuppliers();
    void saveSupplier(SupplierDto supplierDto);
    SupplierDto searchSupplier(String searchSupplierId);
    String updateSupplier(String updateSupplierId, SupplierDto supplierDto);
    String deleteSupplier(String deleteSupplierId);

}
