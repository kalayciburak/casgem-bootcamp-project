package com.torukobyte.bootcampproject.business.dto.responses.get.applications;

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
    private int stateId;
    private String stateInfo;
    private String bootcampName;
    private String userFirstName;
    private String userLastName;
}
