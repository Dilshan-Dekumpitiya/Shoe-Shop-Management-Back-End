package lk.ijse.hello_shoes_shop_backend.service.impl;


import lk.ijse.hello_shoes_shop_backend.repository.UserRepo;
import lk.ijse.hello_shoes_shop_backend.dto.UserDto;
import lk.ijse.hello_shoes_shop_backend.service.AuthenticationService;
import lk.ijse.hello_shoes_shop_backend.service.JWTService;
import lk.ijse.hello_shoes_shop_backend.conversion.ConversionData;
import lk.ijse.hello_shoes_shop_backend.entity.UserEntity;
import lk.ijse.hello_shoes_shop_backend.Enum.Role;
import lk.ijse.hello_shoes_shop_backend.reqAndResp.response.JwtAuthResponse;
import lk.ijse.hello_shoes_shop_backend.reqAndResp.secure.SignIn;
import lk.ijse.hello_shoes_shop_backend.reqAndResp.secure.SignUp;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceIMPL implements AuthenticationService {

    private final UserRepo userRepo;
    private final JWTService jwtService;
    private final ConversionData conversionData;

    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthResponse signIn(SignIn signIn) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signIn.getEmail(),signIn.getPassword()));
        UserEntity userByEmail = userRepo.findByEmail(signIn.getEmail()).orElseThrow(() -> new UsernameNotFoundException("Not Found User Mail"));
        String generatedToken = jwtService.generateToken(userByEmail);

        return JwtAuthResponse.builder().token(generatedToken).build();
    }

    @Override
    public JwtAuthResponse signUp(SignUp signUp) {
        UserDto userDTO = UserDto.builder()
                .email(signUp.getEmail())
                .name(signUp.getName())
                .emp_Id(signUp.getEmp_Id())
                .role(Role.valueOf(String.valueOf(signUp.getRole())))
                .password(passwordEncoder.encode(signUp.getPassword()))
                .build();





        UserEntity save = userRepo.save(conversionData.userDtoConvertUserEntity(userDTO));
        String s = jwtService.generateToken(save);
        return JwtAuthResponse.builder().token(s).build();

    }

    @Override
    public JwtAuthResponse refreshToken(String accessToken) {
        var userName = jwtService.extractUserName(accessToken);
        var userEntity = userRepo.findByEmail(userName).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var refreshToken = jwtService.generateToken(userEntity);
        return JwtAuthResponse.builder().token(refreshToken).build();
    }
}
