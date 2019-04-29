package com.dimag.text;

import java.util.Arrays;
import java.util.Map;

public class FrequencyBuilder {


	public static void main(String[] args) throws TextProcessorException {

		System.out.println("Your arguments:");
		Arrays.stream(args).forEach(x -> System.out.println(x));

		if (args.length < 4) {
			System.out.println("Usage:\n java FrequencyBuilder <inputfile> <outputfile> <removepunctunation>  <tolowercase>");
			System.exit(-1);
		}
		String fileName = args[0];
		String outputFileName = args[1];

		boolean removePunctuation = Boolean.valueOf(args[2]);
		boolean toLowerCase = Boolean.valueOf(args[3]);

		TextTool textTool = new TextTool()   //chaining...
				.setRemovePunctuation(removePunctuation)
				.setToLowerCase(toLowerCase);

		Map<String, Integer> freq = textTool.analyze(fileName);
		TextTool.writeToCsvFile(outputFileName, freq);

	}

}
