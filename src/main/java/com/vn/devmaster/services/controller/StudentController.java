package com.vn.devmaster.services.controller;
import com.vn.devmaster.services.dto.AddressDto;
import com.vn.devmaster.services.dto.StudentDTO;
import com.vn.devmaster.services.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    StudentServices studentServices;

    @GetMapping("/student")
    List<StudentDTO> getAll(){
        return studentServices.getAll();
    }

    //get all address
    @GetMapping("/address")
    List<AddressDto> getAllAD(){
        return studentServices.getAllAddress();
    }

    // tìm kiếm theo ID address
    @GetMapping("/addressID")
    List<AddressDto> getByID(@RequestParam("ID") Integer ID){
        List<AddressDto> dtos = studentServices.sreachByID(ID);
        return dtos;
    }

    // tìm kiếm những học sinh có địa chỉ ở hà nội
    @GetMapping("/addressDC")
    List<StudentDTO> getByDC(@RequestParam("diachi") String dc){
        List<StudentDTO> list = studentServices.sreachDiaChi(dc);
        return list;
    }


    // tìm kiếm theo tên sinh viên
    @GetMapping("/filter-name")
    List<StudentDTO> sreachByName(@RequestParam("name") String name){
        List<StudentDTO> dtos = studentServices.sreachName(name);
        return dtos;
    }


    @PostMapping("/student")
    String save(@RequestBody StudentDTO studentDTO){
        studentServices.save(studentDTO);
        return "Thành công!";
    }

    //thêm nhiều sinh viên
    @PostMapping("/students")
    String save(@RequestBody List<StudentDTO> studentDTOS){
        studentServices.save(studentDTOS);
        return "OK";
    }
}
