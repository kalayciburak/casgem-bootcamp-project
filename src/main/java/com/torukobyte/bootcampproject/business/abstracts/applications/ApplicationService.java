package com.torukobyte.bootcampproject.business.abstracts.applications;

import com.torukobyte.bootcampproject.business.dto.requests.create.application.CreateApplicationRequest;
import com.torukobyte.bootcampproject.business.dto.requests.update.application.UpdateApplicationRequest;
import com.torukobyte.bootcampproject.business.dto.responses.create.application.CreateApplicationResponse;
import com.torukobyte.bootcampproject.business.dto.responses.get.applications.GetAllApplicationsResponse;
import com.torukobyte.bootcampproject.business.dto.responses.get.applications.GetApplicationResponse;
import com.torukobyte.bootcampproject.business.dto.responses.update.application.UpdateApplicationResponse;
import com.torukobyte.bootcampproject.core.util.results.DataResult;
import com.torukobyte.bootcampproject.core.util.results.Result;

import java.util.List;

public interface ApplicationService {
    DataResult<List<GetAllApplicationsResponse>> getAll();
    DataResult<GetApplicationResponse> getById(int id);
    DataResult<CreateApplicationResponse> add(CreateApplicationRequest request);
    DataResult<UpdateApplicationResponse> update(UpdateApplicationRequest request, int id);
    Result delete(int id);
    Result findApplicationAndDeleteFromApplication(int applicantId);
}
