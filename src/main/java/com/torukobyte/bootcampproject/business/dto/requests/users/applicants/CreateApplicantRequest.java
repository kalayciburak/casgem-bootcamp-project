package com.torukobyte.bootcampproject.business.dto.requests.users.applicants;

import com.torukobyte.bootcampproject.business.dto.requests.users.CreateUserRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateApplicantRequest extends CreateUserRequest {
    @NotBlank(message = "About cannot be blank")
    private String about;
}