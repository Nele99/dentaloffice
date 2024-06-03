package me.dentaloffice.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "checkup")
public class Checkup {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "checkup_seq")
    @SequenceGenerator(name = "checkup_seq", sequenceName = "checkup_checkup_id_seq", allocationSize = 1)
    @Column(name = "checkup_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "dentist_id", referencedColumnName = "dentist_id", nullable = false)
    private Dentist dentist;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id", nullable = false)
    private Patient patient;

    @Column(name = "description", nullable = false, length = 255)
    private String description;

    @Column(name = "checkup_type", nullable = false)
    private boolean checkupType;

    @Column(name = "checkup_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date checkupDate;

    @Column(name = "checkup_time", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date checkupTime;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCheckupType() {
        return checkupType;
    }

    public void setCheckupType(boolean checkupType) {
        this.checkupType = checkupType;
    }

    public Date getCheckupDate() {
        return checkupDate;
    }

    public void setCheckupDate(Date checkupDate) {
        this.checkupDate = checkupDate;
    }

    public Date getCheckupTime() {
        return checkupTime;
    }

    public void setCheckupTime(Date checkupTime) {
        this.checkupTime = checkupTime;
    }

    // Override hashCode and equals methods
    @Override
    public int hashCode() {
        return Objects.hash(id, dentist, patient, description, checkupType, checkupDate, checkupTime);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Checkup checkup = (Checkup) obj;
        return Objects.equals(id, checkup.id) &&
                Objects.equals(dentist, checkup.dentist) &&
                Objects.equals(patient, checkup.patient) &&
                Objects.equals(description, checkup.description) &&
                Objects.equals(checkupType, checkup.checkupType) &&
                Objects.equals(checkupDate, checkup.checkupDate) &&
                Objects.equals(checkupTime, checkup.checkupTime);
    }

    // Override toString method
    @Override
    public String toString() {
        return "Checkup{" +
                "id=" + id +
                ", dentist=" + dentist +
                ", patient=" + patient +
                ", description='" + description + '\'' +
                ", checkupType=" + checkupType +
                ", checkupDate=" + checkupDate +
                ", checkupTime=" + checkupTime +
                '}';
    }
}
