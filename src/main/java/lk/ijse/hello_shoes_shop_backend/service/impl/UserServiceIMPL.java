package lk.ijse.hello_shoes_shop_backend.service.impl;


import lk.ijse.hello_shoes_shop_backend.repository.UserRepo;
import lk.ijse.hello_shoes_shop_backend.dto.UserDto;
import lk.ijse.hello_shoes_shop_backend.service.UserService;
import lk.ijse.hello_shoes_shop_backend.conversion.ConversionData;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class UserServiceIMPL implements UserService {

    @Autowired
    private final UserRepo userRepo;
    @Autowired
    private final ConversionData conversionData;

    @Override
    public UserDetailsService userDetailsService() {
        return username ->
                userRepo.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
    }

    @Override
    public void saveUser(UserDto userDTO) {
        userRepo.save(conversionData.userDtoConvertUserEntity(userDTO));
    }
}
