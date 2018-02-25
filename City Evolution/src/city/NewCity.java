package city;

import processing.core.PApplet;

public class NewCity
{
    private PApplet parent;
    private double posX, posY;
    private double population;
    private double buildings;
    private double foodSupply;
    private double growthRate;
    private double size;
   
    public NewCity(PApplet p, double pop, double foodSupp, double growth, double xPos, double yPos)
    {
        parent = p;
        population = pop;
        foodSupply = foodSupp;
        growthRate = growth;
        posX = xPos;
        posY = yPos;
    }
   
    public void passDay()
    {
    	foodSupply -= population;
    	
    	if(foodSupply < 0)
    		population += foodSupply;
    	
    	population *= growthRate;
    	size = population / 100;
    	changeFood(200);
    }
    
    public void changeFood(double newFood)
    {
    	foodSupply += newFood;
    }
   
    public void drawCity()
    {
        parent.fill(255);
        parent.ellipse((float)posX, (float)posY, (float)size, (float)size);
    }
 
    public double getSize()
    {
        return size;
    }
    
    public double getPop()
    {
    	return population;
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
    	parent.text("Size: " + size + "\nPopulation: " + population
    			+ "\nFood Supply" + foodSupply, 260, 300);
    }
}
