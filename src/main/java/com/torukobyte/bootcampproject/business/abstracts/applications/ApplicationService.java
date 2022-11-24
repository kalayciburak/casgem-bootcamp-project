package com.torukobyte.bootcampproject.business.abstracts.applications;

import com.torukobyte.bootcampproject.business.dto.requests.applications.CreateApplicationRequest;
import com.torukobyte.bootcampproject.business.dto.requests.applications.UpdateApplicationRequest;
import com.torukobyte.bootcampproject.business.dto.responses.applications.CreateApplicationResponse;
import com.torukobyte.bootcampproject.business.dto.responses.applications.GetAllApplicationResponse;
import com.torukobyte.bootcampproject.business.dto.responses.applications.GetApplicationResponse;
import com.torukobyte.bootcampproject.business.dto.responses.applications.UpdateApplicationResponse;
import com.torukobyte.bootcampproject.core.util.results.DataResult;
import com.torukobyte.bootcampproject.core.util.results.Result;

import java.util.List;

public interface ApplicationService {
    DataResult<List<GetAllApplicationResponse>> getAll();
    DataResult<GetApplicationResponse> getById(int id);
    DataResult<CreateApplicationResponse> add(CreateApplicationRequest request);
    DataResult<UpdateApplicationResponse> update(UpdateApplicationRequest request, int id);
    Result delete(int id);
}
