package lk.ijse.shoeshopmanagementbackend.service;

import lk.ijse.shoeshopmanagementbackend.secureAndResponse.response.JwtAuthResponse;
import lk.ijse.shoeshopmanagementbackend.secureAndResponse.secure.SignIn;
import lk.ijse.shoeshopmanagementbackend.secureAndResponse.secure.SignUp;

public interface AuthenticationService {
    JwtAuthResponse signUp(SignUp signup);
    JwtAuthResponse signIn(SignIn signIn);
    JwtAuthResponse refreshToken(String refreshToken);
}
