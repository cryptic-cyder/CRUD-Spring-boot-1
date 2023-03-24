package com.dailycodebuffer.Springboot.tutorial.controller;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import com.dailycodebuffer.Springboot.tutorial.error.DeptNotFoundException;
import com.dailycodebuffer.Springboot.tutorial.service.deptServieInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private deptServieInterface objOfDeptServiceInterface;

    //........CREATE METHODS......

    @PostMapping("/departmentsPOST")
    public Department create( @RequestBody Department departmentJsonBody){
        // telling spring whatever json you are getting as a responsebody , convert it to type of
        // Department named java object . to do this @RequestBody is used
        //loggerObj.info("Inside create of departmentController");
        return  objOfDeptServiceInterface.create(departmentJsonBody);
    }

    @PostMapping("/departmentListPOST")
    public List<Department> createSeveral(@RequestBody List<Department> deptSeveralJsonBody){
        return objOfDeptServiceInterface.createSeveral(deptSeveralJsonBody);
    }


    //........READ METHODS......

    @GetMapping("/departmentsGET")
    public List<Department> read(){
       // loggerObj.info("Inside read of departmentController");
        return objOfDeptServiceInterface.read();
    }

    @GetMapping("/departmentsGET/{getID}")
    public Department readById(@PathVariable("getID") Long inputedID) throws DeptNotFoundException {

        return objOfDeptServiceInterface.readById(inputedID);
    }

    @GetMapping("/departmentsGET/name/{getID}")
    public Department readByName(@PathVariable("getID") String deptName){
        return objOfDeptServiceInterface.readByName(deptName);
    }


    //........DELETE METHOD......

    @DeleteMapping("/departmentsDELETE/{deleteID}")
    public String deletingById(@PathVariable("deleteID") Long inputedID){

        objOfDeptServiceInterface.deletingById(inputedID);
        return ("Department "+inputedID + " deleted successfully...");
    }

    @DeleteMapping("/AllDepartmentDELETE")
    public String deletingAll(){
        return objOfDeptServiceInterface.deletingAll();
    }


    //........UPDATE METHOD......

    @PutMapping("/departmentsUPDATE/{updateID}")
    public Department updateById(@PathVariable("updateID") Long inputedId,
                                 @RequestBody Department departmentJsonBody
    ){
        //System.out.println("Updated...");
        return objOfDeptServiceInterface.updateById(inputedId,departmentJsonBody);
    }


}
