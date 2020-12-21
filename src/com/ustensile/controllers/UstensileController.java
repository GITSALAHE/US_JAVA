package com.ustensile.controllers;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;
import java.sql.Statement;
import com.ustensile.config.Config;
import java.sql.ResultSet;

public class UstensileController {
    
    Config configuration;
    Scanner scan;
    public UstensileController() {
        scan = new Scanner(System.in);
        configuration = new Config("jdbc:mysql://localhost/ustensile", "root", "");
    }

    public double calculValeur(int year, double valeur, String type){
        Date date = new Date();
        int years = date.getYear();
        int yearNow = years + 1900;
        int calculYear = yearNow - year;
        if(calculYear >= 50 && type == ""){
           valeur += calculYear - 50;
        }
        else if(calculYear >= 50 && type == "carre"){
            valeur += (calculYear - 50) * 5;
        }
        return valeur;
    }
    public void updateYear(String table, String type) throws SQLException{
        String sql = "SELECT * FROM "+table+""; // create the Sql query
        Statement stat = configuration.connected().createStatement(); // prepare statement
        ResultSet res = stat.executeQuery(sql);// excute the query after be prepared
        String leftAlignFormat = "| %-15s | %-15s |%n";

        System.out.format("    Modification Année de "+ type +" "+"%n");
        System.out.format("+-----------------+-----------------+%n");
        System.out.format("|      id         |      Année      |%n");
        System.out.format("+-----------------+-----------------+%n");

        while (res.next()) {
            System.out.format(leftAlignFormat, res.getInt("id"), res.getInt("year"));
        }
        System.out.format("+-----------------+-----------------+%n");

        System.out.println("entrer l'id de " + type);
        int id = scan.nextInt();
        System.out.println("entrer nouvelle année");
        int year = scan.nextInt();
        String sqlString = "UPDATE "+table+" SET year=?" + " WHERE id=?"; // create the Sql query
        java.sql.PreparedStatement stmt = configuration.connected().prepareStatement(sqlString);
        stmt.setInt(1, year);
        stmt.setInt(2, id);
        stmt.executeUpdate();
        System.out.println(type+" est modifier avec succes");
    }
}
