package hackerank;

import java.util.*;

public class Map_Hackerank {
	public static void main(String []argh)
	{
        Map<String,Integer> map = new Hashtable<String, Integer>();
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		in.nextLine();
		for(int i=0;i<n;i++)
		{
			String name=in.nextLine();
			int phone=in.nextInt();
            in.nextLine();
			map.put(name, phone);
		}
        
        int q = in.nextInt();
        for(int i=0; i<q;i++){
            String nameKey = in.nextLine();
            for(String name : map.keySet()){
                if(name == nameKey){
                    System.out.println(map.get(name));
                }
            }
        }
		
        in.close();
	}
}
