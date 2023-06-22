package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Brand;
import entity.Console;
import entity.Product;


public class ProductDAO {
    private Connection connection;

    public ProductDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Product> findAll() throws SQLException {
        List<Product> products = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.prepareStatement("SELECT product.id, product.name, product.price, product.description, product.amount, product.tag, product.type, product.image, brand.id, brand.name, console.id, console.name, console.description FROM product INNER JOIN brand ON product.brand_id = brand.id LEFT JOIN console ON product.console_id = console.id");
            rs = stmt.executeQuery();
            while (rs.next()) {
                int productId = rs.getInt("id");
                String productName = rs.getString("name");
                double productPrice = rs.getDouble("price");
                String productDescription = rs.getString("description");
                int productAmount = rs.getInt("amount");
                String productTag = rs.getString("tag");
                String productType = rs.getString("type");
                String productImage = rs.getString("image");

                Brand brand = new Brand(rs.getInt("brand_id"), rs.getString("brand_name"));
                Console console = null;
                int consoleId = rs.getInt("console_id");
                if (consoleId != 0) {
                    console = new Console(consoleId, rs.getString("console_name"), brand);
                }

                Product product = new Product(productId, productName, productPrice, productDescription, brand, console, productAmount, productTag, productType, productImage);
                products.add(product);
            }
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    
    public void addProduct(Product product) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("INSERT INTO product (name, price, description, brand_id, console_id, type, amount, tag, image) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPrice());
            stmt.setString(3, product.getDescription());
            stmt.setInt(4, product.getBrand().getId());
            stmt.setInt(5, product.getConsole().getId());
            stmt.setString(6, product.getType());
            stmt.setInt(7, product.getAmount());
            stmt.setString(8, product.getTag());
            stmt.setString(9, product.getImage());
            stmt.executeUpdate();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

}
