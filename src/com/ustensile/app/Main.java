package com.ustensile.app;
import java.sql.SQLException;
import java.util.Scanner;

import com.ustensile.controllers.AssieteCarreController;
import com.ustensile.controllers.AssieteRondeController;
import com.ustensile.controllers.CuillereController;
import com.ustensile.controllers.UstensileController;

public class Main {
    public static void main(String[] args) throws SQLException {
        CuillereController cuillere = new CuillereController();
        AssieteRondeController assieteRondeController = new AssieteRondeController();
        AssieteCarreController assieteCarreController = new AssieteCarreController();
        UstensileController us = new UstensileController();
        Scanner scan = new Scanner(System.in);
        Boolean out = true;
        Boolean back = true;
        while (out) {
            System.out.println("1\t cuiller");
            System.out.println("2\t assiette");
            System.out.println("3\t Exit");
            System.out.println("\nPlease put your choice :");
            int input1 = scan.nextInt();
            switch (input1) {
                case 1:

                    while (back) {
                        System.out.println("1\t ajouter une cuiller");
                        System.out.println("2\t afficher nombre cuiller");
                        System.out.println("3\t afficher les cuiller");
                        System.out.println("4\t modifier l'année");
                        System.out.println("5\t Retour");
                        System.out.println("\nPlease put your choice :");
                        int input2 = scan.nextInt();
                        switch (input2) {
                            case 1:
                                cuillere.ajouterCuiller();
                                break;
                            case 2:
                                cuillere.afficheNombre();
                                break;
                            case 3:
                                cuillere.afficher();
                                break;
                            case 4:
                                us.updateYear("cuillere", "cuillere");
                            break;
                            case 5:
                                back = false;
                                break;
                            default:
                                System.out.println("Oups une erreur est trouvé");
                                break;
                        }
                    }
                    break;
                case 2:
                    Boolean back2 = true;
                    while (back2) {
                        System.out.println("1\t ajouter une Assiette Ronde");
                        System.out.println("2\t ajouter une Assiette Carree");
                        System.out.println("3\t afficher les Assiettes");
                        System.out.println("4\t modifier l'année d'une assiette Ronde");
                        System.out.println("5\t modifier l'année d'une assiette Carre");
                        System.out.println("6\t Retour");
                        System.out.println("\nPlease put your choice :");
                        int input3 = scan.nextInt();
                        switch (input3) {
                            case 1:
                                assieteRondeController.addAssietteRonde();
                                break;
                            case 2:
                                assieteCarreController.addAssietteCarre();
                            break;
                            case 3:
                                assieteRondeController.afficheAssietteRonde();
                                assieteCarreController.afficheAssietteCarre();
                            break;
                            case 4:
                                us.updateYear("assietteronde", "assiette ronde");
                            break;
                            case 5: 
                                us.updateYear("assiettecarree", "assiette carre");
                                break;
                            case 6:
                                back2 = false;
                            break;
                            default:
                                break;
                        }
                    }
                    break;
                case 3:
                System.out.println("********************* Exit *********************");
                System.out.println("*************** BY GITSALAH ********************");
                System.exit(0);
                break;
                default:
                    break;
            }
        }
        scan.close();
    }
}
