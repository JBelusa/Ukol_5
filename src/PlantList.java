import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlantList {
    private List<Plant> plantsList = new ArrayList();

    public PlantList() {
        this.plantsList.addAll(this.plantsList);
    }

    public PlantList(List<Plant> plantsList) {
        this.plantsList.addAll(plantsList);
    }

    public List<Plant> getPlantsList() {
        return this.plantsList;
    }

    public void addItem(Plant newPlant) {
        this.plantsList.add(newPlant);
    }

    public void removeItem(int indexOfPlant) {
        this.plantsList.remove(indexOfPlant);
    }

    public Plant getItem(int indexOfPlant) {
        return (Plant)this.plantsList.get(indexOfPlant);
    }

    public static PlantList loadFromFile(String filename) throws PlantException {
        PlantList newPlantlist = new PlantList();

        try {
            Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)));

            try {
                while(scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
            } catch (Throwable var6) {
                try {
                    scanner.close();
                } catch (Throwable var5) {
                    var6.addSuppressed(var5);
                }

                throw var6;
            }

            scanner.close();
            return newPlantlist;
        } catch (FileNotFoundException var7) {
            throw new PlantException("Soubor " + filename + " nelze otevřít");
        }
    }
}
