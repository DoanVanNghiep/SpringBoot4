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
}