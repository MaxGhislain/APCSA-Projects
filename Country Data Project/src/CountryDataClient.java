import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import static java.util.stream.Collectors.*;
/*
 * Max Ghislain
 * Client for Country Data Project
 * October 6, 2022
 */

public class CountryDataClient {

	public static void main(String[] args) throws FileNotFoundException{
		/* Single Country Script
		File inputFile = new File("singleCountryData.txt");
		Scanner input = new Scanner(inputFile);
		
		// Series
		String series = input.nextLine();
		System.out.println(series);
		
		// Years
		int numYears = Integer.parseInt(input.nextLine());
		for(int i=0; i<numYears; i++) {
			System.out.print(input.nextLine()+"	");
		}
		System.out.println();
		
		// Data
		
		String countryName = input.nextLine();
		
		for(int i=0; i<numYears; i++) {
			System.out.print(input.nextLine()+"	");
		}
		System.out.println();
		
		System.out.println("This is the "+ series +" data for "+ countryName);
		
		input.close();
		*/
		/* Multiple Country Script
		File inputFile = new File("multipleCountry3.txt");
		Scanner input = new Scanner(inputFile);
		
		String series = input.nextLine();
		
		int numYears = input.nextInt();
		input.nextLine();
		
		String countryName = input.nextLine();
		
		while(!countryName.equals("END")) {
			//Years
			for(int i=0; i<numYears; i++) {
				System.out.print(input.nextLine()+"	");
			}
			System.out.println();
			
			//Data
			double min = 0;
			double max = 0;
			for(int i=0; i<numYears; i++) {
				double num = Math.round(input.nextDouble()*100.0)/100.0; // rounds to two decimal places
				input.nextLine();
				if(i==0) {
					min = num;
					max = num;
				}
				
				if(num<min)
					min = num;
				if(num>max)
					max = num;
				System.out.print(num+"	");
			}
			System.out.println();
			
			System.out.println("This is the "+ series +" data for "+ countryName);
			
			System.out.println("Minimum: "+min);
			System.out.println("Maximum: "+max);
			
			countryName = input.nextLine();
		}
		*/
		
		// Csv Country Script (Part 3)
		/*
		File inputFile = new File("CountryDataSet.csv");
		Scanner input = new Scanner(inputFile);

		// Part 3
		String series = input.nextLine().replace(",", "");
		System.out.println(series);
		
		String[] stringYears = input.nextLine().substring("Country".length()+1).split(",");
		
		int[] years = Arrays.stream(stringYears).mapToInt(Integer::parseInt).toArray();
		
		//System.out.println(Arrays.toString(countryYears));
		
		while(input.hasNextLine()) {
			String stringValues = input.nextLine();
			String countryName = stringValues.split(",")[0];
			
			//System.out.println(countryName);
			
			String[] countryStringValues = stringValues.substring(countryName.length()+1).split(",");
			
			double[] values = Arrays.stream(countryStringValues).mapToDouble(Double::parseDouble).toArray();
			for(int i = 0; i<values.length; i++)
				values[i] = Math.round(values[i]*100.0)/100.0;
			
			System.out.println(summarizeCountry(countryName, series, years, values));
		}
		input.close();
	}
	
	public static String summarizeCountry(String countryName, String series, int[] years, double[] values) {
		String output = "";
		
		//Years
		output += Arrays.toString(years).substring(1, Arrays.toString(years).length()-1).replace(",", "\t") + "\n";
		
		//Values
		output += Arrays.toString(values).substring(1, Arrays.toString(values).length()-1).replace(",", "\t") + "\n";
		
		//Sentence
		output += "This is the \""+ series +"\" data for "+ countryName + "\n";
		
		//Min and Max
		output += "Minimum: " + min(values) + "\n";
		output += "Maximum: " + max(values) + "\n";
		
		return output;
	}
	
	public static double max(double[] doubles) {
		double max = doubles[0];
		for(double d : doubles) {
			if(d>max)
				max = d;
		}
		
		return max;
	}
	
	public static double min(double[] doubles) {
		double min = doubles[0];
		for(double d : doubles) {
			if(d<min)
				min = d;
		}
		
		return min;
	}
	*/

		//Part 4
		File inputFile = new File("CountryDataSet.csv");
		Scanner input = new Scanner(inputFile);

		// Part 3
		String series = input.nextLine().replace(",", "");
		System.out.println(series);
		
		String[] stringYears = input.nextLine().substring("Country".length()+1).split(",");
		
		int[] years = Arrays.stream(stringYears).mapToInt(Integer::parseInt).toArray();
		
		ArrayList<Integer> arrayYears = new ArrayList<>(years.length);
		for (int year : years)
			arrayYears.add(year);
		
		//System.out.println(Arrays.toString(countryYears));
		
		//Initializing country ArrayList
		ArrayList<Country> countryList = new ArrayList<Country>();
		
		while(input.hasNextLine()) {
			String stringValues = input.nextLine();
			String countryName = stringValues.split(",")[0];
			
			//System.out.println(countryName);
			
			String[] countryStringValues = stringValues.substring(countryName.length()+1).split(",");
			
			double[] values = Arrays.stream(countryStringValues).mapToDouble(Double::parseDouble).toArray();
			for(int i = 0; i<values.length; i++)
				values[i] = Math.round(values[i]*100.0)/100.0;
			
			//Convert to arraylists
			ArrayList<Double> arrayValues = new ArrayList<>(values.length);
			for(double value : values)
				arrayValues.add(value);
			
			
			Country countryObj = new Country(countryName, series, arrayYears, arrayValues);
			System.out.println(countryObj);
			
			//store country objs
			countryList.add(countryObj);
		}
		
		input.close();
	}
	
	//Checkpoint 5
	public static void removeByName(ArrayList<Country> countries, String name) {
		for(int i=0;i<countries.size();i++) {
			if(countries.get(i).getCountry() == name)
				countries.remove(i);
		}
	}
	
	public static void removeNoTrend(ArrayList<Country> countries) {
		for(int i=0;i<countries.size();i++) {
			if(countries.get(i).getTrend() == "no trend") {
				countries.remove(i);
				i--;
			}
		}
	}
	
	public static ArrayList<String> getListBasedOnTrend(ArrayList<Country> countries, String trendType) {
		ArrayList<String> output = new ArrayList<>();
		
		if(!(trendType=="up") && !(trendType=="down") && !(trendType=="no trend"))
			throw new IllegalArgumentException("trendtype is not \"up\", down, or no trend");
		
		for(Country country : countries) {
			if(country.getTrend().equals(trendType))
				output.add(country.getCountry());
		}
		
		return output;
	}
}
