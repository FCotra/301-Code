import java.io.*;

public class meanScore{
	public static void main(String[] args) throws IOException{
			String input = args[0];
			String output = args[1];
			File inputFile = new File(input);
			File outputFile = new File(output);
			BufferedReader reader = new BufferedReader(new FileReader(input));
			BufferedWriter writer = new BufferedWriter(new FileWriter(output));
			String line = reader.readLine();
			line = reader.readLine();
			double lineScore;
			double mean;
			double scoreSum = 0;
			double totalLines = 0;
			double standardDeviation = 0;
			double standardDeviationSquared = 0;
			double scoreMinusMean = 0;
			double scoreMinusMeanSquared = 0;
			double standardError = 0;

			while(line != null){
				totalLines++;
				lineScore = Double.parseDouble(line);
				scoreSum += lineScore;
				line = reader.readLine();
			}

			mean = (scoreSum/totalLines);
			writer.write("Mean score: " + mean);
			writer.write("\nSample size: " + totalLines);

			BufferedReader reader2 = new BufferedReader(new FileReader(inputFile));

			line = reader2.readLine();
			line = reader2.readLine();

			while(line != null){
				lineScore = Double.parseDouble(line);
				scoreMinusMean += lineScore - mean;
				scoreMinusMeanSquared += Math.pow(scoreMinusMean, 2);
				line = reader2.readLine();
			}

			standardDeviationSquared = scoreMinusMeanSquared/totalLines;
			standardDeviation = Math.pow(standardDeviationSquared, 0.5);
			standardError = standardDeviation/Math.pow(totalLines, 0.5);

			writer.write("\nStandard Deviation: " + standardDeviation);
			writer.write("\nStandard Error: " + standardError);

			writer.close();
			System.exit(0);
	}
}