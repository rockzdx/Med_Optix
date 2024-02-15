package com.example.medOptix.model;

import jakarta.persistence.*;

@Entity
@Table(name = "clinic")
public class ClinicModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clinicId;
    private String name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                "clinic_id=" + clinicId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
