
public class Process  implements Comparable<Process> {

	private int process_id;
	private int priority;
	private int arrivalTime;
	private int duration;
	private int waitTime;
	private int totalWaitTime;
	
	 public Process() {
	   }
	
	public Process(int process_id,int priority,int arrivalTime,int duration) {
		   this.process_id = process_id;
		   this.priority = priority;
		   this.arrivalTime = arrivalTime;
		   this.duration=duration;
		   this.waitTime=0;
		   this.totalWaitTime=0;
	   }
	
	public int getProcess_id() { return process_id; }   
	public int getPriority() { return priority; }
	public int getArrivalTime() { return arrivalTime; }
	public int getDuration() { return duration; }
	public int getWaitTime() { return waitTime; }
	public int getTotalWaitTime() { return totalWaitTime; }
	
	public void setWaitTime(int newWaitTime) {  
		this.waitTime= newWaitTime; 
	}
	
	public void setTotalWaitTime(int newTotalWaitTime) {  
		this.totalWaitTime= newTotalWaitTime; 
	}
	
	public void setPriority(int newPriority) {  
		this.priority= newPriority; 
	}
	   
	public String toString() {
		   String p =
					"\tId = " + process_id +
		            "\tPriority = " + priority +
		            "\tArrival = " + arrivalTime +
		            "\tDuration = " + duration+
		            "\tWaitTime = " + waitTime 
		            ;
		   return p;
	   }
	public String toString2() {
		   String p =
					"Process\tId = " + process_id + "\n"+
		            "\tPriority = " + priority + "\n"+
		            "\tArrival = " + arrivalTime + "\n"+
		            "\tDuration = " + duration;
		   return p;
	   }
	public String toString3() {
		   String p =
					"Process\tId = " + process_id + "\n"+
		            "\tPriority = " + priority + "\n"+
		            "\tArrival = " + arrivalTime + "\n"+
		            "\tWaitTime = " + waitTime + "\n"+
		            "\tTotalWaitTime = " + totalWaitTime + "\n"+
		            "\tDuration = " + duration;
		   return p;
	   }

	@Override
	public int compareTo(Process o) {
		if (this.getPriority() == o.getPriority() ) {
			return 0;
		}
		else {
			return 1;
		}
		//return this.getPriority().compareTo(o.getPriority());
	}

}
