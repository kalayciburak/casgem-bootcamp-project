package com.torukobyte.bootcampproject.business.abstracts.blacklists;

import com.torukobyte.bootcampproject.business.dto.requests.blacklists.CreateBlacklistRequest;
import com.torukobyte.bootcampproject.business.dto.requests.blacklists.UpdateBlacklistRequest;
import com.torukobyte.bootcampproject.business.dto.responses.blacklists.CreateBlacklistResponse;
import com.torukobyte.bootcampproject.business.dto.responses.blacklists.GetAllBlacklistResponse;
import com.torukobyte.bootcampproject.business.dto.responses.blacklists.GetBlacklistResponse;
import com.torukobyte.bootcampproject.business.dto.responses.blacklists.UpdateBlacklistResponse;
import com.torukobyte.bootcampproject.core.util.results.DataResult;
import com.torukobyte.bootcampproject.core.util.results.Result;

import java.util.List;

public interface BlacklistService {
    DataResult<List<GetAllBlacklistResponse>> getAll();
    DataResult<GetBlacklistResponse> getById(int id);
    DataResult<CreateBlacklistResponse> add(CreateBlacklistRequest request);
    DataResult<UpdateBlacklistResponse> update(UpdateBlacklistRequest request, int id);
    Result delete(int id);
    void checkIfApplicantInBlacklist(int applicantId);
}
