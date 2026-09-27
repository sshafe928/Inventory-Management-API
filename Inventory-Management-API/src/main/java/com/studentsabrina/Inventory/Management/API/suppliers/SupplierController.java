package com.studentsabrina.Inventory.Management.API.suppliers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/api/supplier")
public class SupplierController {

    private SupplierRepository supplierRepository;

    public SupplierController(SupplierRepository supplierRepository){
        this.supplierRepository = supplierRepository;
    }
    
    //Get all Suppliers
    @GetMapping 
    public List<Supplier> getAllSuppliers(){
        return supplierRepository.findAll();
    }

    //Get a specific supplier
    @GetMapping("/{id}")
    public Supplier getSupplierByID(@PathVariable int id){
        return supplierRepository.findById((long) id).orElse(null);
    }

    //post a supplier
    @PostMapping 
    public Supplier createSupplier(@RequestBody Supplier supplier){
        return supplierRepository.save(supplier);
    }

    //delete a supplier
    @DeleteMapping("/{id}")
    public void deleteSupplier(@PathVariable int id){
        supplierRepository.deleteById((long) id);
    }

    

}
