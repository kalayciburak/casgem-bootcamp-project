package com.torukobyte.bootcampproject.business.dto.requests.bootcamps;

import com.torukobyte.bootcampproject.business.constants.ValidationMessages;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateBootcampRequest {
    @NotBlank(message = ValidationMessages.Bootcamp.InstructorIdBlank)
    private int instructorId;
    @NotBlank(message = ValidationMessages.Bootcamp.NameBlank)
    @Length(min = 3, max = 50, message = ValidationMessages.Bootcamp.NameValid)
    private String name;
    @Min(value = 1, message = ValidationMessages.Bootcamp.MinState)
    @Max(value = 2, message = ValidationMessages.Bootcamp.MaxState)
    private int state;
    @NotNull(message = ValidationMessages.Bootcamp.StartDateBlank)
    private LocalDate startDate;
    @NotNull(message = ValidationMessages.Bootcamp.EndDateBlank)
    private LocalDate endDate;
}