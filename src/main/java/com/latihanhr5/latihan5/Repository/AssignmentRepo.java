package com.latihanhr5.latihan5.Repository;

import com.latihanhr5.latihan5.Model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentRepo extends JpaRepository<Assignment,Long> {
}
