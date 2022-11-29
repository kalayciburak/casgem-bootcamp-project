package com.torukobyte.bootcampproject.business.dto.requests.update.users.applicant;

import com.torukobyte.bootcampproject.business.constants.ValidationMessages;
import com.torukobyte.bootcampproject.business.dto.requests.update.users.UpdateUserRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateApplicantRequest extends UpdateUserRequest {
    @NotBlank(message = ValidationMessages.Applicant.AboutBlank)
    @Length(min = 5, max = 50, message = ValidationMessages.Applicant.AboutValid)
    private String about;
}
