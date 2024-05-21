package lk.ijse.shoeshopmanagementbackend.conversion;

import lk.ijse.shoeshopmanagementbackend.dto.CustomerDTO;
import lk.ijse.shoeshopmanagementbackend.entity.CustomerEntity;
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
}
