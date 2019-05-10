package com.latihanhr5.latihan5.Repository;

import com.latihanhr5.latihan5.Model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepo extends JpaRepository<Subject,Long> {
}
