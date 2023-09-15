package com.vn.devmaster.services.repository;

import com.vn.devmaster.services.domain.Student;
import com.vn.devmaster.services.dto.AddressDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.SimpleTimeZone;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // viết query theo native
//    @Query(nativeQuery = true, value = "select * from student " +
//            "where first_name = :name")
//     List<Student> getByName(@Param("name") String Name);

    // HQL
    @Query(value = "select s from Student s where  s.firstName like concat('%',:name,'%')")
    List<Student> getByName(@Param("name") String name);

//    c3
//    List<Student> findAllByFirstName(String name);;
    @Query(value = "select a from Address a where  a.id = :id")
    List<AddressDto> GetById(@Param("id") Integer id);


    @Query(value = "select s from Student s where s.address.city like concat('%',:city,'%') ")
    List<Student> findAllByAddress_City(@Param("city") String city);

    @Query(nativeQuery = true, value = "select s.* from student s\n" +
            "                inner join student_subject ss on s.id = ss.id_student\n" +
            "                inner join subject s2 on ss.id_subject = s2.id\n" +
            "            where s2.name like concat('%', :name , '%')")
    List<Student> findAllBySubjects(@Param("name") String name);

    @Query(nativeQuery = true,value = "select s.* from student s\n" +
            "                inner join student_subject ss on s.id = ss.id_student\n" +
            "                inner join subject s2 on ss.id_subject = s2.id\n" +
            "            where ss.point > 8")
    List<Student> findAllByPoint();

    @Query(nativeQuery = true,value = "select s.* from student s\n" +
            "    inner join student_classes sc on s.id = sc.id_student\n" +
            "    inner join classes c on sc.id_class = c.id\n" +
            "where sc.id_class = 01\n")
    List<Student> findAllByClass();

    @Query(nativeQuery = true,value = "select s.* from student s\n" +
            "    inner join student_classes sc on s.id = sc.id_student\n" +
            "    inner join classes c on sc.id_class = c.id\n" +
            "where sc.id_class = 2")
    List<Student> findAllByAClass_Name();
}