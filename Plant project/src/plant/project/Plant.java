 /* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package plant.project;

/**
 *
 * @author Donatien
 */
public class Plant {

    /**
     * @param args the command line arguments
     */
    
    String plant_name;  //plant name
    float height;   //the height of plant
    int age_plant ;   // age of the plant
    //This is the Constructor
    public Plant(String name,float height , int age )
    {
        this.plant_name = name;
        this.height = height;
        this.age_plant = age;
    }

    private Plant() {
    }
    //The accessor part
    public String getName( )
    {
        
        return plant_name;
        
    }
    public float getHeight()
    {
        return height;
    }
    public int getAge()
    {
        return age_plant;
    }
    //The mutator 
    public void setName(String newName)
    {
        this.plant_name = newName;
        
    }
     public void setHeight(float newHeight)
    {
        this.height = newHeight;
        
    }
      public void setAge(int newAge)
    {
        this.age_plant = newAge;
        
    }
      //other method
      public void display()
      {
          System.out.println("My plant is " + plant_name + " with the Height of " + height + " long , it was been stand for " + age_plant + " Years");
      }
       
    
    public static void main(String[] args) {
        // TODO code application logic here
        Plant myproj = new Plant("mangrovee",12 ,2);
        myproj.display();
    }
    
}
