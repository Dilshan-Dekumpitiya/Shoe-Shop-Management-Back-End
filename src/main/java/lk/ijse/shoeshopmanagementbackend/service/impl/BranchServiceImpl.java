package lk.ijse.shoeshopmanagementbackend.service.impl;

import lk.ijse.shoeshopmanagementbackend.conversion.ConversionData;
import lk.ijse.shoeshopmanagementbackend.service.BranchService;
import lk.ijse.shoeshopmanagementbackend.util.UtilMatters;

public class BranchServiceImpl implements BranchService {
    final private ConversionData conversionData;

    final private BranchServiceDao branchServiceDao;
    @Override
    public void saveBranch(BranchDTO branchDTO){
        if (!branchDTO.getProductCode().equals(UtilMatters.productActivationCode())) throw new InvalidException("Invalid Product Code");
        branchDTO.setBranchId(UtilMatters.generateId());
        branchServiceDao.save(conversionData.toBranchEntity(branchDTO));
    }
}
