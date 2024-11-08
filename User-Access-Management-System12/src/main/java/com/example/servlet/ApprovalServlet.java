package com.example.servlet;

import com.example.model.*;
import util.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/approveRequest")
public class ApprovalServlet extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        String sql = "SELECT * FROM requests WHERE status = 'Pending'";

        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            List<Request> pendingRequests = new ArrayList<>();
            
            while (resultSet.next()) {
                
                Request req = new Request();
                req.setId(resultSet.getInt("id"));
                req.setUserId(resultSet.getInt("user_id"));
                req.setSoftwareId(resultSet.getInt("software_id"));
                req.setAccessType(resultSet.getString("access_type"));
                req.setReason(resultSet.getString("reason"));
                req.setStatus(resultSet.getString("status"));

                
                pendingRequests.add(req);
            }

            
            request.setAttribute("pendingRequests", pendingRequests);

            
            request.getRequestDispatcher("pendingRequests.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("Error fetching requests: " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int requestId = Integer.parseInt(request.getParameter("requestId"));
        String action = request.getParameter("action");  

        
        String newStatus = "Rejected";
        if ("approve".equals(action)) {
            newStatus = "Approved";
        }

      
        String sql = "UPDATE requests SET status = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, newStatus);
            statement.setInt(2, requestId);

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                response.sendRedirect("approveRequest"); 
            } else {
                response.getWriter().write("Error updating request status.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("Database error: " + e.getMessage());
        }
    }
}
