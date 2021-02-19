/* Assignment9_2017

Student name:Ciaran Winnan
Student number:2940836

*/
import java.util.*;
public class Assignment9_2017{
	public static void main(String args[]){
	  //Create instance of Friends class and test methods here.
	  //Create instance of Frinds
	  Friends f = new Friends();
	  //Add method test
	  f.add(new Person("John", "Mark"));
	  f.add(new Person("Erin", "Fits"));
	  f.add(new Person("Mark", "Bishop"));
	  f.add(new Person("Olivia", "Mark"));
	  f.add(new Person("Olivia", "Johns"));
	  //Search method test
	  Person p1 = new Person("John", "Mark");
	  if(f.search(p1) == true){
	  	System.out.println("Person was found!");
	  }
	  else{
	  	System.out.println("Person is not found!");
	  }
	  //Size method test
	  System.out.println("\n"+f.size());
	  //getSurname method test
	  System.out.println("\n"+f.getSurname("Mark"));
	  //getFirstName test
	  System.out.println("\n"+f.getFirstName("Olivia"));
	  //gerFreq method test
	  System.out.println("\n"+f.getFreq("Olivia"));
	  //del method test
	  System.out.println("\n"+f.toString());
	  Person delPer = new Person("Olivia", "Johns");
	  f.del(delPer);
	  System.out.println(f.toString());
	  //sort method - As I was using the TreeSet, the set is already ordered. 
	  System.out.println("\n"+f.sort());
	  //toString method
	  System.out.println("\n"+f.toString());
	}
}

class Friends {
	TreeSet<Person> fds;
	
	public Friends() {
		fds = new TreeSet<>();
	}
	
	public void add(Person p){
		fds.add(p);
	}
	
	public boolean search(Person p){
		if(fds.contains(p)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public int size(){
		return fds.size();
	}
	
	public TreeSet<Person> getSurname(String s){
		TreeSet<Person> isSurname = new TreeSet<>();
		for(Person p : fds){
    		if(p.sName().equals(s)){
    			isSurname.add(p);
			}
    	}
		return isSurname;
	}
	
	public TreeSet<Person> getFirstName(String f){
		TreeSet<Person> isFirstname = new TreeSet<>();
		for(Person p : fds){
    		if(p.fName().equals(f)){
    			isFirstname.add(p);
			}
    	}
		return isFirstname;
	}
	
	public int getFreq(String f){
		int count = 0;
		for(Person p : fds){
			if(p.fName().equals(f)){
				count++;
			}
		}
		return count;
	}
	
	public boolean del(Person per){
		for(Person p : fds){
			if(p.equals(per)){
				fds.remove(per);
				return true;
			}
		}
		return false;
	}
	
	public TreeSet<Person> sort(){
		 return fds;
	}
	
	public String toString(){
		return fds.toString();
	}
}

final class Person implements Comparable<Person>{
	private final String sName;
  	private final String fName;
	
	Person(String fn, String sn){
		fName = fn;
		sName = sn;
	}
	
	public String sName(){return sName;}
  	public String fName(){return fName;}
	public String toString(){return fName+" "+sName;}
	public boolean equals(Object ob){
		if(!(ob instanceof Person)) return false;
		Person p = (Person)ob;
		return sName.equals(p.sName) && fName.equals(p.fName);
	}
	public int compareTo(Person p){
		if(p == null) return -1;
    	if(this.equals(p)) return 0;
		if(sName.equals(p.sName)) return fName.compareTo(p.fName);
			return sName.compareTo(p.sName);
		}
	public int hashCode(){
    	return sName.hashCode() * fName.hashCode();
  	}
}