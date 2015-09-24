

import java.util.ArrayList;

public class Person {
	
	private String name;
	private ArrayList<Person> preferenceList= new ArrayList<>();
	
	public Person(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void addPreference(Person p){
		preferenceList.add(p);
	}
	
	public ArrayList<Person> getPreferenceList(){
		return this.preferenceList;
	}
	

}
