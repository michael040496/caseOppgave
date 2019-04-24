package no.noroff.property.security;

import no.noroff.property.account.Account;
import no.noroff.property.account.AccountRepository;
import no.noroff.property.account.AccountSerivce;
import no.noroff.property.account.ReqResForm.ApiResponse;
import no.noroff.property.account.ReqResForm.JwtAuthenticationResponse;
import no.noroff.property.account.ReqResForm.LoginRequest;
import no.noroff.property.account.ReqResForm.SignUpRequest;
import no.noroff.property.account.account_type.AccountTypeRepository;
import no.noroff.property.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    AccountRepository userRepository;

    @Autowired
    AccountSerivce accountSerivce;

    @Autowired
    AccountTypeRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        // sends all info of user
        Optional<Account> acc = accountSerivce.getByUsernameOrEmail(loginRequest.getUsernameOrEmail(), loginRequest.getUsernameOrEmail());


        System.out.println(acc);
        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt, acc));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

     /*   if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }*/

        // Creating user's account
        Account user = new Account(
                signUpRequest.getUsername(),
                signUpRequest.getSurname(),
                signUpRequest.getName(),
                signUpRequest.getPhone(),
                signUpRequest.getEmail(),
                signUpRequest.getDateOfBirth(),
                signUpRequest.getPassword(),
                signUpRequest.getAccountTypeId()
                );

        user.setPassword(passwordEncoder.encode(user.getPassword()));

       // AccountType userRole = roleRepository.findByName(RoleName.buyer).orElseThrow(() -> new AppException("User Role not set."));
        //Optional<AccountType> userRole = roleRepository.findById(1); //.orElseThrow(() -> new AppException("User Role not set."));


     /*   AccountType accountType = new AccountType();
        accountType.setAccountTypeId(1);
        user.getAccountType().add(accountType);


      */

        //user.setAccountType(Collections.singleton(accountType));

        Account result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(result.getEmail()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }
}