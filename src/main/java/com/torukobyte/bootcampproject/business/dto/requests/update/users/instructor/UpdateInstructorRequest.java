package com.torukobyte.bootcampproject.business.dto.requests.update.users.instructor;

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
public class UpdateInstructorRequest extends UpdateUserRequest {
    @NotBlank(message = ValidationMessages.Instructor.CompanyBlank)
    @Length(min = 2, max = 50, message = ValidationMessages.Instructor.CompanyValid)
    private String companyName;
}
