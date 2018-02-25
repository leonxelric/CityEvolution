package city;

import processing.core.PApplet;

public class CityRunner extends PApplet
{
	int amount = 30;
	NewCity[] cities = new NewCity[amount];
			
	public static void main(String[] args)
	{
		PApplet.main("city.CityRunner");
	}
	
	public void settings()
	{
		size(1800, 900);
	}
	
	public void setup()
	{
		for(int i = 0; i < amount; i++)
		{
			cities[i] = new NewCity(this, 1000, 1000, 1.01, random(0, width), random(0, height));
		}
	}
	
	public void draw()
	{	
		background(0);
		
		for(int i = 0; i < amount; i++)
		{
			cities[i].passDay();

	    	System.out.println("population: " + cities[i].getPop() + "  " + i);
	    	System.out.println("food supply: " + cities[i].getFoodSupply());
			cities[i].drawCity();
			
			if(dist(mouseX, mouseY, (int) cities[i].getxPos(), (int) cities[i].getyPos()) <= cities[i].getSize()/2)
				cities[i].drawInfo();
		}
	}
}