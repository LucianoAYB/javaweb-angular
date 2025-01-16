package org.example.entities;

import javax.persistence.*;

@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SUPPLIER")
    private Long idSupplier;

    @Column(name = "Supplier_name")
    private String supplierName;

    @Column(name = "EMAIL")
    private String email;

    public Supplier() {
    }

    public Supplier(Long idSupplier, String supplierName, String email) {
        this.supplierName = supplierName;
        this.email = email;
        this.idSupplier = idSupplier;
    }

    public Long getId() {
        return idSupplier;
    }

    public void setId(Long idSupplier) {
        this.idSupplier = idSupplier;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
