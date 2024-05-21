package lk.ijse.shoeshopmanagementbackend.service;

public interface AuthenticationService {
    JwtAuthResponse signUp(SignUp signup);
    JwtAuthResponse signIn(SignIn signIn);
    JwtAuthResponse refreshToken(String refreshToken);
}
