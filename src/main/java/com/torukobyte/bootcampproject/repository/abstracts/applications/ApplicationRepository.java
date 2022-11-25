package com.torukobyte.bootcampproject.repository.abstracts.applications;

import com.torukobyte.bootcampproject.entities.applications.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {
    boolean existsApplicationsByApplicantId(int userId);
    Application findApplicationByApplicantId(int userId);
}
