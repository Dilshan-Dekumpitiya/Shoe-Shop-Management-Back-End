package lk.ijse.shoeshopmanagementbackend.dto;

import jakarta.validation.constraints.*;
import lk.ijse.shoeshopmanagementbackend.Enum.Gender;
import lk.ijse.shoeshopmanagementbackend.Enum.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO implements SuperDTO {

    @Null(message = "Customer Id generate by the program")
    private String customerId;

    @NotBlank(message = "Customer name cannot be blank")
    @Size(min = 2, max = 50, message = "Customer name must be between 2 and 50 characters")
    private String customerName;

    @NotNull(message = "Gender cannot be null")
    private Gender gender;

    @Null(message = "Level is generated by the program")
    private Level level;

    @Null(message = "Join Date is  generate by the program")
    private Date joinDate;

    @PositiveOrZero(message = "Total points must be positive or zero")
    private Integer totalPoint;

    @Past(message = "Date of birth should be in the past")
    @NotNull(message = "Date of birth cannot be null")
    private Date dob;

    @NotBlank(message = "Address 1 cannot be blank")
    private String address1;

    @NotBlank(message = "Address 2 cannot be blank")
    private String address2;

    @NotBlank(message = "Address 3 cannot be blank")
    private String address3;

    @NotBlank(message = "Address 4 cannot be blank")
    private String address4;

    @NotBlank(message = "Postal code cannot be blank")
    @Pattern(regexp = "\\d{5}", message = "Postal code must be 5 digits")
    private String postalCode;

    @NotBlank(message = "Contact No cannot be blank")
    @Pattern(regexp = "^(?:0|94|\\+94|0094)?(?:(11|21|23|24|25|26|27|31|32|33|34|35|36|37|38|41|45|47|51|52|54|55|57|63|65|66|67|81|91)(0|2|3|4|5|7|9)|7(0|1|2|4|5|6|7|8)\\d)\\d{6}$", message = "Invalid contact number format")
    private String contactNo;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email cannot be blank")
    private String email;

    @Null(message = "Recent Purchased Date generate by the program")
    private Timestamp recentPurchasedDate;

}
