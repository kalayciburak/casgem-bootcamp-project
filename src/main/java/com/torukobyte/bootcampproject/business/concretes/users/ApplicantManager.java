package com.torukobyte.bootcampproject.business.concretes.users;

import com.torukobyte.bootcampproject.business.abstracts.users.ApplicantService;
import com.torukobyte.bootcampproject.business.abstracts.users.EmployeeService;
import com.torukobyte.bootcampproject.business.constants.Messages;
import com.torukobyte.bootcampproject.business.constants.ValidationMessages;
import com.torukobyte.bootcampproject.business.dto.requests.users.applicants.CreateApplicantRequest;
import com.torukobyte.bootcampproject.business.dto.requests.users.applicants.UpdateApplicantRequest;
import com.torukobyte.bootcampproject.business.dto.responses.users.applicants.CreateApplicantResponse;
import com.torukobyte.bootcampproject.business.dto.responses.users.applicants.GetAllApplicantResponse;
import com.torukobyte.bootcampproject.business.dto.responses.users.applicants.GetApplicantResponse;
import com.torukobyte.bootcampproject.business.dto.responses.users.applicants.UpdateApplicantResponse;
import com.torukobyte.bootcampproject.core.util.exceptions.BusinessException;
import com.torukobyte.bootcampproject.core.util.mapping.ModelMapperService;
import com.torukobyte.bootcampproject.core.util.results.DataResult;
import com.torukobyte.bootcampproject.core.util.results.Result;
import com.torukobyte.bootcampproject.core.util.results.SuccessDataResult;
import com.torukobyte.bootcampproject.core.util.results.SuccessResult;
import com.torukobyte.bootcampproject.entities.users.Applicant;
import com.torukobyte.bootcampproject.repository.abstracts.users.ApplicantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.List;

@Service
@AllArgsConstructor
public class ApplicantManager implements ApplicantService {
    private ApplicantRepository repository;
    private EmployeeService employeeService;
    private ModelMapperService mapper;

    @Override
    public DataResult<List<GetAllApplicantResponse>> getAll() {
        List<Applicant> appliicants = repository.findAll();
        List<GetAllApplicantResponse> data = appliicants
                .stream()
                .map(applicant -> mapper.forResponse().map(applicant, GetAllApplicantResponse.class))
                .toList();

        return new SuccessDataResult<>(data, Messages.Applicant.ListAll);
    }

    @Override
    public DataResult<GetApplicantResponse> getById(int id) {
        checkIfApplicantExistById(id);
        Applicant appliicant = repository.findById(id).orElse(null);
        GetApplicantResponse data = mapper.forResponse().map(appliicant, GetApplicantResponse.class);

        return new SuccessDataResult<>(data, Messages.Applicant.ListById);
    }

    @Override
    public DataResult<CreateApplicantResponse> add(CreateApplicantRequest request) {
        comparePassword(request.getPassword(), request.getConfirmPassword());
        checkIfApplicantExistByNationalIdentity(request.getNationalIdentity());
        Applicant appliicant = mapper.forRequest().map(request, Applicant.class);
        repository.save(appliicant);
        CreateApplicantResponse data = mapper.forResponse().map(appliicant, CreateApplicantResponse.class);

        return new SuccessDataResult<>(data, Messages.Applicant.Created);
    }

    @Override
    public DataResult<UpdateApplicantResponse> update(UpdateApplicantRequest request, int id) {
        checkIfApplicantExistById(id);
        comparePassword(request.getPassword(), request.getConfirmPassword());
        checkIfApplicantExistByNationalIdentity(request.getNationalIdentity());
        Applicant applicant = mapper.forRequest().map(request, Applicant.class);
        applicant.setId(id);
        repository.save(applicant);
        UpdateApplicantResponse data = mapper.forResponse().map(applicant, UpdateApplicantResponse.class);

        return new SuccessDataResult<>(data, Messages.Applicant.Updated);
    }

    @Override
    public Result delete(int id) {
        checkIfApplicantExistById(id);
        repository.deleteById(id);

        return new SuccessResult(Messages.Applicant.Deleted);
    }

    @Override
    public DataResult<GetApplicantResponse> beAnApplicant(String about, int id) {
        checkIfAlreadyAnApplicant(id);
        checkIfAboutValid(about);
        Applicant applicant = mapper.forResponse().map(employeeService.getById(id).getData(), Applicant.class);
        applicant.setAbout(about);
        repository.beAnApplicant(about, id);
        GetApplicantResponse data = mapper.forResponse().map(applicant, GetApplicantResponse.class);

        return new SuccessDataResult<>(data, Messages.Applicant.BecameApplicant);
    }

    @Override
    public Result removeAnApplicant(int id) {
        checkIfApplicantExistById(id);
        employeeService.checkIfUserIsEmployee(id);
        repository.removeApplicantFromApplication(id);
        repository.removeApplicantFromBlacklist(id);
        repository.removeAnApplicant(id);

        return new SuccessResult(Messages.Applicant.Deleted);
    }

    @Override
    public Result changePassword(String oldPassword, String newPassword, String confirmPassword, int id) {
        checkIfApplicantExistById(id);
        if (!repository.findById(id).get().getPassword().equals(oldPassword)) {
            throw new ValidationException(ValidationMessages.User.OldPasswordNotMatch);
        }
        if (oldPassword.equals(newPassword)) {
            throw new ValidationException(ValidationMessages.User.ThereIsNoChangeInPassword);
        }
        comparePassword(newPassword, confirmPassword);
        repository.changePassword(newPassword, id);

        return new SuccessResult(Messages.User.PasswordChanged);
    }

    @Override
    public void checkIfApplicantExistById(int id) {
        if (!repository.existsById(id)) {
            throw new BusinessException(Messages.Applicant.ApplicantNotExists);
        }
    }

    private void checkIfAlreadyAnApplicant(int id) {
        if (repository.findById(id).isPresent()) {
            throw new BusinessException(Messages.Applicant.AlreadyApplicant);
        }
    }

    private void checkIfApplicantExistByNationalIdentity(String nationalIdentity) {
        if (repository.existsApplicantByNationalIdentity(nationalIdentity)) {
            throw new BusinessException(Messages.Applicant.ApplicantExists);
        }
    }

    private void checkIfAboutValid(String about) {
        if (about.length() <= 5 || about.length() >= 50) {
            throw new ValidationException(Messages.Applicant.AboutValid);
        }
    }

    private void comparePassword(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            throw new ValidationException(ValidationMessages.User.ConfirmPasswordValid);
        }
    }
}
