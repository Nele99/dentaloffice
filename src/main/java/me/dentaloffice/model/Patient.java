package me.dentaloffice.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_seq")
    @SequenceGenerator(name = "patient_seq", sequenceName = "patient_patient_id_seq", allocationSize = 1)
    @Column(name = "patient_id")
    private Integer id;

    // OneToMany veza sa pregledima
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Checkup> checkups = new HashSet<>();

    // Getters and Setters za checkups polje
    public Set<Checkup> getCheckups() {
        return checkups;
    }

    public void setCheckups(Set<Checkup> checkups) {
        this.checkups = checkups;
    }

    // Metoda za dodavanje pregleda
    public void addCheckup(Checkup checkup) {
        checkups.add(checkup);
        checkup.setPatient(this);
    }

    // Metoda za uklanjanje pregleda
    public void removeCheckup(Checkup checkup) {
        checkups.remove(checkup);
        checkup.setPatient(null);
    }

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "surname", nullable = false, length = 50)
    private String surname;

    @Column(name = "jmbg", nullable = false, length = 13, unique = true)
    private String jmbg;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(name = "birth_year")
    private Integer birthYear;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    // Override hashCode and equals methods
    @Override
    public int hashCode() {
        return Objects.hash(id, jmbg);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Patient patient = (Patient) obj;
        return Objects.equals(id, patient.id) && Objects.equals(jmbg, patient.jmbg);
    }

    // Override toString method
    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", jmbg='" + jmbg + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birthYear=" + birthYear +
                '}';
    }
}
