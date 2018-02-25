package city;

import processing.core.PApplet;

public class CityRunner extends PApplet
{
	int[] ihavenopurpose = new int[3];
	int amount = 15;
	City[] cities = new City[amount];
			
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
//		for(int i = 0; i < amount; i++)
//		{
//			cities[i] = new City(this, 0, 0, 0, 0, 0, 0, ihavenopurpose);
//		}
	}
	int food = 2000;
	City c = new City(this, 400, 800, 400, 5, 200, 500, 500);
	public void draw()
	{
		c.drawCity();
		c.passDay(food);
	}
	
	public void drawMap()
	{
		drawBiome(0, 0, 100, 150, 235, 235, 255);
	}
	
	public void drawBiome(int x, int y, int width, int height, int r, int g, int b)
	{
		fill(r, g, b);
		rect(x, y, width, height);
	}
	
	public void mouseClicked()
	{
		food += 50;
	}
}