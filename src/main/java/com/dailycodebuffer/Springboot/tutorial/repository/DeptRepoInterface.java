package com.dailycodebuffer.Springboot.tutorial.repository;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptRepoInterface extends JpaRepository<Department,Long> {

    public Department findByDepartNameIgnoreCase(String deptName);

}
