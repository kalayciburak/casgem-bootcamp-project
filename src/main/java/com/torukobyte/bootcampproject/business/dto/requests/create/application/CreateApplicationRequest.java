package com.torukobyte.bootcampproject.business.dto.requests.create.application;

import com.torukobyte.bootcampproject.business.constants.ValidationMessages;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateApplicationRequest {
    @Min(value = 1, message = ValidationMessages.Application.BootcampIdBlank)
    private int bootcampId;
    @Min(value = 1, message = ValidationMessages.Application.ApplicantIdBlank)
    private int applicantId;
}


