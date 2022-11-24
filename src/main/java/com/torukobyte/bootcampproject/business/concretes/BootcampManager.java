package com.torukobyte.bootcampproject.business.concretes;

import com.torukobyte.bootcampproject.business.abstracts.BootcampService;
import com.torukobyte.bootcampproject.business.constants.Messages;
import com.torukobyte.bootcampproject.business.dto.requests.CreateBootcampRequest;
import com.torukobyte.bootcampproject.business.dto.requests.UpdateBootcampRequest;
import com.torukobyte.bootcampproject.business.dto.responses.CreateBootcampResponse;
import com.torukobyte.bootcampproject.business.dto.responses.GetAllBootcampResponse;
import com.torukobyte.bootcampproject.business.dto.responses.GetBootcampResponse;
import com.torukobyte.bootcampproject.business.dto.responses.UpdateBootcampResponse;
import com.torukobyte.bootcampproject.core.util.exceptions.BusinessException;
import com.torukobyte.bootcampproject.core.util.mapping.ModelMapperService;
import com.torukobyte.bootcampproject.core.util.results.DataResult;
import com.torukobyte.bootcampproject.core.util.results.Result;
import com.torukobyte.bootcampproject.core.util.results.SuccessDataResult;
import com.torukobyte.bootcampproject.core.util.results.SuccessResult;
import com.torukobyte.bootcampproject.entities.Bootcamp;
import com.torukobyte.bootcampproject.repository.abstracts.BootcampRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BootcampManager implements BootcampService {
    private final BootcampRepository repository;
    private ModelMapperService mapper;

    @Override
    public DataResult<List<GetAllBootcampResponse>> getAll() {
        List<Bootcamp> bootcamps = repository.findAll();
        List<GetAllBootcampResponse> data = bootcamps
                .stream()
                .map(bootcamp -> mapper.forResponse().map(bootcamp, GetAllBootcampResponse.class))
                .toList();

        return new SuccessDataResult<>(data, Messages.Bootcamp.ListAll);
    }

    @Override
    public DataResult<GetBootcampResponse> getById(int id) {
        checkIfBootcampExistById(id);
        Bootcamp bootcamp = repository.findById(id).orElseThrow();
        GetBootcampResponse data = mapper.forResponse().map(bootcamp, GetBootcampResponse.class);

        return new SuccessDataResult<>(data, Messages.Bootcamp.ListedById);
    }

    @Override
    public DataResult<CreateBootcampResponse> add(CreateBootcampRequest request) {
        Bootcamp bootcamp = mapper.forRequest().map(request, Bootcamp.class);
        bootcamp.setId(0);
        repository.save(bootcamp);
        CreateBootcampResponse data = mapper.forResponse().map(bootcamp, CreateBootcampResponse.class);

        return new SuccessDataResult<>(data, Messages.Bootcamp.Created);
    }

    @Override
    public DataResult<UpdateBootcampResponse> update(UpdateBootcampRequest request, int id) {
        checkIfBootcampExistById(id);
        Bootcamp bootcamp = mapper.forRequest().map(request, Bootcamp.class);
        bootcamp.setId(id);
        repository.save(bootcamp);
        UpdateBootcampResponse data = mapper.forResponse().map(bootcamp, UpdateBootcampResponse.class);

        return new SuccessDataResult<>(data, Messages.Bootcamp.Updated);
    }

    @Override
    public Result delete(int id) {
        checkIfBootcampExistById(id);
        repository.deleteById(id);
        return new SuccessResult(Messages.Bootcamp.Deleted);
    }

    private void checkIfBootcampExistById(int id) {
        if (!repository.existsById(id)) {
            throw new BusinessException(Messages.Bootcamp.BootcampNotExists);
        }
    }

    @Override
    public void checkIfBootcampIsActive(int id){
        Bootcamp bootcamp = repository.findById(id).orElseThrow();
        if(bootcamp.getState() == 2){
            throw new BusinessException(Messages.Bootcamp.BootcampIsNotActive);
        }
    }
}
