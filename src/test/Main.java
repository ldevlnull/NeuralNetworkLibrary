package test;

import neuralNetwork.Network;

/**
 * Created by devnull on 16/09/18.
 */
public class Main {

    public static void main(String []args){

        int [][] hidden = {{4}};

        Network network = new Network(2, hidden,  1);

        System.out.println(network.toString());

    }
}
