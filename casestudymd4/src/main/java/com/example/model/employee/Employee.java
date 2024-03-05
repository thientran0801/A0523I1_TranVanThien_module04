package com.example.model.employee;

import com.example.model.Contract;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name, phone, email,id_card, address;
    private LocalDate date_of_birth;
    private double salary;
    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division division;

    @ManyToOne
    @JoinColumn(name = "education_degree_id")
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "username")
    private User userName;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Contract> contractList;

    public Employee() {
    }

    public Employee(Long id, String name, String phone, String email, String id_card, String address, LocalDate date_of_birth, double salary, Position position, Division division, EducationDegree educationDegree, User userName, User user, List<Contract> contractList) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.id_card = id_card;
        this.address = address;
        this.date_of_birth = date_of_birth;
        this.salary = salary;
        this.position = position;
        this.division = division;
        this.educationDegree = educationDegree;
        this.userName = userName;
        this.user = user;
        this.contractList = contractList;
    }

    public Employee(Long id, String name, String phone, String email, String id_card, String address, LocalDate date_of_birth, double salary, Position position, Division division, EducationDegree education_degree, User userName, User user) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.id_card = id_card;
        this.address = address;
        this.date_of_birth = date_of_birth;
        this.salary = salary;
        this.position = position;
        this.division = division;
        this.educationDegree = education_degree;
        this.userName = userName;
        this.user = user;
    }

    public Employee(Long id, String name, String phone, String email, String id_card, String address, LocalDate date_of_birth, double salary, Position position, Division division, EducationDegree education_degree, User userName) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.id_card = id_card;
        this.address = address;
        this.date_of_birth = date_of_birth;
        this.salary = salary;
        this.position = position;
        this.division = division;
        this.educationDegree = education_degree;
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree education_degree) {
        this.educationDegree = education_degree;
    }

    public User getUserName() {
        return userName;
    }

    public void setUserName(User userName) {
        this.userName = userName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }
}
