package com.torukobyte.bootcampproject.business.abstracts;

import com.torukobyte.bootcampproject.business.dto.requests.CreateBootcampRequest;
import com.torukobyte.bootcampproject.business.dto.requests.UpdateBootcampRequest;
import com.torukobyte.bootcampproject.business.dto.responses.CreateBootcampResponse;
import com.torukobyte.bootcampproject.business.dto.responses.GetAllBootcampResponse;
import com.torukobyte.bootcampproject.business.dto.responses.GetBootcampResponse;
import com.torukobyte.bootcampproject.business.dto.responses.UpdateBootcampResponse;
import com.torukobyte.bootcampproject.core.util.results.DataResult;
import com.torukobyte.bootcampproject.core.util.results.Result;

import java.util.List;

public interface BootcampService {
    DataResult<List<GetAllBootcampResponse>> getAll();
    DataResult<GetBootcampResponse> getById(int id);
    DataResult<CreateBootcampResponse> add(CreateBootcampRequest request);
    DataResult<UpdateBootcampResponse> update(UpdateBootcampRequest request, int id);
    Result delete(int id);
    void checkIfBootcampIsActive(int id);
}
