package com.example.model;

import com.example.model.facility.AttachFacility;
import jakarta.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "attach_facility_id")
    private AttachFacility attachFacility;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;

    public ContractDetail() {
    }

    public ContractDetail(Long id, int quantity, AttachFacility attachFacility, Contract contract) {
        this.id = id;
        this.quantity = quantity;
        this.attachFacility = attachFacility;
        this.contract = contract;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
