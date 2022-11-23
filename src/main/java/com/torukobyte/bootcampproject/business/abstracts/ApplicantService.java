package com.torukobyte.bootcampproject.business.abstracts;

import com.torukobyte.bootcampproject.business.dto.requests.applicants.CreateApplicantRequest;
import com.torukobyte.bootcampproject.business.dto.requests.applicants.UpdateApplicantRequest;
import com.torukobyte.bootcampproject.business.dto.responses.applicants.CreateApplicantResponse;
import com.torukobyte.bootcampproject.business.dto.responses.applicants.GetAllApplicantResponse;
import com.torukobyte.bootcampproject.business.dto.responses.applicants.GetApplicantResponse;
import com.torukobyte.bootcampproject.business.dto.responses.applicants.UpdateApplicantResponse;

import java.util.List;

public interface ApplicantService {
    List<GetAllApplicantResponse> getAll();
    GetApplicantResponse getById(int id);
    CreateApplicantResponse add(CreateApplicantRequest request);
    UpdateApplicantResponse update(UpdateApplicantRequest request, int id);
    void delete(int id);
}
