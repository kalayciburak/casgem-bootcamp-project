package com.torukobyte.bootcampproject.business.dto.requests.applications;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateApplicationRequest {
    private int bootcampId;
    private int applicantId;
    @Min(value = 1, message = "State cannot be less than 1")
    @Max(value = 4, message = "State cannot be more than 4")
    private int state;
}


