package com.ustensile.controllers;

import com.ustensile.models.Cuillere;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CuillereController {

    Cuillere cuillere;
    Scanner scan;
    UstensileController us;

    public CuillereController() {
        us = new UstensileController();
        scan = new Scanner(System.in);
        cuillere = new Cuillere();
    }

    public void ajouterCuiller() throws SQLException {
        System.out.println("Année de production");
        cuillere.setYear(scan.nextInt());
        System.out.println("Prix initial");
        cuillere.setValeur(scan.nextDouble());
        System.out.println("Longeur de cuillere");
        cuillere.setLongueur(scan.nextDouble());
        String sqlString = "INSERT INTO cuillere (year, valeur, longeur)" + " VALUES(?,?,?)";
        java.sql.PreparedStatement stmt = us.configuration.connected().prepareStatement(sqlString,
                Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1, cuillere.getYear());
        stmt.setDouble(2, cuillere.getValeur());
        stmt.setDouble(3, cuillere.getLongueur());
        stmt.executeUpdate();
        System.out.println("Cuillere ajouter avec success");
    }

    public int calculerNombre() throws SQLException {
        String sqlString = "SELECT * FROM cuillere"; // create the Sql query
        Statement stmt = us.configuration.connected().createStatement(); // prepare statement
        ResultSet res = stmt.executeQuery(sqlString);// excute the query after be prepared
        int i = 0;
        while (res.next()) {
            res.getInt("id");
            i++;
        }
        return i;
    }
    
    public void afficheNombre() throws SQLException {
        System.out.println("Nombre cuillere : " + calculerNombre());
    }
    
    public void afficher() throws SQLException{
        String sqlString = "SELECT * FROM cuillere"; // create the Sql query
        Statement stmt = us.configuration.connected().createStatement(); // prepare statement
        ResultSet res = stmt.executeQuery(sqlString);// excute the query after be prepared
        String leftAlignFormat = "| %-15s | %-15s | %-15s | %-15s |%n";

        System.out.format("+-----------------+--------------GESTION CUILLERE-----------------------+%n");
        System.out.format("|      id         |      Année      |      Valeur     |      Longeur    |%n");
        System.out.format("+-----------------+-----------------+-----------------+-----------------+%n");


        while (res.next()) {
            System.out.format(leftAlignFormat, res.getInt("id"), res.getInt("year"), us.calculValeur(res.getInt("year"), res.getDouble("valeur"), ""), res.getDouble("longeur"));
        }
        System.out.format("+-----------------+-----------------+-----------------+-----------------+%n");

    }
}
