package lk.ijse.hello_shoes_shop_backend.api;

import lk.ijse.hello_shoes_shop_backend.dto.SupplierDto;
import lk.ijse.hello_shoes_shop_backend.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:63342")
public class SupplierController {

    @Autowired
    SupplierService supplierService;


    @GetMapping
    @RequestMapping("/getAllSuppliers")
    public List<SupplierDto> getAllSuppliers(){
        List<SupplierDto> allSuppliers = supplierService.getAllSuppliers();
        return allSuppliers;
    }

    @PostMapping
    @RequestMapping("/save")
    public void saveSupplier(@RequestBody SupplierDto supplierDto){
        supplierService.saveSupplier(supplierDto);
    }

    @GetMapping
    @RequestMapping("/search/{id}")
    public SupplierDto searchSupplier(@PathVariable ("id") String searchSupplierId){
        SupplierDto searchSupplierDto = supplierService.searchSupplier(searchSupplierId);
        return searchSupplierDto;
    }

    @PutMapping
    @RequestMapping("/update/{id}")
    public String updateSupplier(@PathVariable("id") String updateSupplierId , @RequestBody SupplierDto supplierDto){
        String updateSupplier = supplierService.updateSupplier(updateSupplierId, supplierDto);
        return updateSupplier;
    }

    @DeleteMapping
    @RequestMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteSupplier(@PathVariable ("id") String deleteSupplierId){
        String deleteSupplier = supplierService.deleteSupplier(deleteSupplierId);
        return deleteSupplier;
    }



}
