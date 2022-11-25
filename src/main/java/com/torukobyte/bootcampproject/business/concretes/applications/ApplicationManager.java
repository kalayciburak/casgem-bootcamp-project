package com.torukobyte.bootcampproject.business.concretes.applications;

import com.torukobyte.bootcampproject.business.abstracts.applications.ApplicationService;
import com.torukobyte.bootcampproject.business.abstracts.blacklists.BlacklistService;
import com.torukobyte.bootcampproject.business.abstracts.bootcamps.BootcampService;
import com.torukobyte.bootcampproject.business.abstracts.users.ApplicantService;
import com.torukobyte.bootcampproject.business.constants.Messages;
import com.torukobyte.bootcampproject.business.dto.requests.applications.CreateApplicationRequest;
import com.torukobyte.bootcampproject.business.dto.requests.applications.UpdateApplicationRequest;
import com.torukobyte.bootcampproject.business.dto.responses.applications.CreateApplicationResponse;
import com.torukobyte.bootcampproject.business.dto.responses.applications.GetAllApplicationResponse;
import com.torukobyte.bootcampproject.business.dto.responses.applications.GetApplicationResponse;
import com.torukobyte.bootcampproject.business.dto.responses.applications.UpdateApplicationResponse;
import com.torukobyte.bootcampproject.core.util.exceptions.BusinessException;
import com.torukobyte.bootcampproject.core.util.mapping.ModelMapperService;
import com.torukobyte.bootcampproject.core.util.results.DataResult;
import com.torukobyte.bootcampproject.core.util.results.Result;
import com.torukobyte.bootcampproject.core.util.results.SuccessDataResult;
import com.torukobyte.bootcampproject.core.util.results.SuccessResult;
import com.torukobyte.bootcampproject.entities.applications.Application;
import com.torukobyte.bootcampproject.repository.abstracts.applications.ApplicationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ApplicationManager implements ApplicationService {
    private final ApplicationRepository repository;
    private BootcampService bootcampService;
    private ApplicantService applicantService;
    private BlacklistService blacklistService;
    private ModelMapperService mapper;

    @Override
    public DataResult<List<GetAllApplicationResponse>> getAll() {
        List<Application> applications = repository.findAll();
        List<GetAllApplicationResponse> data = applications
                .stream()
                .map(application -> mapper.forResponse().map(application, GetAllApplicationResponse.class))
                .toList();

        return new SuccessDataResult<>(data, Messages.Application.ListAll);
    }

    @Override
    public DataResult<GetApplicationResponse> getById(int id) {
        checkIfApplicationExistById(id);
        Application application = repository.getById(id);
        GetApplicationResponse data = mapper.forResponse().map(application, GetApplicationResponse.class);

        return new SuccessDataResult<>(data, Messages.Application.ListById);
    }

    @Override
    public DataResult<CreateApplicationResponse> add(CreateApplicationRequest request) {
        blacklistService.checkIfApplicantInBlacklist(request.getApplicantId());
        applicantService.checkIfUserIsApplicant(request.getApplicantId());
        checkIfUserHasApplication(request.getApplicantId());
        bootcampService.checkIfBootcampIsActive(request.getBootcampId());
        Application application = mapper.forRequest().map(request, Application.class);
        application.setId(0);
        repository.save(application);
        CreateApplicationResponse data = mapper.forResponse().map(application, CreateApplicationResponse.class);

        return new SuccessDataResult<>(data, Messages.Application.Created);
    }

    @Override
    public DataResult<UpdateApplicationResponse> update(UpdateApplicationRequest request, int id) {
        checkIfApplicationExistById(id);
        Application application = mapper.forRequest().map(request, Application.class);
        application.setId(id);
        repository.save(application);
        UpdateApplicationResponse data = mapper.forResponse().map(application, UpdateApplicationResponse.class);

        return new SuccessDataResult<>(data, Messages.Application.Updated);
    }

    @Override
    public Result delete(int id) {
        checkIfApplicationExistById(id);
        repository.deleteById(id);
        return new SuccessResult(Messages.Application.Deleted);
    }

    private void checkIfApplicationExistById(int id) {
        if (!repository.existsById(id)) {
            throw new BusinessException(Messages.Application.ApplicationNotExists);
        }
    }

    public void checkIfUserHasApplication(int userId) {
        if (repository.existsApplicationsByApplicantId(userId)) {
            throw new BusinessException(Messages.Application.UserHasApplication);
        }
    }
}
