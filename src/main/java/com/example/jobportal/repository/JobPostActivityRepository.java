package com.example.jobportal.repository;

import com.example.jobportal.entity.IRecruiterjobs;
import com.example.jobportal.entity.JobPostActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface JobPostActivityRepository extends JpaRepository<JobPostActivity, Integer> {

    // Retrieves list of jobs for a given recruiter id, combines/ joins job post activity, job location, company
    //Also includes count of jobseekers/ candidates who have applied for a given job
    @Query(value = """
SELECT
  COUNT(s.user_id) AS totalCandidates,
  j.job_post_id,
  j.job_title,
  l.id AS locationId,
  l.city,
  l.state,
  l.country,
  c.id AS companyId,
  c.name
FROM job_post_activity j
INNER JOIN job_location l ON j.job_location_id = l.id
INNER JOIN job_company c ON j.job_company_id = c.id
LEFT JOIN job_seeker_apply s ON s.job = j.job_post_id
WHERE j.posted_by_id = :recruiter
GROUP BY
  j.job_post_id,
  j.job_title,
  l.id,
  l.city,
  l.state,
  l.country,
  c.id,
  c.name
""", nativeQuery = true)


    List<IRecruiterjobs> getRecruiterJobs(@Param("recruiter") int recruiter);

    @Query(value = "SELECT * FROM job_post_activity j " +
            "INNER JOIN job_location l ON j.job_location_id = l.id " +
            "WHERE j.job_title LIKE :job " +
            "AND (l.city LIKE :location OR l.country LIKE :location OR l.state LIKE :location) " +
            "AND j.job_type IN (:type) " +
            "AND j.remote IN (:remote)",
            nativeQuery = true)
    List<JobPostActivity> searchWithoutDate(@Param("job") String job,
                                            @Param("location") String location,
                                            @Param("remote") List<String> remote,
                                            @Param("type") List<String> type);

    @Query(value = "SELECT * FROM job_post_activity j " +
            "INNER JOIN job_location l ON j.job_location_id = l.id " +
            "WHERE j.job_title ILIKE :job " +
            "AND (l.city ILIKE :location OR l.country ILIKE :location OR l.state ILIKE :location) " +
            "AND j.job_type IN (:type) " +
            "AND j.remote IN (:remote) " +
            "AND j.posted_date >= :date",
            nativeQuery = true)
    List<JobPostActivity> search(@Param("job") String job,
                                 @Param("location") String location,
                                 @Param("remote") List<String> remote,
                                 @Param("type") List<String> type,
                                 @Param("date") LocalDate date);
}
