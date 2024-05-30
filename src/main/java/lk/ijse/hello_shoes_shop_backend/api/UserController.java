package lk.ijse.hello_shoes_shop_backend.api;

import lk.ijse.hello_shoes_shop_backend.service.AuthenticationService;
import lk.ijse.hello_shoes_shop_backend.service.UserService;
import lk.ijse.hello_shoes_shop_backend.reqAndResp.response.JwtAuthResponse;
import lk.ijse.hello_shoes_shop_backend.reqAndResp.secure.SignIn;
import lk.ijse.hello_shoes_shop_backend.reqAndResp.secure.SignUp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/user/")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:63342")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/singUp")
    public ResponseEntity<JwtAuthResponse> signUp(@RequestBody SignUp signUpReq){
        return ResponseEntity.ok(authenticationService.signUp(signUpReq));
    }

    @PostMapping("/signIn")
    public String signIn(@RequestBody SignIn signInReq){
        JwtAuthResponse jwtAuthResponse = authenticationService.signIn(signInReq);
        String token = jwtAuthResponse.getToken();
        return token;

    }


}
