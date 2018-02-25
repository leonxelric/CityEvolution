package city;
 
import processing.core.PApplet;
 
public class City
{
    private PApplet parent;
    private double posX, posY;
    private double young, adult, old;
    private double size;
    private double buildings;
    private double foodSupply;
   
    public City(PApplet p, double y, double a, double o, double house, 
    		double pX, double pY, double foodSupp, double builds)
    {
        parent = p;
        young = y;
        adult = a;
        old = o;
        posX= pX;
        posY= pY;
        buildings = builds;
        foodSupply = foodSupp;
    }
    
    public void changePop()
    {
    	if(foodSupply < (young + adult + old))
        {
            double diff = ((young + adult + old) - foodSupply);
            young -= diff/3;
            adult -= diff/3;
            old -= diff/3;
        }
    	
    	foodSupply -= (young + adult + old);
        foodSupply += newFood;
        
        double changeInPop;
        double totalPop = (young + adult + old);
        
        changeInPop = (adult * .05555);
        System.out.println("change in pop: " + changeInPop);
        young += changeInPop;
        
        changeInPop = (young / 18);
        
        young -= changeInPop;
        adult += changeInPop;
        changeInPop = (adult / 40);
        
        adult -= changeInPop;
        old += changeInPop;
        old -= totalPop * .000021;
    }
   
    public void passDay(int newFood)
    {
        double workers = calculateWorkers(young + adult + old);
        double jobs = (young + adult + old) / 2;
        
        changePop(newFood);
        
        double wwj = getWorkersWithJobs(workers, jobs);
        double houses = buildings * 2/3;
        
        double houseDemand = old/2 + (young + adult)/4;
        
        if(houseDemand > houses)
        {
        	buildings += wwj/450;
        	double diff = houses - houseDemand;
        	adult -= (diff/10) * 2/3;
        	old -= (diff/10) * 1/3;
        }
        
        size = (old + young + adult)/100;
        //size = buildings/10;
    }
   
    public void growCity(double newBuildings)
    {
    	System.out.println("growth: " + newBuildings/10);
    	size += newBuildings/10;
    	System.out.println("size: " + size);
    }
   
    public double getWorkersWithJobs(double workers, double jobs)
    {
    	double WWJ = 0;
    	
    	if(workers <= jobs)
    		WWJ = workers;
    	else if(workers > jobs)
    		WWJ = jobs;
    	
    	return WWJ;
    }
    
    public double calculateWorkers(double total)
    {
        double workers = (total * 5 / 8);
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
 
    public double getYoung()
    {
        return young;
    }
   
    public double getAdult()
    {
        return adult;
    }
   
    public double getOld()
    {
        return old;
    }
    
    public double getxPos()
    {
        return posX;
    }
    
    public double getyPos()
    {
        return posY;
    }
    
    public void drawInfo()
    {
    	parent.fill(125, 125);
    	parent.rect(250, 100, parent.width - 500, parent.height - 200);
    	parent.fill(0);
    	parent.textSize(50);
    	parent.text("Size: " + size + "\nPopulation: " + (young + adult + old), 260, 300);
    }
}