import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyShop {

    private List<Toy> toys = new ArrayList<>();
    private List<Toy> prizeToys = new ArrayList<>();

    public void addToy(Toy toy){
        toys.add(toy);
    }

    public void updateWeight(int toyId, double newWeight){
        for (Toy toy : toys){
            if (toy.getId() == toyId){
                toy.setWeight(newWeight);

            }
        }
    }

    public Toy choosePrizeToy(){
        Random random = new Random();
        double totalWeight = toys.stream().mapToDouble(Toy::getWeight).sum();
        double randomValue = random.nextDouble() * totalWeight;

        double weightSum = 0;
        for (Toy toy : toys){
            weightSum += toy.getWeight();
            if (randomValue <= weightSum){
                Toy prizeToy = new Toy(toy.getId(), toy.getName(), 1, toy.getWeight());
                toy.decreaseQuantity();
                prizeToys.add(prizeToy);
                return prizeToy;
            }
        }
        return null;

    }

    public void getPrizeToy(){
        Toy priToy = prizeToys.remove(0);
        try (FileWriter writer = new FileWriter("prizeToys.txt", true)){
            writer.write("Prize Toy: " + priToy.getName() +"\n");
            
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    
}
