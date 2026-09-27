package com.studentsabrina.Inventory.Management.API.products;

import java.math.BigDecimal;

import com.studentsabrina.Inventory.Management.API.suppliers.Supplier;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal price;

    @Column(unique = true)
    @NotBlank
    @Pattern(regexp = "^6\\d{5}$")
    private String sku;

    private Integer amount;

    private String category;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;


    public Product(){
    }

    public Product(Long id, String name, String sku, BigDecimal price, Integer amount, String category, Supplier supplier){
        this.id = id;
        this.name = name;
        this.sku = sku;
        this.price = price;
        this.amount = amount;
        this.category = category;
        this.supplier = supplier;
    }

    public Product(String name, String sku, BigDecimal price, Integer amount, String category, Supplier supplier){
        this.name = name;
        this.sku = sku;
        this.price = price;
        this.amount = amount;
        this.category = category;
        this.supplier = supplier;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getSku(){
        return sku;
    }

    public void setSku(String sku){
        this.sku = sku;
    }

    public BigDecimal getPrice(){
        return price;
    }

    public void setPrice(BigDecimal price){
        this.price = price;
    }

    public Integer getAmount(){
        return amount;
    }

    public void setAmount(Integer amount){
        this.amount = amount;
    }

    public String getCategory(){
        return category;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public Supplier getSupplier(){
        return supplier;
    }

    public void setSupplier(Supplier supplier ){
        this.supplier = supplier;
    }





    @Override 
    public String toString(){
        return "Product{" + " id= " + id + " name= " + name + " sku= " + sku + " price= " + price + " amount= " + amount + " category= " + category + " supplier= " + supplier + "}";
    }





}
