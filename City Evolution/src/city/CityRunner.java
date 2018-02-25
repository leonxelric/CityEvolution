package city;

import processing.core.PApplet;

public class CityRunner extends PApplet
{
	int amount = 15;
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
			cities[i] = new NewCity(this, random(200, 2000), random(200, 2000), random(0.9f, 1.1f));
		}
	}
	
	public void draw()
	{
		background(75, 150, 75);
		
		for(int i = 0; i < amount; i++)
		{
			cities[i].drawCity();
			cities[i].passDay();
			
			if(dist(mouseX, mouseY, (int) cities[i].getxPos(), (int) cities[i].getyPos()) <= cities[i].getSize()/2)
				cities[i].drawInfo();
		}
	}
}