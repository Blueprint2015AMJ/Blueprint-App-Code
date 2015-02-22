import java.util.Date;

public class SleepCalculator 
{
	
	double assignmentHours; //down to the 0.25 hour
	double studyHours; //down to the 0.25 hour
	int age;
	Date currentTime;//# of minutes since midnight, or find this time from android API 
	Date wakeUpTime; // what time they must wake up to go to school
	Date startTime; //when they will start work

	public SleepCalculator(double assignmentHours, double studyHours, int age, Date currentTime, Date wakeUpTime, Date startTime)
	{
		this.assignmentHours = assignmentHours;
		this.studyHours = studyHours;
		this.age = age;
		this.currentTime = currentTime;
		this.wakeUpTime = wakeUpTime;
		this.startTime = startTime;
	}
	
}
