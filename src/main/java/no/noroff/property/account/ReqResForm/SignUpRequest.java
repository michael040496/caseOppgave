package no.noroff.property.account.ReqResForm;
import lombok.Data;
import no.noroff.property.account.account_type.AccountType;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class SignUpRequest {
    @NotBlank
    @Size(min = 4, max = 40)
    private String name;

    @NotBlank
    @Size(max = 40)
    @Email
    private String email;

    @NotBlank
    @Size(max = 40)
    private String username;


    @NotBlank
    @Size(min = 6, max = 20)
    private String password;


    @NotBlank
    @Size(max = 40)
    private String surname;


    @NotBlank
    @Size(max = 40)
    private String phone;


    private LocalDate dateOfBirth;


    private int accountTypeId;


}