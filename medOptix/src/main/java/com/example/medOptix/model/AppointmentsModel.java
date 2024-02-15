package com.example.medOptix.model;

import jakarta.persistence.*;

@Entity
public class AppointmentsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;
    private String timeSlot;

    private String status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personId",referencedColumnName = "personId")
    private PersonModel person;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clinicId",referencedColumnName = "clinicId")
    private ClinicModel clinic;

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PersonModel getPerson() {
        return person;
    }

    public void setPerson(PersonModel person) {
        this.person = person;
    }

    public ClinicModel getClinic() {
        return clinic;
    }

    public void setClinic(ClinicModel clinic) {
        this.clinic = clinic;
    }
}
