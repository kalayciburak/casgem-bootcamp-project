package com.torukobyte.bootcampproject.business.dto.requests.blacklists;

import com.torukobyte.bootcampproject.business.constants.ValidationMessages;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateBlacklistRequest {
    @Min(value = 1, message = ValidationMessages.Blacklist.ApplicantIdBlank)
    private int applicantId;
    @NotBlank(message = ValidationMessages.Blacklist.ReasonBlank)
    @Length(min = 5, max = 50, message = ValidationMessages.Blacklist.ReasonValid)
    private String reason;
}

