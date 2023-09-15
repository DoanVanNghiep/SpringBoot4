package com.vn.devmaster.services.mapper;

import com.vn.devmaster.services.domain.Student;
import com.vn.devmaster.services.dto.StudentDTO;
import com.vn.devmaster.services.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class StudentMapper {
    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    private SubjectMapper subjectMapper;
    @Autowired
    private ClassMapper classMapper;
    @Autowired
    private StudentSubjectMapper studentSubjectMapper;


    public StudentDTO toDO(Student student) {
        StudentDTO dto = StudentDTO
                .builder()
                .id(student.getId())
                .fullName(student.getFirstName() + " " + student.getLastName())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .addressDto(addressMapper.toDO(student.getAddress()))
                .subjectDtos(subjectMapper.toDO(student.getSubjects()))
                .classDto(classMapper.toDO(student.getAClass()))
                .build();
        return dto;
    }

    public List<StudentDTO> toDO(List<Student> students) {
        List<StudentDTO> dtos = new ArrayList<>();
        students.forEach(student -> {
            dtos.add(toDO(student));
        });
        return dtos;
    }

    public Student toEntity(StudentDTO studentDTO) {
        Student student = Student
                .builder()
//                .id(studentDTO.getId())
                .firstName(studentDTO.getFirstName())
                .lastName(studentDTO.getLastName())
                .build();
        return student;
    }

    public List<Student> toEntity(List<StudentDTO> dtos){
        List<Student> list = new ArrayList<>();
        dtos.forEach( studentdto -> {
            list.add(toEntity(studentdto));
        });
        return list;
    }

    public StudentDTO toDTO(Student student) {
        StudentDTO dto = StudentDTO
                .builder()
                .fullName(student.getFirstName() + " " + student.getLastName())
                .subjectDtos(subjectMapper.toDO(student.getSubjects()))
                .aClass(String.valueOf(student.getAClass().getName()))
                .point(student.getSubject().getPoint())
                .build();
        return dto;
    }

    public List<StudentDTO> toDTO(List<Student> students) {
        List<StudentDTO> dtos = new ArrayList<>();
        students.forEach(student -> {
            dtos.add(toDO(student));
        });
        return dtos;
    }
}
