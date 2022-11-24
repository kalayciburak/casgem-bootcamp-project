package com.torukobyte.bootcampproject.business.dto.requests.applications;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateApplicationRequest {
    private int bootcampId;
    private int userId;
    private int state;
}
