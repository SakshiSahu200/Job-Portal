package com.example.jobportal.repository;

import com.example.jobportal.entity.JobPostActivity;
import com.example.jobportal.entity.JobSeekerApply;
import com.example.jobportal.entity.JobSeekerProfile;
import com.example.jobportal.entity.JobSeekerSave;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobSeekerSaveRepository extends JpaRepository<JobSeekerSave, Integer> {

    List<JobSeekerSave> findByUserId(JobSeekerProfile userId);

    List<JobSeekerSave> findByJob(JobPostActivity job);
}
