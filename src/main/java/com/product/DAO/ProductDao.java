package com.product.DAO;

public class ProductDao {


//creation des variables pour la connexion
private String jdbcUrl = "jdbc:mysql://localhost:3306/stockmanager?useSSL=false";
private String jdbcUserName= "root";
private String jdbcPassWord ="salmane@1013";


 private static final String INSERT_PRODUITS_SQL = "INSERT INTO produits" + "  (name, description, unitPrice, productQuantity, categorie) VALUES " +
            " (?, ?, ?, ?, ?);";

        private static final String SELECT_PRODUITS_BY_ID = "select id,name,description,unitPrice,productQuantity,categorie from product where id =?";
        private static final String SELECT_ALL_PRODUITS = "select * from product";
        private static final String DELETE_PRODUITS_SQL = "delete from product where id = ?;";
        private static final String UPDATE_PRODUITS_SQL = "update product set name = ?,description= ?, unitPrice = ?,productQuantity = ?,categorie = ? where id = ?;";


      