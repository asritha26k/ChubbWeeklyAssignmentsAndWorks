package aboutHashMap;
import java.util.*;
public class EmpCom {
public static void main(String [] args) {
	Scanner sc = new Scanner(System.in);
	HashMap<String,ArrayList<String>> details = new HashMap<>();
	details.put("Comp1",new ArrayList<>());
	details.put("Comp2",new ArrayList<>());
	details.put("Comp3",new ArrayList<>());
	details.put("Comp4",new ArrayList<>());
	details.put("Comp5",new ArrayList<>());
	details.get("Comp1").addAll(List.of("Aarav", "Diya", "Rohan"));
	details.get("Comp2").addAll(List.of("Meera", "Kabir", "Anaya"));
	details.get("Comp3").addAll(List.of("Ishaan", "Sanya", "Vihaan"));
	details.get("Comp4").addAll(List.of("Aditi", "Reyansh", "Kavya"));
	details.get("Comp5").addAll(List.of("Arjun", "Myra", "Dev"));

	for (String company : details.keySet()) {
	    System.out.println(company+"  company name   ");
	    for(String names:details.get(company)) {
	    	System.out.print("employee "+ names+" ");
	    }
	    System.out.println();
	   
	}
	//searching some person!
	//searching Meera in comp2
		System.out.println("enter company name");
		String compName=sc.nextLine();
		System.out.println("enter person name");
		String perName=sc.nextLine();
	    for(String names:details.get(compName)) {
	    	if(names.equals(perName))
	    	System.out.print("  employee "+ " " +names+ " ");
	    }
	    System.out.println();
	   
	//searching for company 6, if not found add
	    System.out.println("enter company name");
		String comp=sc.nextLine();
	    boolean found=false;
	    for (String company : details.keySet()) {
		    if(company.equals(comp)){
		    		found=true;
		    }
		   
		} 
	    if(!found) {
	    	details.put(comp,new ArrayList<>());
	    	System.out.println("new company added");
	    	
	    }

	
}
}
