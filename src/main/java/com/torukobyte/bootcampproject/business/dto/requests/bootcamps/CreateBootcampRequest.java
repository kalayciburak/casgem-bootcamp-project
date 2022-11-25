package com.torukobyte.bootcampproject.business.dto.requests.bootcamps;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateBootcampRequest {
    private int instructorId;
    private String name;
    @Min(value = 1, message = "State cannot be less than 1")
    @Max(value = 2, message = "State cannot be more than 2")
    private int state;
    private LocalDate startDate;
    private LocalDate endDate;
}