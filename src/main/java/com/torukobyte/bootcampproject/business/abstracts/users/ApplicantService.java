package com.torukobyte.bootcampproject.business.abstracts.users;

import com.torukobyte.bootcampproject.business.dto.requests.create.users.applicant.CreateApplicantRequest;
import com.torukobyte.bootcampproject.business.dto.requests.update.users.ChangeUserPasswordRequest;
import com.torukobyte.bootcampproject.business.dto.requests.update.users.applicant.UpdateApplicantRequest;
import com.torukobyte.bootcampproject.business.dto.responses.create.users.applicant.CreateApplicantResponse;
import com.torukobyte.bootcampproject.business.dto.responses.get.users.applicants.GetAllApplicantsResponse;
import com.torukobyte.bootcampproject.business.dto.responses.get.users.applicants.GetApplicantResponse;
import com.torukobyte.bootcampproject.business.dto.responses.update.users.applicant.UpdateApplicantResponse;
import com.torukobyte.bootcampproject.core.util.results.DataResult;
import com.torukobyte.bootcampproject.core.util.results.Result;

import java.util.List;

public interface ApplicantService {
    DataResult<List<GetAllApplicantsResponse>> getAll();
    DataResult<GetApplicantResponse> getById(int id);
    DataResult<CreateApplicantResponse> add(CreateApplicantRequest request);
    DataResult<UpdateApplicantResponse> update(UpdateApplicantRequest request, int id);
    Result delete(int id);
    DataResult<GetApplicantResponse> beAnApplicant(String about, int id);
    Result removeAnApplicant(int id);
    Result changePassword(ChangeUserPasswordRequest request, int id);
    void checkIfApplicantExistById(int id);
}
