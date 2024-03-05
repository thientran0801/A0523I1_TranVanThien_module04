package com.example.model.facility;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;

    @OneToMany(mappedBy = "rentType", cascade = CascadeType.ALL)
    private List<Facility> facilityList;

    public RentType() {
    }

    public RentType(Long id, String type, List<Facility> facilityList) {
        this.id = id;
        this.type = type;
        this.facilityList = facilityList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Facility> getFacilityList() {
        return facilityList;
    }

    public void setFacilityList(List<Facility> facilityList) {
        this.facilityList = facilityList;
    }
}
