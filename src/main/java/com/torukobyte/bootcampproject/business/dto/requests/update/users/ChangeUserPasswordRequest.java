package com.torukobyte.bootcampproject.business.dto.requests.update.users;

import com.torukobyte.bootcampproject.business.constants.Regexes;
import com.torukobyte.bootcampproject.business.constants.ValidationMessages;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChangeUserPasswordRequest {
    @NotBlank(message = ValidationMessages.User.OldPasswordBlank)
    private String oldPassword;
    @NotBlank(message = ValidationMessages.User.PasswordBlank)
    @Pattern(regexp = Regexes.Password, message = ValidationMessages.User.PasswordValid)
    private String newPassword;
    @NotBlank(message = ValidationMessages.User.ConfirmPasswordBlank)
    private String confirmPassword;
}
