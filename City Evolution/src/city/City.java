package city;
 
import processing.core.PApplet;
 
public class City
{
    private PApplet parent;
    public double posX, posY;
    public int young, adult, old;
    int size;
    int houses;
    boolean isHostile;
    int economy;
    int foodSupply; // 1 = enough food for 1 person a day
    public int[] jobs;
   
    public City(PApplet p, int y, int a, int o, int sz, int house, int geo, int[] job)
    {
        parent = p;
        young = y;
        adult = a;
        old = o;
        size = sz;
        houses = house;
        jobs = job; //pos1 is technology
        posX = parent.random(0, 1801);
        posY = parent.random(0, 901);
    }
   
    public void passDay(int newFood)
    {
        if(foodSupply < young + adult + old)
        {
            int diff = foodSupply - (young + adult + old);
            young -= diff/3;
            adult -= diff/3;
            old -= diff/3;
        }
        foodSupply -= (young + adult + old);
        foodSupply += newFood;
       
        int changeInPop;
        int totalPop = (young + adult + old);
        changeInPop = (int)(adult * .00016);
        young += changeInPop;
        changeInPop = (young / 18);
        young -= changeInPop;
        adult += changeInPop;
        changeInPop = (adult / 40);
        adult -= changeInPop;
        old += changeInPop;
        old -= totalPop * .000021;
       
        int workers = calculateWorkers();
        int jobs =
    }
   
    public void growCity()
    {
       
    }
   
    public int calculateWorkers()
    {
        int workers = 0;
        workers += (young/4 + adult + old/4);
        workers *= .7;
        return workers;
    }
   
    public void drawCity()
    {
        parent.fill(255, 0, 0);
        parent.ellipse((float)posX, (float)posY, size, size);
    }
 
    public int getSize()
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