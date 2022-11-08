package com.example.doctorservice.dao;

import com.example.doctorservice.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorDao extends JpaRepository<Doctor, Integer> {
	Doctor findByDoctorIDNumber(String idnumber);
}