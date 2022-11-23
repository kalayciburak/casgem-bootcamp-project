package com.torukobyte.bootcampproject.business.dto.responses.applicants;

import com.torukobyte.bootcampproject.business.dto.responses.UpdateResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateApplicantResponse extends UpdateResponse {
    private String about;
}
