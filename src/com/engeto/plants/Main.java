package com.engeto.plants;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {


        PlantList testPlantList = loadPlants();


        if (testPlantList != null) {
        Plant newPlant1 = null;
        try {
            newPlant1 = new Plant("Kaktus", "nedotýkat", LocalDate.of(2023, 12, 26), LocalDate.of(2023, 12, 26), 14);
            testPlantList.addPlant(newPlant1);
        } catch (PlantException e) {
            System.err.println("Informace o kytce nebyly správně zadány: " + e.getLocalizedMessage());
        }

        Plant newPlant2 = null;
        try {
            newPlant2 = new Plant("Pampeliška", "žlutá", LocalDate.of(2018, 10, 1), LocalDate.of(2018, 10, 2), 1);
            testPlantList.addPlant(newPlant2);
        } catch (PlantException e) {
            System.err.println("Informace o kytce nebyly správně zadány: " + e.getLocalizedMessage());
        }

        testPlantList.removeItem(2);
            System.out.println("Test přidání a odebrání kytek");
        testPlantList.printWateringInfo();
        savePlants(testPlantList);
        }
    }

    private static PlantList loadPlants() {
        PlantList plantList = null;
        try {
            plantList = PlantList.loadFromFile(Settings.getDefaultFileName());


            PlantList.saveToFile(Settings.getDefaultFileName(), plantList);


        } catch (PlantException e) {
            System.err.println("Chyba při čtění souboru. " + e.getLocalizedMessage());
        }

        return plantList;
    }

    private static void savePlants(PlantList plantListToSave) {
        try {
            PlantList.saveToFile(Settings.getDefaultSaveFileName(), plantListToSave);
        } catch (PlantException e) {
            System.err.println("Chyba při ukládání souboru. " + e.getLocalizedMessage());
        }
    }


}