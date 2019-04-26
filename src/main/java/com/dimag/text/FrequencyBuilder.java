package com.dimag.text;

import java.util.Map;

public class FrequencyBuilder {


	public static void main(String[] args) throws TextProcessorException {

		if (args.length < 2) {
			System.out.println("Usage:\n java FrequencyBuilder <inputfile> <outputfile>");
			System.exit(-1);
		}
		String fileName = args[0];
		String outputFileName = args[1];

		TextTool textTool = new TextTool();
		Map<String, Integer> freq = textTool.analyze(fileName);
		TextTool.writeToCsvFile(outputFileName, freq);

		textTool.setRemovePunctuation(false) ;
		textTool.setToLowerCase(false);
		freq = textTool.analyze(fileName);
		TextTool.writeToCsvFile(outputFileName+"_1.csv", freq);


	}

}
