import java.util.ArrayList;

public class Node {
 
   private String name;
   private ArrayList<String> follows_relationships;
   
   public Node() {
   }
   //Contructor
   public Node(String name, ArrayList<String> follows_relationships ) {
	   this.setName(name);
	   this.setFollows_relationships(follows_relationships);
   }
   //Setter and getter for the attributes
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<String> getFollows_relationships() {
		return follows_relationships;
	}
	
	public void setFollows_relationships(ArrayList<String> follows_relationships) {
		this.follows_relationships = follows_relationships;
	}
	//To string for the big array of Nodes (graph)
	public String toString() {
		
		 String fr = "";
		 if (follows_relationships.size()>0) {
			 for (String n : follows_relationships) {
					fr+=n;
					fr+=",";
					
				} 
			 fr=fr.substring(0, fr.length()-1);
			 
		 }
		 
		
	   String c =
				name + " directly follows {"+fr+"}";
	   return c;
	   }

	}