package com.wad.fils.lab2.controllers;

import com.wad.fils.lab2.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name="IndexController" , value="/IndexController")
public class IndexController  extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("INDEX Controller post method");
        response.setContentType("text/html;charset=UTF-8");

        String moldoveanu = request.getParameter("comments1");
        String negoiu = request.getParameter("comments2");
        String vistea = request.getParameter("comments3");
        String parang = request.getParameter("comments4");
        String lespezi = request.getParameter("comments5");
        String omu = request.getParameter("comments6");
        String peleaga = request.getParameter("comments7");
        try (PrintWriter out = response.getWriter()) {
            if(moldoveanu != null && moldoveanu.length() != 0) {
                String url = "jdbc:mysql://localhost:3306/moldoveanu";
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "root",
                        "root");


                PreparedStatement insertReview = null;
                String insertReviewSQL = "INSERT INTO review(REVIEW) values (?)";
                insertReview = con.prepareStatement(insertReviewSQL);
                insertReview.setString(1,moldoveanu);
                insertReview.executeUpdate();

                out.println("Thank you for the review!");
                request.getRequestDispatcher("1.html").include(request, response);
            }

            else if(negoiu != null && negoiu.length() != 0) {
                String url = "jdbc:mysql://localhost:3306/negoiu";
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "root",
                        "root");


                PreparedStatement insertReview = null;
                String insertReviewSQL = "INSERT INTO review(REVIEW) values (?)";
                insertReview = con.prepareStatement(insertReviewSQL);
                insertReview.setString(1,negoiu);
                insertReview.executeUpdate();

                out.println("Thank you for the review!");
                request.getRequestDispatcher("2.html").include(request, response);
            }
            else if(vistea != null && vistea.length() != 0) {
                String url = "jdbc:mysql://localhost:3306/vistea";
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "root",
                        "root");


                PreparedStatement insertReview = null;
                String insertReviewSQL = "INSERT INTO review(REVIEW) values (?)";
                insertReview = con.prepareStatement(insertReviewSQL);
                insertReview.setString(1,vistea);
                insertReview.executeUpdate();

                out.println("Thank you for the review!");
                request.getRequestDispatcher("3.html").include(request, response);
            }
            else if(parang != null && parang.length() != 0) {
                String url = "jdbc:mysql://localhost:3306/parang";
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "root",
                        "root");


                PreparedStatement insertReview = null;
                String insertReviewSQL = "INSERT INTO review(REVIEW) values (?)";
                insertReview = con.prepareStatement(insertReviewSQL);
                insertReview.setString(1,parang);
                insertReview.executeUpdate();

                out.println("Thank you for the review!");
                request.getRequestDispatcher("4.html").include(request, response);
            }
            else if(lespezi != null && lespezi.length() != 0) {
                String url = "jdbc:mysql://localhost:3306/lespezi";
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "root",
                        "root");


                PreparedStatement insertReview = null;
                String insertReviewSQL = "INSERT INTO review(REVIEW) values (?)";
                insertReview = con.prepareStatement(insertReviewSQL);
                insertReview.setString(1,lespezi);
                insertReview.executeUpdate();

                out.println("Thank you for the review!");
                request.getRequestDispatcher("5.html").include(request, response);
            }
            else if(omu != null && omu.length() != 0) {
                String url = "jdbc:mysql://localhost:3306/omu";
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "root",
                        "root");


                PreparedStatement insertReview = null;
                String insertReviewSQL = "INSERT INTO review(REVIEW) values (?)";
                insertReview = con.prepareStatement(insertReviewSQL);
                insertReview.setString(1,omu);
                insertReview.executeUpdate();

                out.println("Thank you for the review!");
                request.getRequestDispatcher("6.html").include(request, response);
            }
            else if(peleaga != null && peleaga.length() != 0) {
                String url = "jdbc:mysql://localhost:3306/peleaga";
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, "root",
                        "root");


                PreparedStatement insertReview = null;
                String insertReviewSQL = "INSERT INTO review(REVIEW) values (?)";
                insertReview = con.prepareStatement(insertReviewSQL);
                insertReview.setString(1,peleaga);
                insertReview.executeUpdate();

                out.println("Thank you for the review!");
                request.getRequestDispatcher("7.html").include(request, response);
            }
            else {
                request.getRequestDispatcher("index.html").include(request, response);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



    }

