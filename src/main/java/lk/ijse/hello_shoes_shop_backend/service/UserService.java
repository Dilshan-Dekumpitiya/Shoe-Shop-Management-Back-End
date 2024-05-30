package lk.ijse.hello_shoes_shop_backend.service;


import lk.ijse.hello_shoes_shop_backend.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {

    UserDetailsService userDetailsService();
    void saveUser(UserDto userDTO);
}
