package com.ustensile.controllers;
import com.ustensile.models.AssietteCarre;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.SQLException;
import java.sql.ResultSet;

public class AssieteCarreController {
    
    AssietteCarre assietteCarre;
    Scanner scan;
    UstensileController us;

    public AssieteCarreController() {
      assietteCarre = new AssietteCarre();
      scan = new Scanner(System.in);
      us = new UstensileController();
    }
    
    public void addAssietteCarre() throws SQLException{
        System.out.println("Année de production");
        assietteCarre.setYear(scan.nextInt());
        System.out.println("Prix initial");
        assietteCarre.setValeur(scan.nextDouble());
        System.out.println("Cote d'assiette");
        assietteCarre.setCote(scan.nextInt());
        String sqlString = "INSERT INTO assiettecarree (year, valeur, cote)" + " VALUES(?,?,?)";
        java.sql.PreparedStatement stmt = us.configuration.connected().prepareStatement(sqlString,
                Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1, assietteCarre.getYear());
        stmt.setDouble(2, assietteCarre.getValeur());
        stmt.setInt(3, assietteCarre.getCote());
        stmt.executeUpdate();
        System.out.println("Assiette carre ajouter avec success");
    }
    public int calculSurfaceCarre(int cote) {
        int surface = (int) Math.pow(cote, 2.0);
        return surface;
    }

    public void afficheAssietteCarre() throws SQLException{
        String sqlString = "SELECT * FROM assiettecarree"; // create the Sql query
        Statement stmt = us.configuration.connected().createStatement(); // prepare statement
        ResultSet res = stmt.executeQuery(sqlString);// excute the query after be prepared
        String leftAlignFormat = "| %-15s | %-15s | %-15s | %-15s |%n";

        System.out.format("+-----------------+--------GESTION ASSIETTE RONDE-----+-----------------+%n");
        System.out.format("|      id         |      Année      |      Valeur     |      Surface    |%n");
        System.out.format("+-----------------+-----------------+-----------------+-----------------+%n");

        while (res.next()) {
            System.out.format(leftAlignFormat, res.getInt("id"), res.getInt("year"), us.calculValeur(res.getInt("year"), res.getDouble("valeur"), "carre"), calculSurfaceCarre(res.getInt("cote")));
        }
        System.out.format("+-----------------+-----------------+-----------------+-----------------+%n");
        
    }



}
