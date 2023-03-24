package com.dailycodebuffer.Springboot.tutorial.service;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import com.dailycodebuffer.Springboot.tutorial.error.DeptNotFoundException;
import com.dailycodebuffer.Springboot.tutorial.repository.DeptRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class deptServiceImplClass implements deptServieInterface{

    @Autowired
    private DeptRepoInterface objOfDeptRepoInterface;     //Dependency injection feature provides object of DeptRepoInterface


    @Override
    public Department create(Department departmentJsonBody) {
        return objOfDeptRepoInterface.save(departmentJsonBody);
    }

    @Override
    public List<Department> createSeveral(List<Department> departmentJsonBody) {
        return objOfDeptRepoInterface.saveAll(departmentJsonBody);
    }


    @Override
    public List<Department> read() {
        return objOfDeptRepoInterface.findAll();
    }

    @Override
    public Department readById(Long inputedID) {
        //return objOfDeptRepoInterface.findById(inputedID).get();
        Optional<Department> deptObj = objOfDeptRepoInterface.findById(inputedID);
       /* if (!deptObj.isPresent()){
            throw new DeptNotFoundException("Department not Available!!!");
        }*/
        return deptObj.get();
    }

    @Override
    public Department readByName(String deptName) {
        return objOfDeptRepoInterface.findByDepartNameIgnoreCase(deptName) ;
    }


    @Override
    public void deletingById(Long inputedID) {
        objOfDeptRepoInterface.deleteById(inputedID);
    }

    @Override
    public String deletingAll() {
        objOfDeptRepoInterface.deleteAll();
        return "All Records Deleted...";
    }


    @Override
    public Department updateById(Long inputedId, Department departmentJsonBody) {
        //System.out.println("checking");
        Department deptFromDbByID = objOfDeptRepoInterface.findById(inputedId).get();
        //Current record body get from Database by ID

        if(Objects.nonNull(departmentJsonBody.getDepartName()) &&
                !"".equalsIgnoreCase(departmentJsonBody.getDepartName()) ){

            deptFromDbByID.setDepartName(departmentJsonBody.getDepartName());
        }

        if(Objects.nonNull(departmentJsonBody.getDepartAddress()) &&
                !"".equalsIgnoreCase(departmentJsonBody.getDepartAddress())){

            deptFromDbByID.setDepartAddress(departmentJsonBody.getDepartAddress());
        }

        if(Objects.nonNull(departmentJsonBody.getDepartmentCode()) &&
                !"".equalsIgnoreCase(departmentJsonBody.getDepartmentCode())){

            deptFromDbByID.setDepartmentCode(departmentJsonBody.getDepartmentCode());
        }

        return objOfDeptRepoInterface.save(deptFromDbByID);
    }


}
