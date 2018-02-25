package city;
 
import processing.core.PApplet;
 
public class City
{
    private PApplet parent;
    public double posX, posY;
    public int young, adult, old;
    double size;
    boolean isHostile;
    int foodSupply = 200; // 1 = enough food for 1 person a day
    public int[] jobs;
   
    public City(PApplet p, int y, int a, int o, int sz, int house, int pX, int pY)
    {
        parent = p;
        young = y;
        adult = a;
        old = o;
        size = sz;
//        posX = parent.random(0, 1801);
//        posY = parent.random(0, 901);
        posX= pX;
        posY= pY;
    }
   
    public void passDay(int newFood)
    {
    	System.out.println(foodSupply);
        if(foodSupply < (young + adult + old))
        {
            int diff = (young + adult + old) - foodSupply;
            young -= diff/3;
            adult -= diff/3;
            old -= diff/3;
        }
        
        foodSupply -= (young + adult + old);
    	System.out.println(foodSupply);
        foodSupply += newFood;
    	System.out.println(foodSupply);
       
        int changeInPop;
        int totalPop = (young + adult + old);
        System.out.println("total pop: " + totalPop);
        changeInPop = (int)(adult * .00016);
        System.out.println("change in pop: " + changeInPop);
        young += changeInPop;
        changeInPop = (young / 18);
        System.out.println("change in pop: " + changeInPop);
        young -= changeInPop;
        adult += changeInPop;
        changeInPop = (adult / 40);
        System.out.println("change in pop: " + changeInPop);
        adult -= changeInPop;
        old += changeInPop;
        old -= totalPop * .000021;
       
        int workers = calculateWorkers(totalPop);
        int jobs = totalPop / 2;
        
        int wwj = getWorkersWithJobs(workers, jobs);//wwj is workers with jobs
        
        int buildings = wwj/450;
        int houses = buildings * 2/3;
        
        int houseDemand = old/2 + (young + adult)/4;
        
        if(houseDemand > houses)
        {
        	int diff = houses - houseDemand;
        	adult -= (diff/10) * 2/3;
        	old -= (diff/10) * 1/3;
        }
        
        growCity(buildings);
    }
   
    public void growCity(double newBuildings)
    {
    	System.out.println("growth: " + newBuildings/10);
    	size += newBuildings/10;
    	System.out.println("size: " + size);
    }
   
    public int getWorkersWithJobs(int workers, int jobs)
    {
    	int WWJ = 0; //Workers With Jobs
    	if(workers <= jobs)
    		WWJ = workers;
    	else if(workers > jobs)
    		WWJ = jobs;
    	return WWJ;
    }
    
    public int calculateWorkers(int total)
    {
        int workers = 0;
        workers += (total * 5 / 8);
        workers *= .7;
        return workers;
    }
   
    public void drawCity()
    {
        parent.fill(255, 0, 0);
        parent.ellipse((float)posX, (float)posY, (float)size, (float)size);
    }
 
    public double getSize()
    {
        return size;
    }
 
    public int getYoung()
    {
        return young;
    }
   
    public int getAdult()
    {
        return adult;
    }
   
    public int getOld()
    {
        return old;
    }
}