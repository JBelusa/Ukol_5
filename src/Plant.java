import java.time.LocalDate;

public class Plant {
    private String name;
    private String notes;
    private LocalDate planted;
    private LocalDate watering;
    private int frequencyOfWatering;

    public Plant(String name, String notes, LocalDate planted, LocalDate watering, int frequencyOfWatering) throws PlantException {
        this.name = name;
        this.notes = notes;
        this.planted = planted;
        this.setWatering(watering);
        this.setFrequencyOfWatering(frequencyOfWatering);
    }

    public Plant(String name, LocalDate planted, int frequencyOfWatering) throws PlantException {
        this(name, "", planted, LocalDate.now(), frequencyOfWatering);
    }

    public Plant(String name) throws PlantException {
        this(name, "", LocalDate.now(), LocalDate.now(), 7);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getPlanted() {
        return this.planted;
    }

    public void setPlanted(LocalDate planted) {
        this.planted = planted;
    }

    public LocalDate getWatering() {
        return this.watering;
    }

    public void setWatering(LocalDate watering) throws PlantException {
        if (watering.isBefore(this.getPlanted())) {
            throw new PlantException("Datum zálivky musí být před datem zasazení nebo v den zasazení");
        } else {
            this.watering = watering;
        }
    }

    public int getFrequencyOfWatering() {
        return this.frequencyOfWatering;
    }

    public void setFrequencyOfWatering(int frequencyOfWatering) throws PlantException {
        if (frequencyOfWatering <= 0) {
            throw new PlantException("Zadaná hodnota frekvence zálivky musí být větší než nula");
        } else {
            this.frequencyOfWatering = frequencyOfWatering;
        }
    }

    public String getWateringInfo() {
        String var10000 = this.getName();
        return "Název květiny: " + var10000 + ", Datum poslední zálivky: " + String.valueOf(this.getWatering()) + ", Datum doporučené další zálivky: " + String.valueOf(this.getWatering().plusDays((long)this.getFrequencyOfWatering()));
    }

    public String toString() {
        String var10000 = this.name;
        return "Plant{name='" + var10000 + "', notes='" + this.notes + "', planted=" + String.valueOf(this.planted) + ", watering=" + String.valueOf(this.watering) + ", frequencyOfWatering=" + this.frequencyOfWatering + "}";
    }
}
