package com.torukobyte.bootcampproject.business.concretes.bootcamps;

import com.torukobyte.bootcampproject.business.abstracts.bootcamps.BootcampService;
import com.torukobyte.bootcampproject.business.abstracts.users.InstructorService;
import com.torukobyte.bootcampproject.business.constants.Messages;
import com.torukobyte.bootcampproject.business.dto.requests.create.bootcamp.CreateBootcampRequest;
import com.torukobyte.bootcampproject.business.dto.requests.update.bootcamp.UpdateBootcampRequest;
import com.torukobyte.bootcampproject.business.dto.responses.create.bootcamp.CreateBootcampResponse;
import com.torukobyte.bootcampproject.business.dto.responses.get.bootcamps.GetAllBootcampsResponse;
import com.torukobyte.bootcampproject.business.dto.responses.get.bootcamps.GetBootcampResponse;
import com.torukobyte.bootcampproject.business.dto.responses.update.bootcamp.UpdateBootcampResponse;
import com.torukobyte.bootcampproject.core.utils.exceptions.BusinessException;
import com.torukobyte.bootcampproject.core.utils.mapping.ModelMapperService;
import com.torukobyte.bootcampproject.core.utils.results.DataResult;
import com.torukobyte.bootcampproject.core.utils.results.Result;
import com.torukobyte.bootcampproject.core.utils.results.SuccessDataResult;
import com.torukobyte.bootcampproject.core.utils.results.SuccessResult;
import com.torukobyte.bootcampproject.entities.bootcamps.Bootcamp;
import com.torukobyte.bootcampproject.repository.abstracts.bootcamps.BootcampRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class BootcampManager implements BootcampService {
    private final BootcampRepository repository;
    private final InstructorService instructorService;
    private final ModelMapperService mapper;

    @Override
    @Cacheable("bootcamps")
    public DataResult<List<GetAllBootcampsResponse>> getAll() {

        List<Bootcamp> bootcamps = repository.findAll();
        List<GetAllBootcampsResponse> data = bootcamps
                .stream()
                .map(bootcamp -> mapper.forResponse().map(bootcamp, GetAllBootcampsResponse.class))
                .toList();

        return new SuccessDataResult<>(data, Messages.Bootcamp.ListAll);
    }

    @Override
    public DataResult<GetBootcampResponse> getById(int id) {
        checkIfBootcampExistById(id);
        Bootcamp bootcamp = repository.findById(id).orElseThrow();
        GetBootcampResponse data = mapper.forResponse().map(bootcamp, GetBootcampResponse.class);

        return new SuccessDataResult<>(data, Messages.Bootcamp.ListById);
    }

    @Override
    @CacheEvict(value = "bootcamps", allEntries = true)
    public DataResult<CreateBootcampResponse> add(CreateBootcampRequest request) {
        instructorService.checkIfInstructorExistById(request.getInstructorId());
        checkIfStartDateBiggerThanEndDate(request.getStartDate(), request.getEndDate());
        Bootcamp bootcamp = mapper.forRequest().map(request, Bootcamp.class);
        bootcamp.setId(0);
        repository.save(bootcamp);
        CreateBootcampResponse data = mapper.forResponse().map(bootcamp, CreateBootcampResponse.class);

        return new SuccessDataResult<>(data, Messages.Bootcamp.Created);
    }

    @Override
    public DataResult<UpdateBootcampResponse> update(UpdateBootcampRequest request, int id) {
        checkIfBootcampExistById(id);
        instructorService.checkIfInstructorExistById(request.getInstructorId());
        checkIfStartDateBiggerThanEndDate(request.getStartDate(), request.getEndDate());
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

    @Override
    public void checkIfBootcampIsActive(int bootcampId) {
        checkIfBootcampExistById(bootcampId);
        Bootcamp bootcamp = repository.findById(bootcampId).orElseThrow();
        if (bootcamp.getState() == 2) {
            throw new BusinessException(Messages.Bootcamp.BootcampIsNotActive);
        }
    }

    @Override
    public void checkIfBootcampExistById(int id) {
        if (!repository.existsById(id)) {
            throw new BusinessException(Messages.Bootcamp.BootcampNotExists);
        }
    }

    private void checkIfStartDateBiggerThanEndDate(LocalDate startDate, LocalDate endDate) {
        if (startDate.isAfter(endDate) || startDate.isEqual(endDate)) {
            throw new ValidationException(Messages.Bootcamp.StartDateBigThanEndDate);
        }
    }
}
