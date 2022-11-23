package com.torukobyte.bootcampproject.business.dto.responses.applicants;

import com.torukobyte.bootcampproject.business.dto.responses.CreateResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateApplicantResponse extends CreateResponse {
    private String about;
}
