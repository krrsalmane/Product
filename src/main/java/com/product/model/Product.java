
package com.product.model;

public class Product {
	private int id;
	private String name;
	private String description;
	private int productQuantity;
	private int unitPrice;
	private String categorie;
	


public Product() {
}

// All-Args Constructor
public Product(String name, String description, int productQuantity, int unitPrice, String categorie) {
    this.name = name;
    this.description = description;
    this.productQuantity = productQuantity;
    this.unitPrice = unitPrice;
    this.categorie = categorie;
}
public Product(int id ,String name, String description, int productQuantity, int unitPrice, String categorie) {
    this.id=id;
	this.name = name;
    this.description = description;
    this.productQuantity = productQuantity;
    this.unitPrice = unitPrice;
    this.categorie = categorie;
}

// Getters and Setters
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

public String getDescription() {
    return description;
}

public void setDescription(String description) {
    this.description = description;
}

public int getProductQuantity() {
    return productQuantity;
}

public void setProductQuantity(int productQuantity) {
    this.productQuantity = productQuantity;
}

public int getUnitPrice() {
    return unitPrice;
}

public void setUnitPrice(int unitPrice) {
    this.unitPrice = unitPrice;
}

public String getCategorie() {
    return categorie;
}

public void setCategorie(String categorie) {
    this.categorie = categorie;
}}
