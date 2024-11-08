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
import java.sql.SQLException;

@WebServlet("/requestAccess")
public class RequestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
        String softwareId = request.getParameter("softwareId"); 
        String accessType = request.getParameter("accessType"); 
        String reason = request.getParameter("reason"); 

        
        int userId = (Integer) request.getSession().getAttribute("userId");

       
        Request accessRequest = new Request();
        accessRequest.setUserId(userId);
        accessRequest.setSoftwareId(Integer.parseInt(softwareId)); 
        accessRequest.setAccessType(accessType);
        accessRequest.setReason(reason);
        accessRequest.setStatus("Pending"); 


        String sql = "INSERT INTO requests (user_id, software_id, access_type, reason, status) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection()) {
           
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, accessRequest.getUserId());
            statement.setInt(2, accessRequest.getSoftwareId());
            statement.setString(3, accessRequest.getAccessType());
            statement.setString(4, accessRequest.getReason());
            statement.setString(5, accessRequest.getStatus());

           
            int result = statement.executeUpdate();

            
            if (result > 0) {

                response.sendRedirect("requestConfirmation.jsp"); 
            } else {
                response.getWriter().write("Error: Could not submit access request.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("Database error: " + e.getMessage());
        }
    }
}
