package lk.ijse.shoeshopmanagementbackend.service.impl;

import lk.ijse.shoeshopmanagementbackend.conversion.ConversionData;
import lk.ijse.shoeshopmanagementbackend.dto.BranchDTO;
import lk.ijse.shoeshopmanagementbackend.exception.InvalidException;
import lk.ijse.shoeshopmanagementbackend.repository.BranchServiceDAO;
import lk.ijse.shoeshopmanagementbackend.service.BranchService;
import lk.ijse.shoeshopmanagementbackend.util.UtilMatters;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {

    final private ConversionData conversionData;

    final private BranchServiceDAO branchServiceDao;
    @Override
    public void saveBranch(BranchDTO branchDTO){
        if (!branchDTO.getProductCode().equals(UtilMatters.productActivationCode())) throw new InvalidException("Invalid Product Code");
        branchDTO.setBranchId(UtilMatters.generateId());
        branchServiceDao.save(conversionData.toBranchEntity(branchDTO));
    }
}
