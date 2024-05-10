import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyShop {
    private List<Toy> toys;
    private List<Toy> prizeToys;

    public ToyShop() {
        this.toys = new ArrayList<>();
        this.prizeToys = new ArrayList<>();
    }

    public void addNewToy(int id, String name, int quantity, double weight) {
        Toy newToy = new Toy(id, name, quantity, weight);
        toys.add(newToy);
    }

    public void changeWeight(int toyId, double newWeight) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setWeight(newWeight);
                return;
            }
        }
    }

    public void selectPrizeToy() {
        double rand = Math.random() * 100;
        double sumWeight = 0.0;

        for (Toy toy : toys) {
            sumWeight += toy.getWeight();
            if (rand <= sumWeight) {
                Toy prizeToy = toy;
                prizeToys.add(prizeToy);
                toy.setQuantity(toy.getQuantity() - 1);

                toys.remove(toy);
                writeToTextFile(prizeToy);
                return;
            }
        }
    }
}