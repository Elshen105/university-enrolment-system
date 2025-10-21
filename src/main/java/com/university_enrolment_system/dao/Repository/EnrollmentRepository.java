package com.university_enrolment_system.dao.Repository;

import com.university_enrolment_system.dao.entity.EnrollmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<EnrollmentEntity,Long> {
}
