import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyStore {

    private List<Toy> toys;
    private List<Toy> prizeToys;

    public ToyStore() {
        toys = new ArrayList<>();
        prizeToys = new ArrayList<>();
    }

    public void addNewToy(int id, String name, int quantity, double frequency) {
        Toy newToy = new Toy(id, name, quantity, frequency);
        toys.add(newToy);
    }

    public void changeFrequency(int toyId, double newFrequency) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setFrequency(newFrequency);
                break;
            }
        }
    }

    public void drawToys(int numPrizes) {
        Random random = new Random();
        while (prizeToys.size() < numPrizes) {
            double randomNum = random.nextDouble() * 100;
            for (Toy toy : toys) {
                if (randomNum < toy.getFrequency()) {
                    Toy prizeToy = new Toy(toy.getId(), toy.getName(), 1, toy.getFrequency());
                    toy.setQuantity(toy.getQuantity() - 1);
                    prizeToys.add(prizeToy);
                    break;
                } else {
                    randomNum -= toy.getFrequency();
                }
            }
        }
    }

    public void awardPrizeToy() {
        Toy prizeToy = prizeToys.get(0);
        prizeToys.remove(0);
        writeToFile(prizeToy.getName());
    }

    private void writeToFile(String toyName) {
        try (FileWriter writer = new FileWriter("prize_winners.txt", true)) {
            writer.write(toyName + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
