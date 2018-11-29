package reestr.docs.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String family;
    private String name;
    private String department;

    public Doctor() {
    }

    public Doctor(String family, String name, String department) {
        this.family = family;
        this.name = name;
        this.department = department;
    }
}
