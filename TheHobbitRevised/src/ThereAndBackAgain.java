import java.util.ArrayList;

public class ThereAndBackAgain 
{

	public static void main(String[] args) 
	{
		
		//Part 1
		
		Hobbit frodo = new Hobbit("Frodo");
		Hobbit sam = new Hobbit("Sam");
		Dwarf gimli = new Dwarf("Gimli");
		
		// Create a traveling party called party1 by creating an array of Travelers 
		// and filling it with frodo, sam, and gimli
		// Then, use a loop to make all travelers go a distance of 50 miles  
		// Then, for each Traveler in the travelingParty, print their name and how far they've
		//    traveled in miles.  (In the next piece, you'll do this in methods, but 
		//    for a first pass, just do it in main and print to the console.)
		// Expected output:  Frodo has traveled 50 miles.
		//                   Sam has traveled 50 miles.
		//                   Gimli has traveled 50 miles.
		
		Traveler[] party1 = {frodo, sam, gimli};
		
		for(Traveler traveler : party1)
			traveler.travel(50);	
		
		for(Traveler traveler : party1) 
			System.out.println(traveler.getName() + " has traveled " + traveler.getDistanceTraveled() + " miles.");
		
		
		//Part 2
		System.out.println("\n\n\nPART 2: \n");

		String[] dwarfNames = {"Fili", "Kili", "Dori", "Ori", "Nori", "Balin", "Dwalin",
		"Oin", "Gloin", "Bifur", "Bofur", "Bombur", "Thorin"};

		// Make a new ArrayList to hold a 2nd party of Travelers called party2:
		ArrayList<Traveler> party2 = new ArrayList<>();
		
		// Make a new Hobbit called "Bilbo" and add him to party2
		Hobbit Bilbo = new Hobbit("Bilbo");
		party2.add(Bilbo);

		// Make a new Wizard called "Gandalf" and add him to party2.
		Wizard Gandalf = new Wizard("Gandalf", "Grey");
		party2.add(Gandalf);


		//write createParty
		// Call the createParty method and pass it party2 and the dwarfNames array.
		createParty(party2, dwarfNames);
		// create party should add all the new dwarves to party2,

		//Write allTravel
		// Finally, call the allTravel method passing it party2 and 100 (representing
		// the 100 miles that party2 has traveled together.
		allTravel(party2, 100);
		//Make sure your code prints out the name and distances party2 has traveled.
		
		for(Traveler traveler : party2) 
			System.out.println(traveler.getName() + " has traveled " + traveler.getDistanceTraveled() + " miles.");
	}
	
	public static void createParty(ArrayList<Traveler> party, String[] dwarfNames) {
		for(String name : dwarfNames) {
			party.add(new Dwarf(name));
		}
	}
	
	public static void allTravel(ArrayList<Traveler> party, int miles) {
		for(Traveler traveler : party)
			traveler.travel(miles);
	}
}
