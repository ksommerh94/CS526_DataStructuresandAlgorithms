import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Hw10_p5 {

	public static ArrayList<Node> read_follows_relationships() {
		ArrayList<Node> graph = new ArrayList<Node>();
		//Car myCar = new Car();
		BufferedReader br = null;
		  try {
			   String strCurrentLine;
			// read the first line from the input file
			   br = new BufferedReader(new FileReader("follows_input.txt"));
			// create an array of car Objects, carArray
			   while ((strCurrentLine = br.readLine()) != null) {
				// read subsequent lines, create Car objects, and add them to carArray one at a time
					String[] parts = strCurrentLine.split(", ");
					//New node
					Node myNode = new Node();
					myNode.setName(parts[0]);
					//Add nodes in list of follows
					ArrayList<String> follows = new ArrayList<String>();
					for (int i=1; i<parts.length; i++) {
						//Node myNode_loop = new Node();
						//myNode_loop.setName(parts[i]);
						follows.add(parts[i]);
					}
					//set the list of followers into my node
					myNode.setFollows_relationships(follows);
					//add the new node into the graph
					graph.add(myNode);
	
			   }
			   
		  } catch (IOException e) {
	
			  System.out.println("No such file or directory");
	
			  }
		return graph;
	}
	
	public static void allFollows(String X ,ArrayList<Node> graph) {
		//Direct followers
		ArrayList<String> followers = new ArrayList<String>();
		ArrayList<String> indirectfollowers = new ArrayList<String>();
		for (Node n: graph) {
			if (n.getName().equalsIgnoreCase(X)){
				System.out.println(n.toString());
				followers=n.getFollows_relationships();
			}
		}
		//Indirect followers
		ArrayList<String> check = new ArrayList<String>();
		for(String f:followers) {
			for (Node n: graph) {
				if (n.getName().equals(f)){
					check=n.getFollows_relationships();
					for(String c : check) {
						if(!followers.contains(c) && !indirectfollowers.contains(c)) {
							indirectfollowers.add(c);
						}
					}
				}
			}
		}
		String fr = "";
		for (String n : indirectfollowers) {
			fr+=n;
			fr+=",";
			
		} 
		if (fr.length()>0) {
			fr=fr.substring(0, fr.length()-1);
			
		}
		
		String c =
				X + " indirectly follows {"+fr+"}";
		System.out.println(c);
		
		
	}
	
	public static void main(String[] args) {
		ArrayList<Node> graph = new ArrayList<Node>();
		graph=read_follows_relationships();
		/*System.out.println("Whole full Graph");
		for(Node n : graph) {
			System.out.println(n.toString());
		}*/
		allFollows("D" ,graph);
		allFollows("A" ,graph);
		allFollows("C" ,graph);
		allFollows("B" ,graph);
		allFollows("E" ,graph);
		allFollows("F" ,graph);
		allFollows("G" ,graph);
		
		
			
		
	}

}