import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ProcessScheduling {
	
	public static void readFile(ArrayList<Process> read_elements) {
		// Method: Read the file text and add it to the processes objects 
		// input: The array were all the processes are going to be store
		// output: nothing, void method
		
		BufferedReader br = null;
		  try {
			   String strCurrentLine;
			   br = new BufferedReader(new FileReader("process_scheduling_input.txt"));
			   while ((strCurrentLine = br.readLine()) != null) {
				// read subsequent lines, create process objects, and add them to queue one at a time
				String[] parts = strCurrentLine.split(" ");
				int process_id=Integer.parseInt(parts[0]);
				int priority=Integer.parseInt(parts[1]);
				int arrival_time=Integer.parseInt(parts[2]);
				int duration=Integer.parseInt(parts[3]);
				Process my_process = new Process(process_id,priority,duration,arrival_time);
				//add new process to the array
				read_elements.add(my_process);
			   }
			   //Print all processes
			   System.out.println("All Processes:");
				for (Process p : read_elements) {
					System.out.println(p.toString());
				}
			   
		 }catch (IOException e) {
			  System.out.println("No such file or directory");
			  }
		
}
	
	public static void addToQueue(PriorityQueue<Process> pq,ArrayList<Process> read_elements,int currentTime) {
		// Method: Add process to the priority queue and removes it from the storage array
		// input: Priority queue were os going to be store the process, The array were all the processes are stored
		//        current time, to check which process should enter into the priority queue
		// output: nothing, void method

		//Add process if the is arrival time is the current or if it already passed by
		for (int i =0; i<read_elements.size();i++){
			if (read_elements.get(i).getArrivalTime()<=currentTime) {
				// add to priority queue
				pq.add(read_elements.get(i));
				//remove from array
				read_elements.remove(i);
				i--;
			}
			else {
				break;
			}
		}
		//System.out.println("HOLA MUNDO");
	}
	
	public static Process remove_priority(PriorityQueue<Process> pq) {
		// Method: remove the process from priority queue , which has the smallest priority
		// input: Priority queue were are the processes
		// output: returns the deleted process
		
		int small_priority_available=Integer.MAX_VALUE;
		Process process_to_remove= new Process();
		// get minimum priority
		for (Process priority_queue: pq) {
			if (priority_queue.getPriority()<small_priority_available){
				small_priority_available=priority_queue.getPriority();
				process_to_remove=priority_queue;
			}
		}
		//removes process with minimum priority
		pq.remove(process_to_remove);
		//return process with minimum priority
		return process_to_remove;
	}

	public static void main(String[] args) throws IOException {
		// Creating a File object that represents the disk file.
        	PrintStream o = new PrintStream(new File("process_scheduling_output.txt"));
        	System.setOut(o);
 
		//Initialize variables
			//Current time passing
		int currentTime=0;
			//Max time to check if is necessary to update
		int maxTimeWait=30;
			//Counter of how many times there has been access to read_elements
		int totalWaitTime=0;
			//Priority queue
		PriorityQueue<Process> pq = new PriorityQueue<>();
		//array for storing the readed processes
		ArrayList<Process> read_elements = new ArrayList<Process>();
		//array for storing the waiting times
		List<Integer> avg_waiting_times = new ArrayList<Integer>();
		
		//Read file
		readFile(read_elements);
		
		//get last element time arrival
		// flag to check if read_elemetns is empty
		int last_process_arrival_time=read_elements.get(read_elements.size()-1).getArrivalTime();
		boolean flag_empty=false;
		System.out.println("Maximum wait time = "+maxTimeWait);
		//While the array of elements or the queue are not empty
		while (!read_elements.isEmpty() || !pq.isEmpty()) {
			// Add process to queue
			addToQueue(pq,read_elements,currentTime);
			
			//Update waiting time of elements
			for (Process priority_queue: pq) {
				int waitTime=currentTime-priority_queue.getArrivalTime();
				priority_queue.setWaitTime(waitTime);
			}
			
			//Changes the priority of the processes if necessary, if the wait time is grater that the max wait time
			if (!pq.isEmpty()) {
			System.out.println("Update priority:");
				for(Process pq_priorities : pq) {
					if(pq_priorities.getWaitTime()>=maxTimeWait) {
						int curentPriority=pq_priorities.getPriority();
						//print
						System.out.println("PID = "+pq_priorities.getProcess_id()+ " , wait time = "+
										   pq_priorities.getWaitTime()+" ,current priority = "+pq_priorities.getPriority());
						pq_priorities.setPriority(curentPriority-1);
						System.out.println("PID = "+pq_priorities.getProcess_id()+",new priority = "+pq_priorities.getPriority());			  
					}
				}
				System.out.println("\n");
			}
			
			if (!pq.isEmpty()) {
				//check if read element is empty , for printing 
				if (read_elements.isEmpty() && !flag_empty) {
					flag_empty=true;
					System.out.println("D becomes empty at time "+last_process_arrival_time+"\n");
				}
				Process process_to_remove= new Process();
				//Remove process with smallest priority
				process_to_remove=remove_priority(pq);
				//Adds time to the current time with the duration of the process that was removed ( executed)
				currentTime+=process_to_remove.getDuration();
				//Assign the total time to the deleted process
				totalWaitTime+=process_to_remove.getWaitTime();
				process_to_remove.setTotalWaitTime(totalWaitTime);
				int atTime=currentTime-process_to_remove.getDuration();
				
				avg_waiting_times.add(process_to_remove.getWaitTime());
				
				//Print process information
				System.out.println("Process removed from queue is: id = " + process_to_remove.getProcess_id()+
									" , at time =  " + atTime + ", wait time = "+ process_to_remove.getWaitTime() + 
									" Total wait time = " + process_to_remove.getTotalWaitTime()
									);
				System.out.println(process_to_remove.toString2());
				System.out.println("Process " + process_to_remove.getProcess_id() + " finished at time " +  currentTime );
				System.out.println("\n");
			}else{
				//If the queue is empty time goes one by one
				currentTime+=1;
			}
		}
		
		System.out.println("Total wait time = "+totalWaitTime);
		//Get avg from waiting times
		int sum = 0;
		for (int i : avg_waiting_times) {
	         sum+=i;
	      }
		System.out.println("Average wait time = " + sum/(float)avg_waiting_times.size());
	}

	
}
