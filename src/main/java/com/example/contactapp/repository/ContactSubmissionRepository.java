package com.example.contactapp.repository;

import com.example.contactapp.entity.ContactSubmission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactSubmissionRepository extends JpaRepository<ContactSubmission, Long> {
}
