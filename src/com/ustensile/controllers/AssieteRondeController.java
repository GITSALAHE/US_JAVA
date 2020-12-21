package com.ustensile.controllers;
import com.ustensile.models.AssietteRonde;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.SQLException;
import java.sql.ResultSet;

public class AssieteRondeController {
    AssietteRonde assietteRonde;
    Scanner scan;
    UstensileController us;
    public AssieteRondeController() {
        assietteRonde = new AssietteRonde();
        us = new UstensileController();
        scan = new Scanner(System.in);
    }

    public void addAssietteRonde() throws SQLException{
        System.out.println("Année de production");
        assietteRonde.setYear(scan.nextInt());
        System.out.println("Prix initial");
        assietteRonde.setValeur(scan.nextDouble());
        System.out.println("Rayon d'assiette");
        assietteRonde.setRayon(scan.nextDouble());
        String sqlString = "INSERT INTO assietteronde (year, rayon, valeur)" + " VALUES(?,?,?)";
        java.sql.PreparedStatement stmt = us.configuration.connected().prepareStatement(sqlString,
                Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1, assietteRonde.getYear());
        stmt.setDouble(2, assietteRonde.getRayon());
        stmt.setDouble(3, assietteRonde.getValeur());
        stmt.executeUpdate();
        System.out.println("Assiette ronde ajouter avec success");
    }
    
    public double calculSurfaceRonde(double rayon) {
        double surface = 3.14 * rayon * rayon;
        return surface;
    }

    public void afficheAssietteRonde() throws SQLException{
        String sqlString = "SELECT * FROM assietteronde"; // create the Sql query
        Statement stmt = us.configuration.connected().createStatement(); // prepare statement
        ResultSet res = stmt.executeQuery(sqlString);// excute the query after be prepared
        String leftAlignFormat = "| %-15s | %-15s | %-15s | %-15s |%n";

        System.out.format("+-----------------+--------GESTION ASSIETTE RONDE-----+-----------------+%n");
        System.out.format("|      id         |      Année      |      Valeur     |      Surface    |%n");
        System.out.format("+-----------------+-----------------+-----------------+-----------------+%n");

        while (res.next()) {
            System.out.format(leftAlignFormat, res.getInt("id"), res.getInt("year"), us.calculValeur(res.getInt("year"), res.getDouble("valeur"), ""), calculSurfaceRonde(res.getDouble("rayon")));
        }
        System.out.format("+-----------------+-----------------+-----------------+-----------------+%n");

    }
    
    
}
