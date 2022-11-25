package com.torukobyte.bootcampproject.business.concretes.blacklists;

import com.torukobyte.bootcampproject.business.abstracts.blacklists.BlacklistService;
import com.torukobyte.bootcampproject.business.constants.Messages;
import com.torukobyte.bootcampproject.business.dto.requests.blacklists.CreateBlacklistRequest;
import com.torukobyte.bootcampproject.business.dto.requests.blacklists.UpdateBlacklistRequest;
import com.torukobyte.bootcampproject.business.dto.responses.blacklists.CreateBlacklistResponse;
import com.torukobyte.bootcampproject.business.dto.responses.blacklists.GetAllBlacklistResponse;
import com.torukobyte.bootcampproject.business.dto.responses.blacklists.GetBlacklistResponse;
import com.torukobyte.bootcampproject.business.dto.responses.blacklists.UpdateBlacklistResponse;
import com.torukobyte.bootcampproject.core.util.exceptions.BusinessException;
import com.torukobyte.bootcampproject.core.util.mapping.ModelMapperService;
import com.torukobyte.bootcampproject.core.util.results.DataResult;
import com.torukobyte.bootcampproject.core.util.results.Result;
import com.torukobyte.bootcampproject.core.util.results.SuccessDataResult;
import com.torukobyte.bootcampproject.core.util.results.SuccessResult;
import com.torukobyte.bootcampproject.entities.blacklists.Blacklist;
import com.torukobyte.bootcampproject.repository.abstracts.blacklists.BlacklistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BlacklistManager implements BlacklistService {
    private final BlacklistRepository repository;
    private ModelMapperService mapper;

    @Override
    public DataResult<List<GetAllBlacklistResponse>> getAll() {
        List<Blacklist> blacklists = repository.findAll();
        List<GetAllBlacklistResponse> data = blacklists
                .stream()
                .map(blacklist -> mapper.forResponse().map(blacklist, GetAllBlacklistResponse.class))
                .toList();

        return new SuccessDataResult<>(data, Messages.Blacklist.ListAll);
    }

    @Override
    public DataResult<GetBlacklistResponse> getById(int id) {
        Blacklist blacklist = repository.findById(id).orElseThrow();
        GetBlacklistResponse data = mapper.forResponse().map(blacklist, GetBlacklistResponse.class);

        return new SuccessDataResult<>(data, Messages.Blacklist.ListById);
    }

    @Override
    public DataResult<CreateBlacklistResponse> add(CreateBlacklistRequest request) {
        Blacklist blacklist = mapper.forRequest().map(request, Blacklist.class);
        blacklist.setId(0);
        repository.save(blacklist);
        CreateBlacklistResponse data = mapper.forResponse().map(blacklist, CreateBlacklistResponse.class);

        return new SuccessDataResult<>(data, Messages.Blacklist.Created);
    }

    @Override
    public DataResult<UpdateBlacklistResponse> update(UpdateBlacklistRequest request, int id) {
        Blacklist blacklist = mapper.forRequest().map(request, Blacklist.class);
        blacklist.setId(id);
        repository.save(blacklist);
        UpdateBlacklistResponse data = mapper.forResponse().map(blacklist, UpdateBlacklistResponse.class);

        return new SuccessDataResult<>(data, Messages.Blacklist.Updated);
    }

    @Override
    public Result delete(int id) {
        repository.deleteById(id);

        return new SuccessResult(Messages.Blacklist.Deleted);
    }

    private void checkIfBlacklistExistById(int id) {
        if (!repository.existsById(id)) {
            throw new BusinessException(Messages.Blacklist.BlacklistNotExist);
        }
    }

    public void checkIfApplicantInBlacklist(int applicantId){
        if(repository.findById(applicantId).isPresent()){ // TODO: fix
            throw new RuntimeException(Messages.Blacklist.ApplicantInBlacklist);
        }
    }
}
