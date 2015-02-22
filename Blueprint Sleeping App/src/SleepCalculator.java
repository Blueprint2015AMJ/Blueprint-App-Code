import java.text.SimpleDateFormat;
import java.util.Date;

public class SleepCalculator 
{
	
	double assignmentHours; //down to the 0.25 hour
	double studyHours; //down to the 0.25 hour
	int age;
	int wakeUpTime; // what time they must wake up to go to school
	int startTime; //when they will start work
	
	double whenToSleep;
	double whenToWakeUp;
	double sleepHours;
	double recommendedSleeptime;
	
	//TODO: add in errors at the end
	public SleepCalculator(double assignmentHours, double studyHours, int age, String wakeUpTime, String startTime)
	{
		this.assignmentHours = assignmentHours;
		this.studyHours = studyHours;
		this.age = age;
		
		this.wakeUpTime = 60 * Integer.parseInt(wakeUpTime.substring(0, 2)) + Integer.parseInt(wakeUpTime.substring(3, 5));
		this.startTime = 60 * Integer.parseInt(startTime.substring(0, 2)) + Integer.parseInt(startTime.substring(3, 5));
	
		if(age <= 5) {
			this.recommendedSleeptime = 12*60;
		}
		else if(age <= 12) {
			this.recommendedSleeptime = 10.5 * 60;
		}
		else if(age <=18) {
			this.recommendedSleeptime = 9 * 60;
		}
		else {
			this.recommendedSleeptime = 7.5 * 60;
		}
		
	}
	
	
	
	public double[] whenToandSleepHours() //returns sleepHours and whenToSleep
	{ 
		if((startTime + assignmentHours * 60 + studyHours * 60) <= (wakeUpTime + 24 * 60) - recommendedSleeptime)
		{
			this.sleepHours = this.recommendedSleeptime;
			this.whenToSleep = this.wakeUpTime + 24 * 60 - recommendedSleeptime;
			this.whenToWakeUp = this.wakeUpTime;
			
		}
		
		else 
		{
			
			this.whenToSleep = 22 * 60;
			double workLeft = startTime + assignmentHours * 60 + studyHours * 60 - 22*60; 
			this.whenToWakeUp = (24 *60 + wakeUpTime) - workLeft;
			this.sleepHours = whenToWakeUp - whenToSleep;
			
			double adjustment = this.sleepHours % 90;
			
			if(adjustment != 0) {
				
				if(adjustment < 0)
				{
					this.sleepHours -=(90 + adjustment);
				}
				
				else
				{
					this.sleepHours -= adjustment;
				}
				this.whenToWakeUp += adjustment;
			}
		}
		
		if(sleepHours/ 60 > 24)
		{
			sleepHours = sleepHours % (24*60);
		}
		
		else if(whenToSleep /60 > 24)
		{
			whenToSleep = (whenToSleep) % (24*60);
		}
		
		else if (whenToWakeUp/60 > 24)
		{
			whenToWakeUp = (whenToWakeUp) % (24*60);
		}
		
		double [] valueArray = {sleepHours/60, whenToSleep/60, whenToWakeUp/60};
		
		return valueArray;
		
		
		
	}
	
	public static void main(String [] args)
	{
		SleepCalculator adi = new SleepCalculator(5, 2, 15, "05:30", "16:30");
		double [] awesomearray = adi.whenToandSleepHours();
		
		for(int i = 0; i < 3; i ++)
		{
			System.out.println(awesomearray[i]);
		}
	}
}	