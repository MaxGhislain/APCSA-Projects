/*
 * Max Ghislain
 * Country Class for Country Data Project Checkpoint 4
 * December 8, 2022
 */

import java.util.Arrays;
import java.util.ArrayList;

public class Country {
	String countryName;
	String series;
	ArrayList<Integer> years = new ArrayList<>();
	ArrayList<Double> data = new ArrayList<>();
	
	public Country(String countryName, String series, ArrayList<Integer> years, ArrayList<Double> data) {
		this.countryName = countryName;
		this.series = series;
		this.years = years;
		this.data = data;
	}
	
	public String getUnits() {
		int startI = series.indexOf("(")+1;
		int endI = series.indexOf(")");
		if(startI == -1 || endI == -1)
			return "";
		
		return series.substring(startI, endI);
	}
	
	public String getAcronym() {
		String acronym = "";
		ArrayList<String> words = new ArrayList<>();
		
		if(series.indexOf("(") != -1) {
			words = new ArrayList<>(Arrays.asList(series.substring(0, series.indexOf("(")-1).split(" ")));
		} else {
			words = new ArrayList<>(Arrays.asList(series.split(" ")));
		}
		
		//System.out.println(words);
		
		String[] excludedWords = {"of", "in", "the", "at", "to", "by", "per", "on", "a", "an"};
		
		
		for(String excludedWord : excludedWords) {
			if(words.contains(excludedWord))
				words.remove(excludedWord);
			
			/*
			int wordI = words.indexOf(excludedWord);
			if(wordI != -1) {
				words = words.substring(0, wordI) + words.substring(wordI + excludedWord.length());
				System.out.println(words);
			}
			*/
			
		}
		
		System.out.println(words);
		
		for(String w : words) {
			acronym += w.substring(0,1).toUpperCase();
			//System.out.println(acronym);
		}
		
		return acronym;
	}
	
	public double min() {
		double min = data.get(0);
		for(double d : data) {
			if(d<min)
				min = d;
		}
		
		return min;
	}
	
	public double max() {
		double max = data.get(0);
		for(double d : data) {
			if(d>max)
				max = d;
		}
		
		return max;
	}
	
	public String getTrend() {
		if(trendsUp())
			return "up";
		else if(trendsDown())
			return "down";
		else
			return "no trend";
	}
	
	private boolean trendsUp() {
		for(int i=0; i<data.size()-1; i++) {
			if(data.get(i+1) <= data.get(i)) {
				return false;
			}
		}
		
		return true;
	}
	
	private boolean trendsDown() {
		for(int i=0; i<data.size()-1; i++) {
			if(data.get(i+1) >= data.get(i)) {
				return false;
			}
		}
		
		return true;
	}
	
	public String toString() {
		String output = "";
		
		//Years
		output += Arrays.toString(years.toArray()).substring(1, Arrays.toString(years.toArray()).length()-1).replace(",", "\t") + "\n";
		
		//data
		output += Arrays.toString(data.toArray()).substring(1, Arrays.toString(data.toArray()).length()-1).replace(",", "\t") + "\n";
		
		//Sentence
		output += "This is the \""+ series +"\" data for "+ countryName + "\n";
		
		//Min and Max
		output += "Minimum: " + min() + "\n";
		output += "Maximum: " + max() + "\n";
		
		//Trend
		output += "Trend: " + getTrend() + "\n";
		
		return output;
	}
	
	//Getters and Setters for TestsAssignment
	public ArrayList<Double> getData() {
		return data;
	}
	
	public void setData(ArrayList<Double> values) {
		data = values;
	}
	
	public String getSeries() {
		int startI = series.indexOf("(");
		int endI = series.indexOf(")");
		return series.substring(0, startI) + series.substring(endI, series.length()-1);
	}
	
	public void setSeries(String value) {
		series = value;
	}
	
	public String getCountry() {
		return countryName;
	}	
	
	public ArrayList<Integer> getYears() {
		return years;
	}
	
	// Checkpoint 5
	public void addDataPoint(int year, double data) {
		this.years.add(year);
		this.data.add(data);
	}
	
	public void editDataPoint(int year, double newData) {
		for(int i=0;i<this.years.size();i++) {
			if(this.years.get(i) == year)
				this.data.set(i, newData);
		}
	}
	
}

/*
public class Country {
	String countryName;
	String series;
	int[] years;
	double[] data;
	
	public Country(String countryName, String series, int[] years, double[] data) {
		this.countryName = countryName;
		this.series = series;
		this.years = years;
		this.data = data;
	}
	
	public String getUnits() {
		int startI = series.indexOf("(")+1;
		int endI = series.indexOf(")");
		if(startI == -1 || endI == -1)
			return "";
		
		return series.substring(startI, endI);
	}
	
	public String getAcronym() {
		String acronym = "";
		ArrayList<String> words = new ArrayList<>();
		
		if(series.indexOf("(") != -1) {
			words = new ArrayList<>(Arrays.asList(series.substring(0, series.indexOf("(")-1).split(" ")));
		} else {
			words = new ArrayList<>(Arrays.asList(series.split(" ")));
		}
		
		//System.out.println(words);
		
		String[] excludedWords = {"of", "in", "the", "at", "to", "by", "per", "on", "a", "an"};
		
		
		for(String excludedWord : excludedWords) {
			if(words.contains(excludedWord))
				words.remove(excludedWord);
			
			
		}
		
		System.out.println(words);
		
		for(String w : words) {
			acronym += w.substring(0,1).toUpperCase();
			//System.out.println(acronym);
		}
		
		return acronym;
	}
	
	public double min() {
		double min = data[0];
		for(double d : data) {
			if(d<min)
				min = d;
		}
		
		return min;
	}
	
	public double max() {
		double max = data[0];
		for(double d : data) {
			if(d>max)
				max = d;
		}
		
		return max;
	}
	
	public String getTrend() {
		if(trendsUp())
			return "up";
		else if(trendsDown())
			return "down";
		else
			return "no trend";
	}
	
	private boolean trendsUp() {
		for(int i=0; i<data.length-1; i++) {
			if(data[i+1] <= data[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	private boolean trendsDown() {
		for(int i=0; i<data.length-1; i++) {
			if(data[i+1] >= data[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	public String toString() {
		String output = "";
		
		//Years
		output += Arrays.toString(years).substring(1, Arrays.toString(years).length()-1).replace(",", "\t") + "\n";
		
		//data
		output += Arrays.toString(data).substring(1, Arrays.toString(data).length()-1).replace(",", "\t") + "\n";
		
		//Sentence
		output += "This is the \""+ series +"\" data for "+ countryName + "\n";
		
		//Min and Max
		output += "Minimum: " + min() + "\n";
		output += "Maximum: " + max() + "\n";
		
		//Trend
		output += "Trend: " + getTrend() + "\n";
		
		return output;
	}
	
	//Getters and Setters for TestsAssignment
	public double[] getData() {
		return data;
	}
	
	public void setData(double[] values) {
		data = values;
	}
	
	public String getSeries() {
		int startI = series.indexOf("(");
		int endI = series.indexOf(")");
		return series.substring(0, startI) + series.substring(endI, series.length()-1);
	}
	
	public void setSeries(String value) {
		series = value;
	}
	
	public String getCountry() {
		return countryName;
	}	
	
	public int[] getYears() {
		return years;
	}
	
	
	
}
 */