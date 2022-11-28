package com.torukobyte.bootcampproject.business.dto.requests.users;

import com.torukobyte.bootcampproject.business.constants.Regexes;
import com.torukobyte.bootcampproject.business.constants.ValidationMessages;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequest {
    @NotBlank(message = ValidationMessages.User.FirstNameBlank)
    @Length(min = 2, max = 50, message = ValidationMessages.User.FirstNameValid)
    private String firstName;
    @NotBlank(message = ValidationMessages.User.LastNameBlank)
    @Length(min = 2, max = 50, message = ValidationMessages.User.LastNameValid)
    private String lastName;
    @NotNull(message = ValidationMessages.User.DateOfBirthBlank)
    private LocalDate dateOfBirth;
    @NotBlank(message = ValidationMessages.User.NationalIdentityBlank)
    @Length(min = 11, max = 11, message = ValidationMessages.User.NationalIdentityValid)
    private String nationalIdentity;
    @NotBlank(message = ValidationMessages.User.EmailBlank)
    @Email(regexp = Regexes.Email, message = ValidationMessages.User.EmailValid)
    private String email;
    @NotBlank(message = ValidationMessages.User.PasswordBlank)
    @Pattern(regexp = Regexes.Password, message = ValidationMessages.User.PasswordValid)
    private String password;
    @NotBlank(message = ValidationMessages.User.ConfirmPasswordBlank)
    private String confirmPassword;
}
