package com.example.medOptix.model;

import jakarta.persistence.*;

@Entity
@Table(name = "clinic")
public class ClinicModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clinicId")
    private Long clinicId;
    private String clinicName;
    private String description;
    private String address;
    private String email;
    private String password;

    @OneToOne(mappedBy ="clinic")
    private EntityModel entity;

    @OneToOne(mappedBy = "clinic")
    private AppointmentsModel appointmentsModel;

    public EntityModel getEntity() {
        return entity;
    }

    public void setEntity(EntityModel entity) {
        this.entity = entity;
    }

    public AppointmentsModel getAppointmentsModel() {
        return appointmentsModel;
    }

    public void setAppointmentsModel(AppointmentsModel appointmentsModel) {
        this.appointmentsModel = appointmentsModel;
    }

    public Long getClinicId() {
        return clinicId;
    }

    public void setClinicId(Long clinic_id) {
        this.clinicId = clinic_id;
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String name) {
        this.clinicName = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ClinicModel{" +
                "clinicId=" + clinicId +
                ", clinicName='" + clinicName + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", entity=" + entity +
                ", appointmentsModel=" + appointmentsModel +
                '}';
    }
}
