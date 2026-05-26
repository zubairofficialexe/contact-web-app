package com.example.contactapp.service;

import com.example.contactapp.entity.ContactSubmission;
import com.example.contactapp.repository.ContactSubmissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactSubmissionService {

    private final ContactSubmissionRepository repository;

    public ContactSubmissionService(ContactSubmissionRepository repository) {
        this.repository = repository;
    }

    public ContactSubmission save(ContactSubmission submission) {
        return repository.save(submission);
    }

    public List<ContactSubmission> findAllLatestFirst() {
        var submissions = repository.findAll();
        submissions.sort((a, b) -> b.getCreatedAt().compareTo(a.getCreatedAt()));
        return submissions;
    }
}
