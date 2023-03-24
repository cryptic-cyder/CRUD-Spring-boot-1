package com.dailycodebuffer.Springboot.tutorial.service;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import com.dailycodebuffer.Springboot.tutorial.error.DeptNotFoundException;

import java.util.List;

public interface deptServieInterface {
   public Department create(Department departmentJsonBody);

   public List<Department> createSeveral(List<Department> deptSeveralJsonBody);

   public List<Department> read();

   public Department readById(Long inputedID) ;

   public Department readByName(String deptName);

  public void deletingById(Long inputedID);

  public String deletingAll();

   public Department updateById(Long inputedId, Department departmentJsonBody);


}
