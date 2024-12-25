package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.InventoryItem;
import dao.baseDAO;

public class adminDAO {

    private static final Logger LOGGER = Logger.getLogger(adminDAO.class.getName());
    public List<InventoryItem> getAllInventoryItems() {
        List<InventoryItem> items = new ArrayList<>();
        String query = "SELECT * FROM inventory";

        try (Connection conn = baseDAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                InventoryItem item = new InventoryItem();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setType(rs.getString("type"));
                item.setStock(rs.getInt("stock"));
                item.setStatus(rs.getString("status"));
                item.setDateAdded(rs.getDate("date_added"));
                items.add(item);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving inventory items", e);
        }
        return items;
    }

    public void addInventoryItem(InventoryItem item) {
        String query = "INSERT INTO inventory (name, type, stock, status, date_added) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = baseDAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, item.getName());
            stmt.setString(2, item.getType());
            stmt.setInt(3, item.getStock());
            stmt.setString(4, item.getStatus());
            stmt.setDate(5, new java.sql.Date(item.getDateAdded().getTime()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error adding inventory item", e);
        }
    }

    public void updateInventoryItem(InventoryItem item) {
        String query = "UPDATE inventory SET name = ?, type = ?, stock = ?, status = ? WHERE id = ?";

        try (Connection conn = baseDAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, item.getName());
            stmt.setString(2, item.getType());
            stmt.setInt(3, item.getStock());
            stmt.setString(4, item.getStatus());
            stmt.setInt(5, item.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error updating inventory item", e);
        }
    }

    public void deleteInventoryItem(int id) {
        String query = "DELETE FROM inventory WHERE id = ?";

        try (Connection conn = baseDAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error deleting inventory item", e);
        }
    }

}
