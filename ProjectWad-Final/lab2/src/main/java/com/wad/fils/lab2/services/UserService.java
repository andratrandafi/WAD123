package com.wad.fils.lab2.services;

import java.sql.*;


public class UserService {
  public boolean userExists(final String username) throws ClassNotFoundException, SQLException {

    String url = "jdbc:mysql://localhost:3306/wad21";
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection(url, "root",
            "root");
    Statement instr = con.createStatement();

    PreparedStatement getPersonFromUsername = null;
    String getPersonFromUsernameSQL = "SELECT username FROM persons WHERE username = ?";
    getPersonFromUsername = con.prepareStatement(getPersonFromUsernameSQL);
    getPersonFromUsername.setString(1,username);
    ResultSet rs = getPersonFromUsername.executeQuery();
    return rs.next();

  }
  public boolean emailExists(final String email) throws ClassNotFoundException, SQLException {

    String url = "jdbc:mysql://localhost:3306/wad21";
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection(url, "root",
            "root");
    Statement instr = con.createStatement();

    PreparedStatement getPersonFromUsername = null;
    String getPersonFromUsernameSQL = "SELECT username FROM persons WHERE email = ?";
    getPersonFromUsername = con.prepareStatement(getPersonFromUsernameSQL);
    getPersonFromUsername.setString(1,email);
    ResultSet rs = getPersonFromUsername.executeQuery();
    return rs.next();

  }
  public boolean UserVerification(final String username, final String password) throws ClassNotFoundException,SQLException{
    String url = "jdbc:mysql://localhost:3306/wad21";
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection(url, "root",
            "root");
    Statement instr = con.createStatement();

    PreparedStatement getPersonFromUsername = null;
    String getPersonFromUsernameSQL = "SELECT username FROM persons WHERE username = ? AND password = ?";
    getPersonFromUsername = con.prepareStatement(getPersonFromUsernameSQL);
    getPersonFromUsername.setString(1,username);
    getPersonFromUsername.setString(2,password);
    ResultSet rs = getPersonFromUsername.executeQuery();
    return rs.next();
  }
}
