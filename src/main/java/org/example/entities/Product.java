package org.example.entities;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUCT")
    private Long idP;

    @ManyToOne
    @JoinColumn(name = "ID_SUPPLIER", nullable = false)
    private Supplier supplier;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "PRODUCT_VALUE")
    private String productValue;


    public Product() {
    }

    public Product(Long idP, String supplierName, String productName, String productValue) {
        this.idP = idP;
        this.supplier = supplier;
        this.productName = productName;
        this.productValue = productValue;
    }

    public Long getId() {
        return idP;
    }

    public void setId(Long idP) {
        this.idP = idP;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductValue() {
        return productValue;
    }

    public void setProductValue(String productValue) {
        this.productValue = productValue;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
