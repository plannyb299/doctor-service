package com.example.doctorservice.controller;

import com.example.doctorservice.dto.DoctorsDTO;
import com.example.doctorservice.models.Doctor;
import com.example.doctorservice.service.DoctorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/doctors")
public class DoctorController {

	private final DoctorService doctorService;

	public DoctorController(DoctorService doctorService) {
		this.doctorService = doctorService;
	}

	// General Doctor Functions //

	@PostMapping(value = "/create")
	public Doctor createDoctor(@RequestBody Doctor doctor) {
		return doctorService.createDoctor(doctor);
	}

	@GetMapping(value = "/get-by-id/{doctorId}")
	public Doctor getDoctorById(@PathVariable("doctorId") Integer doctorId) {
		return doctorService.getDoctorById(doctorId);
	}

	@GetMapping(value = "/get-by-id-number/{doctorIdNumber}")
	public Doctor getDoctorByIdentificationNumber(@PathVariable("doctorIdNumber") String doctorIdNumber) {
		return doctorService.getDoctorByIdNumber(doctorIdNumber);
	}

	@GetMapping(value = "/get/all")
	public DoctorsDTO getAllDoctors() {
		return new DoctorsDTO(doctorService.getAllDoctors());
	}

	@DeleteMapping(value = "/delete/{doctorId}")
	public void deleteDoctor(@PathVariable("doctorId") Integer doctorId) {
		doctorService.deleteDoctor(doctorId);
	}

	// Get All Doctor Patients Function //
	
	/*@GetMapping(value="/view/{doctorId}/get-all-patients")
	public Iterable<Patient> getAllDoctorPatients(@PathVariable("doctorId") Integer doctorId){
		return doctorService.getAllDoctorPatients(doctorId);
	}*/

	// Update Doctor Information Functions //

	@PutMapping(value = "/{doctorId}/update-name/{newName}")
	public Doctor updateDoctorName(@PathVariable("doctorId") Integer doctorId, @PathVariable("newName") String newName) {
		return doctorService.updateDoctorName(doctorId, newName);
	}

	@PutMapping(value = "/{doctorId}/update-specialty/{newSpecialty}")
	public Doctor updateDoctorSpecialty(@PathVariable("doctorId") Integer doctorId, @PathVariable("newSpecialty") String newSpecialty) {
		return doctorService.updateDoctorSpecialty(doctorId, newSpecialty);
	}
}