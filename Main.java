import neuralnet.algebra.Matrix;
import neuralnet.network.net.ANN;
import neuralnet.network.train.ANNTrainer;

/**
* Main
*/
public class Main {
	
	public static void main(String[] args) {
		
		// Matrix fat = new Matrix(new double[][] { {1, 1}, {0, 0} } );
		// Matrix mot = new Matrix(new double[][] { {0, 0}, {1, 1} } );
		
		// Matrix[] childs = Matrix.breed(fat, mot, 10, 0.03);
		
		// for (int i = 0; i < 10; i++) {
		// 	System.out.println( childs[i] );
		// }
		
		Matrix[] input = new Matrix[4];
		input[0] = new Matrix(new double[][] { {1}, {1} });
		input[1] = new Matrix(new double[][] { {1}, {0} });
		input[2] = new Matrix(new double[][] { {0}, {1} });
		input[3] = new Matrix(new double[][] { {0}, {0} });
		
		Matrix[] answer = new Matrix[4];
		answer[0] = new Matrix(new double[][] { {1}, {0} });
		answer[1] = new Matrix(new double[][] { {0}, {1} });
		answer[2] = new Matrix(new double[][] { {0}, {1} });
		answer[3] = new Matrix(new double[][] { {0}, {1} });
		
		ANN ann = new ANN();
		ann.addLayer(ANN.SOFTMAX, 2, 2);
		ann.randomize(0.01);
		
		ANNTrainer trainer = new ANNTrainer(ann, input, answer, 1);
		trainer.train(20000, 100, 0.00001, 0.00003);
		
		System.out.println( ann.forwardPropagation( input[0] ) );
		System.out.println( ann.forwardPropagation( input[1] ) );
		System.out.println( ann.forwardPropagation( input[2] ) );
		System.out.println( ann.forwardPropagation( input[3] ) );
		
		System.out.println(ann);
		
	}
	
}
