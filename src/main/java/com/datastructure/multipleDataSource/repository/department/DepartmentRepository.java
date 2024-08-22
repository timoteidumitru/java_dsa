package com.datastructure.multipleDataSource.repository.department;

import com.datastructure.multipleDataSource.model.department.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
