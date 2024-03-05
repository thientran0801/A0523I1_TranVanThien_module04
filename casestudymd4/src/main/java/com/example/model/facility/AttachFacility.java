package com.example.model.facility;

import com.example.model.ContractDetail;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class AttachFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name, unit, status;
    private double cost;
    @OneToMany(mappedBy = "attachFacility", cascade = CascadeType.ALL)
    private List<ContractDetail> contractDetailList;

    public AttachFacility() {
    }

    public AttachFacility(Long id, String name, String unit, String status, double cost, List<ContractDetail> contractDetailList) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.status = status;
        this.cost = cost;
        this.contractDetailList = contractDetailList;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public List<ContractDetail> getContractDetailList() {
        return contractDetailList;
    }

    public void setContractDetailList(List<ContractDetail> contractDetailList) {
        this.contractDetailList = contractDetailList;
    }
}
