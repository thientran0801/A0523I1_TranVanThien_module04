package com.example.model.facility;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name, standard_room, facility_free;
    private double area, cost, pool_area;
    private int max_people, number_of_floors;
    @Column(columnDefinition = "LONGTEXT")
    private String description_other_convenience;

    @ManyToOne
    @JoinColumn(name = "rent_type_id")
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "facility_type_id")
    private FacilityType facilityType;

    @OneToMany(mappedBy = "facility", cascade = CascadeType.ALL)
    private List<Facility> facilityList;

    public Facility() {
    }

    public Facility(Long id, String name, String standard_room, String facility_free, double area, double cost, double pool_area, int max_people, int number_of_floors, String description_other_convenience, RentType rentType, FacilityType facilityType, List<Facility> facilityList) {
        this.id = id;
        this.name = name;
        this.standard_room = standard_room;
        this.facility_free = facility_free;
        this.area = area;
        this.cost = cost;
        this.pool_area = pool_area;
        this.max_people = max_people;
        this.number_of_floors = number_of_floors;
        this.description_other_convenience = description_other_convenience;
        this.rentType = rentType;
        this.facilityType = facilityType;
        this.facilityList = facilityList;
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

    public String getStandard_room() {
        return standard_room;
    }

    public void setStandard_room(String standard_room) {
        this.standard_room = standard_room;
    }

    public String getFacility_free() {
        return facility_free;
    }

    public void setFacility_free(String facility_free) {
        this.facility_free = facility_free;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getPool_area() {
        return pool_area;
    }

    public void setPool_area(double pool_area) {
        this.pool_area = pool_area;
    }

    public int getMax_people() {
        return max_people;
    }

    public void setMax_people(int max_people) {
        this.max_people = max_people;
    }

    public int getNumber_of_floors() {
        return number_of_floors;
    }

    public void setNumber_of_floors(int number_of_floors) {
        this.number_of_floors = number_of_floors;
    }

    public String getDescription_other_convenience() {
        return description_other_convenience;
    }

    public void setDescription_other_convenience(String description_other_convenience) {
        this.description_other_convenience = description_other_convenience;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public List<Facility> getFacilityList() {
        return facilityList;
    }

    public void setFacilityList(List<Facility> facilityList) {
        this.facilityList = facilityList;
    }
}
