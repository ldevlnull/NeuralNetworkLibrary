package neuralNetwork;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by devnull on 16/09/18.
 */
public class Weight {

    private double value;
    private Neuron[] neurons;

    @Override
    public String toString() {
        return "\n\t\t\t\tWeight:" +
                "\n\t\t\t\t\tvalue=" + value +
                ", \n\t\t\t\t\tneurons=" + Arrays.toString(neurons);
    }

    public Weight(Neuron neuron1, Neuron neuron2) {
        Neuron neurons[] = new Neuron[2];

        neurons[0] = neuron1;
        neurons[1] = neuron2;
        this.value = Math.random();

        this.neurons = neurons;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
