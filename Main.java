import java.io.IOException;

import neuralnet.algebra.NetworkOrganizer;
import neuralnet.network.ann.ANN;
import neuralnet.training.ANNTrainer;

/**
* Main
*/
public class Main {
	
	public static void main(String[] args) throws IOException {
		NetworkOrganizer.addFullyConnectedLayer(2);
		NetworkOrganizer.addFullyConnectedLayer(2);
		NetworkOrganizer.addFullyConnectedLayer(2);
		
		NetworkOrganizer.setEpoch(200);
		NetworkOrganizer.setStochastic(10);
		
		NetworkOrganizer.setLearningRate(0.004);
		NetworkOrganizer.setRandomization(0.001);
		NetworkOrganizer.setMomentumFactor(0.002);
		
		ANN ann = new ANN();
		
		ANNTrainer trainer = new ANNTrainer(ann);
		
		
	}
	
}
