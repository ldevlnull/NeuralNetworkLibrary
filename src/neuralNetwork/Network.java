package neuralNetwork;

import java.util.Arrays;

/**
 * Created by devnull on 16/09/18.
 */
public class Network {

    private int amountOfInput;
    private int amountOfOutput; // amount of neurons in each layer
    private int amountOfHiddenLayer[][]; // first [] - amount of layers, second [] - amount of neurons in this layer

    private Layer inputLayer;
    private Layer outputLayer;

    private Layer hiddenLayers[];

    @Override
    public String toString() {
        return "Network{" +
                "\n\tamountOfInput=" + amountOfInput +
                ", \n\tamountOfOutput=" + amountOfOutput +
                ", \n\tamountOfHiddenLayer=" + Arrays.toString(amountOfHiddenLayer) +
                ", \n\tinputLayer=" + inputLayer +
                ", \n\toutputLayer=" + outputLayer +
                ", \n\thiddenLayers=" + Arrays.toString(hiddenLayers) +
                "\n}";
    }

    public Network(int amountOfInput, int amountOfHiddenLayer[][], int amountOfOutput) {
        this.inputLayer = new Layer(Layer_TYPE.INPUT, amountOfInput);
        this.outputLayer = new Layer(Layer_TYPE.OUTPUT, amountOfOutput);

        Layer hiddenLayers[] = new Layer[amountOfHiddenLayer.length];
        // generate hidden layers
        for(int i = 0; i < amountOfHiddenLayer.length; i++){
            hiddenLayers[i] = new Layer(Layer_TYPE.HIDDEN);

            Neuron neuronsForHidden[] = new Neuron[amountOfHiddenLayer[i].length];

            // generate neurons in hidden layer
            for(int j = 0; j < amountOfHiddenLayer[i].length; j++){
                neuronsForHidden[j] = new Neuron();
            }
            hiddenLayers[i].setNeurons(neuronsForHidden);

        }
        this.hiddenLayers = hiddenLayers;
        // TODO: implement weight association

        // input to first hidden layer
        for (int i = 0; i < amountOfInput; i++) { // each input neuron
            for (int j = 0; j < amountOfHiddenLayer.length; j++) { // each hidden neuron from first hidden layer
                inputLayer.getWeights().add(new Weight(inputLayer.getNeurons()[i], hiddenLayers[0].getNeurons()[j]));
            }
        }

        // each hidden layer
        for (int i = 0; i < amountOfHiddenLayer.length; i++) {
            for (int j = 0; j < amountOfHiddenLayer[i].length; j++) { // each neuron from each layer
                try {
                    for (int k = 0; k < amountOfHiddenLayer[i+1].length; k++) {
                        hiddenLayers[i].getWeights().add(new Weight(hiddenLayers[i].getNeurons()[j], hiddenLayers[i+1].getNeurons()[k]));
                    }
                }catch (ArrayIndexOutOfBoundsException a){
                    for (int k = 0; k < amountOfOutput; k++) {
                        hiddenLayers[i].getWeights().add(new Weight(hiddenLayers[i].getNeurons()[j], outputLayer.getNeurons()[k]));
                    }
                }
            }
        }
    }
}
