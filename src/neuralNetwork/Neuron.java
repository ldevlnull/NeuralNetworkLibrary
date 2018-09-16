package neuralNetwork;

/**
 * Created by devnull on 16/09/18.
 */
public class Neuron {

    private double value;
    private Neuron_TYPE type;

    @Override
    public String toString() {
        return "\n\t\t\tNeuron:" +
                "\n\t\t\t\tvalue=" + value +
                ", \n\t\t\t\ttype=" + type;
    }
}
