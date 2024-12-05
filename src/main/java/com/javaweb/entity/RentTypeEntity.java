package com.javaweb.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "renttype")
public class RentTypeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rentTypeID; 
	
	@Column(name = "rentTypeName", unique = true)
    private String rentTypeName;
	
	@Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "rentTypeID")
    private List<DetailRentTypeEntity> listDetailRT = new ArrayList<DetailRentTypeEntity>();

	@OneToMany(mappedBy = "rentTypeID")
	private List<InvoiceEntity> listInvoice = new ArrayList<InvoiceEntity>();

    //////////////////////////////////////////////////////////////////////////////////

    
	public int getRentTypeID() {
		return rentTypeID;
	}

	public void setRentTypeID(int rentTypeID) {
		this.rentTypeID = rentTypeID;
	}

	public String getRentTypeName() {
		return rentTypeName;
	}

	public void setRentTypeName(String rentTypeName) {
		this.rentTypeName = rentTypeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<DetailRentTypeEntity> getListDetailRT() {
		return listDetailRT;
	}

	public void setListDetailRT(List<DetailRentTypeEntity> listDetailRT) {
		this.listDetailRT = listDetailRT;
	}

	public List<InvoiceEntity> getListInvoice() {
		return listInvoice;
	}

	public void setListInvoice(List<InvoiceEntity> listInvoice) {
		this.listInvoice = listInvoice;
	}
}
