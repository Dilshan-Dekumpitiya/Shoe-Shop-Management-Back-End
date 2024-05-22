package lk.ijse.shoeshopmanagementbackend.conversion;

import lk.ijse.shoeshopmanagementbackend.dto.*;
import lk.ijse.shoeshopmanagementbackend.entity.*;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class ConversionData {
    final private ModelMapper modelMapper;

    public CustomerDTO convertToCustomerDTO(Optional<CustomerEntity> customerEntity){
        return modelMapper.map(customerEntity, CustomerDTO.class);
    }

    public CustomerEntity convertToCustomerEntity(Optional<CustomerDTO> customerDTO){
        return modelMapper.map(customerDTO, CustomerEntity.class);
    }

    public List<CustomerDTO> getCustomerDTOList(List<CustomerEntity> customerEntities){
        return modelMapper.map(customerEntities,List.class);
    }

    public List<CustomerEntity> getCustomerEntityList(List<CustomerEntity> customerDtos){
        return modelMapper.map(customerDtos,List.class);
    }

    public UserEntity toUserEntity(UserDTO userDTO){
        return modelMapper.map(userDTO, UserEntity.class);
    }

    public BranchEntity toBranchEntity(BranchDTO branchDTO) {
        return modelMapper.map(branchDTO, BranchEntity.class);
    }

    public EmployeeEntity toEmployeeEntity(EmployeeDTO employeeDTO){
        return modelMapper.map(employeeDTO, EmployeeEntity.class);
    }

    public EmployeeDTO toEmployeeDTO(Optional<EmployeeEntity> employeeEntity){
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    public List<EmployeeDTO> toEmployeeDTOList(List<EmployeeEntity> employeeEntities) {
        return modelMapper.map(employeeEntities,List.class);
    }

    public GenderEntity toGenderEntity(GenderDTO genderDTO) {
        return modelMapper.map(genderDTO, GenderEntity.class);
    }

    public GenderDTO toGenderDTO(GenderEntity genderEntity){
        return modelMapper.map(genderEntity, GenderDTO.class);
    }

    public List<GenderDTO> convertToGenderDTO(List<GenderEntity> genderEntities) {
        return modelMapper.map(genderEntities,List.class);
    }

}
