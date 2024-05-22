package lk.ijse.shoeshopmanagementbackend.service;

import lk.ijse.shoeshopmanagementbackend.dto.BranchDTO;
import lk.ijse.shoeshopmanagementbackend.exception.InvalidException;

public interface BranchService {
    void saveBranch(BranchDTO branchDTO) throws InvalidException;
}
