package com.torukobyte.bootcampproject.business.abstracts.blacklists;

import com.torukobyte.bootcampproject.business.dto.requests.create.blacklist.CreateBlacklistRequest;
import com.torukobyte.bootcampproject.business.dto.requests.update.blacklist.UpdateBlacklistRequest;
import com.torukobyte.bootcampproject.business.dto.responses.create.blacklist.CreateBlacklistResponse;
import com.torukobyte.bootcampproject.business.dto.responses.get.blacklists.GetAllBlacklistsResponse;
import com.torukobyte.bootcampproject.business.dto.responses.get.blacklists.GetBlacklistResponse;
import com.torukobyte.bootcampproject.business.dto.responses.update.blacklist.UpdateBlacklistResponse;
import com.torukobyte.bootcampproject.core.util.results.DataResult;
import com.torukobyte.bootcampproject.core.util.results.Result;

import java.util.List;

public interface BlacklistService {
    DataResult<List<GetAllBlacklistsResponse>> getAll();
    DataResult<GetBlacklistResponse> getById(int id);
    DataResult<CreateBlacklistResponse> add(CreateBlacklistRequest request);
    DataResult<UpdateBlacklistResponse> update(UpdateBlacklistRequest request, int id);
    Result delete(int id);
    void checkIfApplicantInBlacklist(int applicantId);
}
