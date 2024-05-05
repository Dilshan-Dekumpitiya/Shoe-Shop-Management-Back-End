package lk.ijse.shoeshopmanagementbackend;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ShoeShopManagementBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoeShopManagementBackEndApplication.class, args);
    }

    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
