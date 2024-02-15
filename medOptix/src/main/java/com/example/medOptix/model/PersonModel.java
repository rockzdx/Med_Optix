package com.example.medOptix.model;

import jakarta.persistence.*;

@Entity
@Table(name = "person")
public class PersonModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;
    private String email;
    private Integer age;
    private String gender;
    private String name;
    private String password;

    @OneToOne(mappedBy = "person")
    private EntityModel entity;

    @OneToOne(mappedBy = "person")
    private AppointmentsModel appointmentsModel;

    public AppointmentsModel getAppointmentsModel() {
        return appointmentsModel;
    }

    public void setAppointmentsModel(AppointmentsModel appointmentsModel) {
        this.appointmentsModel = appointmentsModel;
    }

    public EntityModel getEntity() {
        return entity;
    }

    public void setEntity(EntityModel entity) {
        this.entity = entity;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long person_id) {
        this.personId = person_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PersonModel{" +
                "person_id=" + personId +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
