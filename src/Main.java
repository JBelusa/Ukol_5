public class Main {
    public Main() {
    }

    public static void main(String[] args) throws PlantException {
        try {
            PlantList var1 = PlantList.loadFromFile("kvetiny.txt");
        } catch (PlantException var2) {
            System.out.println("Chyba při čtění souboru" + var2.getLocalizedMessage());
        }

    }
}