package reestr.docs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import reestr.docs.models.Doctor;

public interface DoctorDao extends JpaRepository<Doctor,Integer> {
}
