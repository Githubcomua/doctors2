package reestr.docs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reestr.docs.dao.DoctorDao;
import reestr.docs.models.Doctor;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private DoctorDao doctorDao;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/saveDoctor")
    public String myName(
            @RequestParam String family,
            @RequestParam String name,
            @RequestParam String department,
            Model model
    ) {
        Doctor doctor = new Doctor(family, name, department);
        System.out.println(doctor);
        doctorDao.save(doctor);
        System.out.println(doctor);
        model.addAttribute("doctor", doctor);
        List<Doctor> doctorList = doctorDao.findAll();
        model.addAttribute("allDoctors", doctorList);
        return "greeting";
    }

    @GetMapping("/doctor/{idOfDoctor}")
    public String getSingleDoctor(
            @PathVariable int idOfDoctor,
            Model model
    ) {
        Doctor doctor = doctorDao.findById(idOfDoctor).get();
        model.addAttribute("singleDoctor", doctor);
        return "singleDoctorPage";
    }

    @PostMapping("/updateDoctor")
    public String updateDoctor(
            Doctor doctor,
            Model model
    ) {
        System.out.println(doctor);
        doctorDao.save(doctor);
        model.addAttribute("singleDoctor", doctor);

        return "singleDoctorPage";
    }

    @GetMapping("/delete/{idOfDoctor}")
    public String deleteDoctor(@PathVariable int idOfDoctor,
                               Doctor doctor,
                               Model model
    ) {
        System.out.println(idOfDoctor);
        doctorDao.deleteById(idOfDoctor);

        System.out.println(doctor);
        model.addAttribute("doctor", doctor);
        List<Doctor> doctorList = doctorDao.findAll();
        model.addAttribute("allDoctors", doctorList);

        return "deleteDoctor";
    }

    @GetMapping("/doctorList")
    public String doctorList(Doctor doctor,
                             Model model
    ) {
        System.out.println(doctor);
        model.addAttribute("doctor", doctor);
        List<Doctor> doctorList = doctorDao.findAll();
        model.addAttribute("allDoctors", doctorList);

        return "doctorList";
    }

    @PostMapping("/successURL")
    public String successURL() {
        return "index";
    }

//    @GetMapping("/updateDoctor")
//    public String delDoctor(
//            Doctor doctor,
//            Model model
//    ) {
//        System.out.println(doctor);
//        doctorDao.save(doctor);
//        model.addAttribute("singleDoctor", doctor);
//
//        return "doctorList";
//    }
}