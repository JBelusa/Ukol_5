package com.engeto.plants;

import javax.swing.*;
import java.time.LocalDate;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n------Testovací aplikace lekce 5");


        //Vytvoření seznamu rostlin
        PlantList testPlantList = loadPlants(chooseFile());


        System.out.println("\nVypsání načteného seznamu rostlin z textového souboru");


        //region Přidání dvou rostlin, odstranění jedné rostliny a uložení seznamu do nového souboru
        if (testPlantList != null) {
            testPlantList.printWateringInfo();

            Plant newPlant1 = null;
            try {
                newPlant1 = new Plant("Kaktus", "nedotýkat", LocalDate.of(2023, 12, 26), LocalDate.of(2023, 12, 26), 14);
                testPlantList.addPlant(newPlant1);
            } catch (PlantException e) {
                System.err.println("Informace o rostlině nebyly správně zadány: " + e.getLocalizedMessage());
            }

            Plant newPlant2 = null;
            try {
                newPlant2 = new Plant("Pampeliška", "žlutá", LocalDate.of(2018, 10, 1), LocalDate.of(2018, 10, 2), 1);
                testPlantList.addPlant(newPlant2);
            } catch (PlantException e) {
                System.err.println("Informace o rostlině nebyly správně zadány: " + e.getLocalizedMessage());
            }

            testPlantList.removeItem(2);

            savePlants(Settings.getDefaultSaveFileName(), testPlantList);

            System.out.println("\nTest načtení nově uloženého souboru po přidání dvou rostlin a odebrání jedné rostliny");
            PlantList newPlantList = loadPlants(Settings.getDefaultSaveFileName());
            newPlantList.printWateringInfo();

            //Seřazení listu dle názvu rostliny
            System.out.println("\nSeřazení listu dle názvu květiny");
            Collections.sort(newPlantList.getPlantsList());
            newPlantList.printWateringInfo();

            //Seřazení listu dle data zálivky
            System.out.println("\nSeřazení listu dle data zálivky");
            Collections.sort(newPlantList.getPlantsList(), new WateringDateComparator());
            newPlantList.printWateringInfo();
        }

        //endregion

    }

    private static String chooseFile() {
        String[] options = {"Správný seznam", "Špatné datum", "Špatná frekvence"};

        var name = JOptionPane.showOptionDialog(null, "Vyber soubor:", "Výběr čteného souboru", 0, 3, null, options, null);

        return switch (name) {
            case 0 -> Settings.getDefaultFileName();
            case 1 -> Settings.getTestWrongDate();
            case 2 -> Settings.getTestWrongFrequency();
            default -> null;
        };
    }

    //Metoda pro načtení seznamu rostlin ze souboru s požadovaným jménem
    private static PlantList loadPlants(String filename) {
        PlantList plantList = null;
        try {
            plantList = PlantList.loadFromFile(filename);

        } catch (PlantException e) {
            System.err.println("Chyba při čtění souboru. " + e.getLocalizedMessage());
        }

        return plantList;
    }

    //Metoda pro uložení seznamu rostlin do souboru s požadovaným jménem
    private static void savePlants(String filename, PlantList plantListToSave) {
        try {
            PlantList.saveToFile(filename, plantListToSave);
        } catch (PlantException e) {
            System.err.println("Chyba při ukládání souboru. " + e.getLocalizedMessage());
        }
    }


}