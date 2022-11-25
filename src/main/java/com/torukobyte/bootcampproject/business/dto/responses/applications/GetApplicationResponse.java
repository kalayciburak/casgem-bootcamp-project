package com.torukobyte.bootcampproject.business.dto.responses.applications;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetApplicationResponse {
    private int id;
    private int bootcampId;
    private int applicantId;
    private int state;
}
