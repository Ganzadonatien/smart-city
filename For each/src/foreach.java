
 
public class foreach {

    static int summation(int x , int y)
    {
        return x+y;
    }
    static int summation(int x ,int y , int z)
    {
        return x+y+z;
    }
    static void summation(String name , int x)
    {
        System.out.println(name +" has "+x+"  Years old" );
    }
     
    public static void main(String[] args) {
        System.out.println(summation(12,34));
        System.out.println(summation(12,21,14));
        summation("Aline",20);
      
    }
}
