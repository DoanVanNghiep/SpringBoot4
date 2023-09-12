package com.vn.devmaster.services.services;

import com.vn.devmaster.services.domain.Address;
import com.vn.devmaster.services.domain.Student;
import com.vn.devmaster.services.dto.AddressDto;
import com.vn.devmaster.services.dto.StudentDTO;
import com.vn.devmaster.services.mapper.AddressMapper;
import com.vn.devmaster.services.mapper.StudentMapper;
import com.vn.devmaster.services.repository.AddressRepository;
import com.vn.devmaster.services.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class StudentServices {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private AddressRepository addressRepository;
    public List<StudentDTO> getAll(){
        List<Student> students = studentRepository.findAll();
        return studentMapper.toDO(students);
    }

    public void save(StudentDTO studentDTO){
        Student student = studentMapper.toEntity(studentDTO);
        studentRepository.save(student);
    }
    public List<StudentDTO> sreachName(String name){
        List<Student> students = studentRepository.getByName(name);
        return studentMapper.toDO(students);
    }

    public void save(List<StudentDTO> studentDTOS) {
        List<Student> students = studentMapper.toEntity(studentDTOS);
//        students.forEach(student -> studentRepository.save(student));
        studentRepository.saveAll(students);
    }
    // Địa chỉ
    public List<AddressDto> getAllAddress(){
        List<Address> addresses = addressRepository.findAll();
        return addressMapper.toDO(addresses);
    }
    public List<AddressDto> sreachByID(Integer ID){
        Address list = studentRepository.getById(ID).getAddress();
        return Collections.singletonList(addressMapper.toDO(list));
    }
    public List<StudentDTO> sreachDiaChi(String city) {
        List<Student> students = studentRepository.findAllByAddress_City(city);
        return studentMapper.toDO(students);
    }
}
