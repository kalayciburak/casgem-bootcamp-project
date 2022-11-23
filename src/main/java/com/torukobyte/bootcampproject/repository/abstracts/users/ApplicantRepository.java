package com.torukobyte.bootcampproject.repository.abstracts.users;

import com.torukobyte.bootcampproject.entities.users.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {
    @Modifying
    @Query(value = "insert into Applicants (about,id) VALUES (:about,:id)", nativeQuery = true)
    @Transactional
    void beAnApplicant(@Param("about") String about, @Param("id") int id);

    @Modifying
    @Query(value = "delete from Applicants where id = :id", nativeQuery = true)
    @Transactional
    void removeAnApplicant(int id);
}
