package com.product.DAO;

import com.guides.usermanagement.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ProductDAO.java
 * This DAO class provides CRUD database operations for the "produits" table in the "stockmanager" database.
 */
public class ProductDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/stockmanager?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "salmane@1013";

    private static final String INSERT_PRODUCT_SQL = "INSERT INTO produits (name, description, unitPrice, productQuantity, categorie) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_PRODUCT_BY_ID = "SELECT id, name, description, unitPrice, productQuantity, categorie FROM produits WHERE id = ?";
    private static final String SELECT_ALL_PRODUCTS = "SELECT * FROM produits";
    private static final String DELETE_PRODUCT_SQL = "DELETE FROM produits WHERE id = ?";
    private static final String UPDATE_PRODUCT_SQL = "UPDATE produits SET name = ?, description = ?, unitPrice = ?, productQuantity = ?, categorie = ? WHERE id = ?";

    public ProductDAO() {}

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Updated for MySQL 8+
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // CREATE
    public void insertProduct(Product product) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setInt(3, product.getUnitPrice());
            preparedStatement.setInt(4, product.getProductQuantity());
            preparedStatement.setString(5, product.getCategorie());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ - Get Product By ID
    public Product selectProduct(int id) {
        Product product = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                int unitPrice = rs.getInt("unitPrice");
                int productQuantity = rs.getInt("productQuantity");
                String categorie = rs.getString("categorie");

                product = new Product(id, name, description, productQuantity, unitPrice, categorie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    // READ - Get All Products
    public List<Product> selectAllProducts() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                int unitPrice = rs.getInt("unitPrice");
                int productQuantity = rs.getInt("productQuantity");
                String categorie = rs.getString("categorie");

                products.add(new Product(id, name, description, productQuantity, unitPrice, categorie));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    // UPDATE
    public boolean updateProduct(Product product) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_SQL)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setInt(3, product.getUnitPrice());
            preparedStatement.setInt(4, product.getProductQuantity());
            preparedStatement.setString(5, product.getCategorie());
            preparedStatement.setInt(6, product.getId());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    // DELETE
    public boolean deleteProduct(int id) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_SQL)) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }
}
