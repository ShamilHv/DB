package aze.coders.service;

import aze.coders.connection.DbConnection;
import aze.coders.entity.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientServiceImpl implements ClientService{
    @Override
    public Client getClientById(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Client client = null;

        try {
            conn = DbConnection.getConnection();
            String sql = "SELECT * FROM clients WHERE client_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                client = new Client();
                client.setClient_id(rs.getInt("client_id"));
                client.setClient_name(rs.getString("client_name"));
            }
        } catch (Exception e) {
            System.out.println("Error retrieving client by ID");
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                System.out.println("Error closing resources");
            }
        }
        return client;
    }

    @Override
    public List<Client> getAllClients() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Client> clients = new ArrayList<>();

        try {
            conn = DbConnection.getConnection();
            String sql = "SELECT * FROM clients";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Client client = new Client();
                client.setClient_id(rs.getInt("client_id"));
                client.setClient_name(rs.getString("client_name"));
                clients.add(client);
            }
        } catch (Exception e) {
            System.out.println("Error retrieving all clients");
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                System.out.println("Error closing resources");
            }
        }

        return clients;
    }

    @Override
    public void addClient(Client client) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DbConnection.getConnection();
            String sql = "INSERT INTO clients (client_name) VALUES (?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, client.getClient_name());
            pstmt.executeUpdate();
            System.out.println("Client added successfully");
        } catch (Exception e) {
            System.out.println("Error adding client");
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error closing resources");
            }
        }
    }

    @Override
        public void deleteClient(int client_id) {
            Connection conn = null;
            PreparedStatement pstmt = null;

            try {
                conn = DbConnection.getConnection();
                String sql = "DELETE FROM clients WHERE client_id = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, client_id);
                pstmt.executeUpdate();
                System.out.println("Client deleted successfully");
            } catch (SQLException e) {
                System.out.println("Error deleting client");
            } finally {
                try {
                    if (pstmt != null) pstmt.close();
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing resources: ");
                }
            }
        }

    @Override
    public void updateClientName(int id, String newName) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DbConnection.getConnection();
            String sql = "UPDATE clients SET client_name = ? WHERE client_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newName);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            System.out.println("Client name updated successfully");
        } catch (SQLException e) {
            System.out.println("Error updating client name");
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error closing resources");
            }
        }
    }
}
