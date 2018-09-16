package neuralNetwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by devnull on 16/09/18.
 */
public class Layer {

    private Layer_TYPE type;
    private Neuron neurons[];
    private List<Weight> weights;

    @Override
    public String toString() {
        return "Layer{" +
                "\n\t\ttype=" + type +
                ", \n\t\tneurons=" + Arrays.toString(neurons) +
                ", \n\t\tweights=" + weights +
                "\n}";
    }

    public Layer(Layer_TYPE type) {
        this.type = type;
        this.weights = new ArrayList<>();
    }

    public Layer(Layer_TYPE type, int amountOfNeurons) {
        this.type = type;
        this.weights = new ArrayList<>();

        Neuron neurons[] = new Neuron[amountOfNeurons];

        if(type.equals(Layer_TYPE.INPUT))
            for(int i = 0; i < amountOfNeurons; i++)
                neurons[i] = new Neuron();
        else if(type.equals(Layer_TYPE.OUTPUT)){
            for(int i = 0; i < amountOfNeurons; i++)
                neurons[i] = new Neuron();
            this.weights = null;
        }
        this.neurons = neurons;
    }

    public void setNeurons(Neuron[] neurons) {
        this.neurons = neurons;
    }

    public List<Weight> getWeights() {
        return weights;
    }

    public Neuron[] getNeurons() {
        return neurons;
    }
}
