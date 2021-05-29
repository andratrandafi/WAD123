package com.wad.fils.lab2.controllers;


import com.wad.fils.lab2.services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Enumeration;

@WebServlet(name = "RegistrationController", value = "/RegistrationController")
public class RegistrationController extends HttpServlet {
  private final UserService userService = new UserService();

  public static String getHash(String password) {
    MessageDigest digest=null;
    try {
      digest = MessageDigest.getInstance("SHA-1");
    } catch (NoSuchAlgorithmException ex) {
      ex.printStackTrace();
    }
    digest.reset();
    try {
      digest.update(password.getBytes("UTF-8"));
    } catch (UnsupportedEncodingException ex) {
      ex.printStackTrace();
    }
    return new BigInteger(1, digest.digest()).toString(16);
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("Registration Controller post method");
    response.setContentType("text/html;charset=UTF-8");

    String username = request.getParameter("username");
    String name = request.getParameter("name");
    String password = request.getParameter("password");
    String email = request.getParameter("email");
    String gender = request.getParameter("gender");
    String tel = request.getParameter("tel");
    String country = request.getParameter("country");
    try (PrintWriter out = response.getWriter()) {
      if(username==""||name==""||password==""||email==""||tel=="")
      {
        out.println("You need to complete all the fields");
        request.getRequestDispatcher("register.html").include(request,response);
      }
   else if(userService.userExists(username) == true)
      {
        out.println("User "+username+" already exists");
        request.getRequestDispatcher("register.html").include(request,response);

      }
      else if(userService.emailExists(email) == true)
      {
        out.println("This email is already used");
        request.getRequestDispatcher("register.html").include(request,response);

      }
      else {

        String url = "jdbc:mysql://localhost:3306/wad21";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, "root",
                "root");


        PreparedStatement insertPerson = null;
        String insertPersonSQL = "INSERT INTO persons(username,password,tel,name,email,country,gender) values (?,?,?,?,?,?,?)";
        insertPerson = con.prepareStatement(insertPersonSQL);
        insertPerson.setString(1,username);
        insertPerson.setString(2,getHash(password));
        insertPerson.setString(4,name);
        insertPerson.setString(5,email);
        insertPerson.setString(3,tel);
        insertPerson.setString(6,country);
        insertPerson.setString(7,gender);
        insertPerson.executeUpdate();
        request.getRequestDispatcher("login.html").include(request,response);
      }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  }

