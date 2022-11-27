package com.torukobyte.bootcampproject.business.abstracts.users;

import com.torukobyte.bootcampproject.business.dto.requests.users.applicants.CreateApplicantRequest;
import com.torukobyte.bootcampproject.business.dto.requests.users.applicants.UpdateApplicantRequest;
import com.torukobyte.bootcampproject.business.dto.responses.users.applicants.CreateApplicantResponse;
import com.torukobyte.bootcampproject.business.dto.responses.users.applicants.GetAllApplicantResponse;
import com.torukobyte.bootcampproject.business.dto.responses.users.applicants.GetApplicantResponse;
import com.torukobyte.bootcampproject.business.dto.responses.users.applicants.UpdateApplicantResponse;
import com.torukobyte.bootcampproject.core.util.results.DataResult;
import com.torukobyte.bootcampproject.core.util.results.Result;

import java.util.List;

public interface ApplicantService {
    DataResult<List<GetAllApplicantResponse>> getAll();
    DataResult<GetApplicantResponse> getById(int id);
    DataResult<CreateApplicantResponse> add(CreateApplicantRequest request);
    DataResult<UpdateApplicantResponse> update(UpdateApplicantRequest request, int id);
    Result delete(int id);
    DataResult<GetApplicantResponse> beAnApplicant(String about, int id);
    Result removeAnApplicant(int id);
    void checkIfApplicantExistById(int id);
}
