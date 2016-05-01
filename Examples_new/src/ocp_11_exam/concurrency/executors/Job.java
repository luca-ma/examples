package ocp_11_exam.concurrency.executors;

public class Job implements Runnable{

	private String jobName ="";
	@Override
	public void run() {
		System.out.println("ENTER JOB:"+this.jobName+" THread:"+Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("EXIT JOB :"+this.jobName+" after 1 sec");
	}
	public Job(String jobName) {
		super();
		this.jobName = jobName;
	}
	
	public void modJobName(String newJbName){
		this.jobName = newJbName;
	}
	
	

}
