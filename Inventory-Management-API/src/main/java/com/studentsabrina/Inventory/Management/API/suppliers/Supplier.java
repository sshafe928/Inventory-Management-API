package com.studentsabrina.Inventory.Management.API.suppliers;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "suppliers")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String phone;

    private String contact;


    public Supplier(){
    }


    public Supplier(String name, String phone, String contact){
            this.name = name;
            this.phone = phone;
            this.contact = contact;
        }


    public int getId() {
    return id;
}

    


    public void setId(int id) {
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

    public String getContact() {
    return contact;
}

    public void setContact(String contact) {
    this.contact = contact;
}
}