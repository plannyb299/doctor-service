package com.example.doctorservice.service;

import com.example.doctorservice.dao.DoctorDao;
import com.example.doctorservice.models.Doctor;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

	private final DoctorDao doctorDao;

	public DoctorService(DoctorDao doctorDao) {
		this.doctorDao = doctorDao;
	}

	// General Doctor Functions //

	public Doctor createDoctor(Doctor doctor) {
		return doctorDao.save(doctor);
	}

	public Doctor getDoctorById(Integer doctorId) {
		return doctorDao.findById(doctorId).orElse(null);
	}

	public Doctor getDoctorByIdNumber(String doctorIdNumber) {
		return doctorDao.findByDoctorIDNumber(doctorIdNumber);
	}

	public Iterable<Doctor> getAllDoctors() {
		return doctorDao.findAll();
	}

	public void deleteDoctor(Integer doctorId) {
		doctorDao.deleteById(doctorId);
	}

	// Get All Doctor Patients Function //
	
	/*public Set<Patient> getAllDoctorPatients(Integer doctorId) {
		Doctor doctor = doctorDao.findById(doctorId).orElse(null);
		if (doctor == null) return null;
		return doctor.getPatients();
	}*/

	// Update Doctor Information Functions //

	public Doctor updateDoctorName(Integer doctorId, String newName) {
		Doctor doctorFromDb = doctorDao.findById(doctorId).orElse(null);
		if (doctorFromDb == null) return null;
		doctorFromDb.setDoctorName(newName);
		Doctor updatedDoctor = doctorDao.save(doctorFromDb);
		return updatedDoctor;
	}

	public Doctor updateDoctorSpecialty(Integer doctorId, String newSpecialty) {
		Doctor doctorFromDb = doctorDao.findById(doctorId).orElse(null);
		if (doctorFromDb == null) return null;
		doctorFromDb.setDoctorSpecialty(newSpecialty);
		Doctor updatedDoctor = doctorDao.save(doctorFromDb);
		return updatedDoctor;
	}
}