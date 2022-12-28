package com.torukobyte.bootcampproject.business.concretes.applications;

import com.torukobyte.bootcampproject.business.abstracts.applications.ApplicationService;
import com.torukobyte.bootcampproject.business.abstracts.blacklists.BlacklistService;
import com.torukobyte.bootcampproject.business.abstracts.bootcamps.BootcampService;
import com.torukobyte.bootcampproject.business.abstracts.users.ApplicantService;
import com.torukobyte.bootcampproject.business.constants.Messages;
import com.torukobyte.bootcampproject.business.dto.requests.create.application.CreateApplicationRequest;
import com.torukobyte.bootcampproject.business.dto.requests.update.application.UpdateApplicationRequest;
import com.torukobyte.bootcampproject.business.dto.responses.create.application.CreateApplicationResponse;
import com.torukobyte.bootcampproject.business.dto.responses.get.applications.GetAllApplicationsResponse;
import com.torukobyte.bootcampproject.business.dto.responses.get.applications.GetApplicationResponse;
import com.torukobyte.bootcampproject.business.dto.responses.update.application.UpdateApplicationResponse;
import com.torukobyte.bootcampproject.core.utils.exceptions.BusinessException;
import com.torukobyte.bootcampproject.core.utils.mapping.ModelMapperService;
import com.torukobyte.bootcampproject.core.utils.results.DataResult;
import com.torukobyte.bootcampproject.core.utils.results.Result;
import com.torukobyte.bootcampproject.core.utils.results.SuccessDataResult;
import com.torukobyte.bootcampproject.core.utils.results.SuccessResult;
import com.torukobyte.bootcampproject.entities.applications.Application;
import com.torukobyte.bootcampproject.entities.applications.State;
import com.torukobyte.bootcampproject.repository.abstracts.applications.ApplicationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ApplicationManager implements ApplicationService {
    private final ApplicationRepository repository;
    private final BootcampService bootcampService;
    private final ApplicantService applicantService;
    private final BlacklistService blacklistService;
    private final ModelMapperService mapper;

    @Override
    public DataResult<List<GetAllApplicationsResponse>> getAll() {
        List<Application> applications = repository.findAll();
        List<GetAllApplicationsResponse> data = applications
                .stream()
                .map(application -> mapper.forResponse().map(application, GetAllApplicationsResponse.class))
                .toList();

        return new SuccessDataResult<>(data, Messages.Application.ListAll);
    }

    @Override
    public DataResult<GetApplicationResponse> getById(int id) {
        checkIfApplicationExistById(id);
        Application application = repository.findById(id).orElseThrow();
        GetApplicationResponse data = mapper.forResponse().map(application, GetApplicationResponse.class);

        return new SuccessDataResult<>(data, Messages.Application.ListById);
    }

    @Override
    public DataResult<CreateApplicationResponse> add(CreateApplicationRequest request) {
        bootcampService.checkIfBootcampExistById(request.getBootcampId());
        applicantService.checkIfApplicantExistById(request.getApplicantId());
        blacklistService.checkIfApplicantInBlacklist(request.getApplicantId());
        checkIfUserHasApplication(request.getApplicantId());
        bootcampService.checkIfBootcampIsActive(request.getBootcampId());
        Application application = mapper.forRequest().map(request, Application.class);
        State state = mapper.forResponse().map(application, State.class);
        state.setId(3); // Default state is "Pending"
        application.setState(state);
        application.setId(0);
        repository.save(application);
        CreateApplicationResponse data = mapper.forResponse().map(application, CreateApplicationResponse.class);

        return new SuccessDataResult<>(data, Messages.Application.Created);
    }

    @Override
    public DataResult<UpdateApplicationResponse> update(UpdateApplicationRequest request, int id) {
        checkIfApplicationExistById(id);
        bootcampService.checkIfBootcampExistById(request.getBootcampId());
        applicantService.checkIfApplicantExistById(request.getApplicantId());
        bootcampService.checkIfBootcampIsActive(request.getBootcampId());
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

    @Override
    public Result findApplicationAndDeleteFromApplication(int applicantId) {
        Application application = repository.findApplicationByApplicantId(applicantId);
        if (repository.existsApplicationsByApplicantId(applicantId)) {
            repository.deleteById(application.getId());

            return new SuccessResult(Messages.Blacklist.RemovedFromApplication);
        }

        return new SuccessResult(Messages.Blacklist.Blank);
    }

    private void checkIfUserHasApplication(int userId) {
        if (repository.existsApplicationsByApplicantId(userId)) {
            throw new BusinessException(Messages.Application.UserHasApplication);
        }
    }

    private void checkIfApplicationExistById(int id) {
        if (!repository.existsById(id)) {
            throw new BusinessException(Messages.Application.ApplicationNotExists);
        }
    }
}