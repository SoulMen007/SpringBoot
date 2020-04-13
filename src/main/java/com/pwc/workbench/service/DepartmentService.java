package com.pwc.workbench.service;

import java.util.List;

import com.pwc.workbench.domain.Department;

public interface DepartmentService {
    Department getById(Long id);

    List<Department> listAll();

    List<Department> listByUserId(Long userId);
}
