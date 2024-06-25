package day19;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Job{
	int id;
	int deadline;
	int profit;
	
	Job(int id, int deadline,int profit){
		this.id=id;
		this.deadline=deadline;
		this.profit=profit;
	}
	public String toString() {
		return "Job{"+"id="+ id +",deadline="+deadline+",profit="+profit+ "}";
		
	}
}


public class JobSequencing {

	public static List<Job> jobSequencing(List<Job> jobs){
		Collections.sort(jobs,(a,b) -> b.profit-a.profit);
		int maxDeadline=0;
		for(Job job : jobs) {
			if(job.deadline>maxDeadline) {
				maxDeadline=job.deadline;
			}
		}
		Job[] result=new Job[maxDeadline];
		boolean[] slot=new boolean[maxDeadline];
		
		for(Job job : jobs) {
			for(int j=Math.max(maxDeadline-1, job.deadline-1);j>=0;j--) {
				if(!slot[j]) {
					slot[j]=true;
					result[j]=job;
					break;
				}
			}
		}
		List<Job> jobSequence = new ArrayList<>();
		for(Job job : result) {
			if(job != null) {
				jobSequence.add(job);
			}
		}
		return jobSequence;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Job> jobs=new ArrayList<>();
		jobs.add(new Job(1, 4, 20));
		jobs.add(new Job(2, 1, 10));
		jobs.add(new Job(3, 1, 40));
		jobs.add(new Job(4, 1, 30));
		
		List<Job> jobSequence=jobSequencing(jobs);
		System.out.println("Scheduled jobs for maximum profit: ");
		for(Job job : jobSequence) {
			System.out.println(job);
		}
	}

}
