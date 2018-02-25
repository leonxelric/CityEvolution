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
			cities[i] = new NewCity(this, (double) random(200, 5000), (double)random(200, 5000), 
					(double)random(0.8f, 1.2f), (double) random(0, 1800), (double) random(0, 900));
		}
	}
	
	public void draw()
	{	
		for(int i = 0; i < amount; i++)
		{
			cities[i].passDay();
			cities[i].drawCity();
			
			if(dist(mouseX, mouseY, (int) cities[i].getxPos(), (int) cities[i].getyPos()) <= cities[i].getSize()/2)
				cities[i].drawInfo();
		}
	}
	
	public void mousepressed()
	{
		ellipse(mouseX, mouseY, 100, 100);
	}
}