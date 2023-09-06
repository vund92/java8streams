package flatmapdemos;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.crypto.dsig.keyinfo.KeyValue;

public class Demo1 {

	public static void main(String[] args) {
		
		//map()
		
		List<Integer> list1=Arrays.asList(1,2,3,4,5,6);
		List<Integer> list2= list1.stream().map(n->n+10).collect(Collectors.toList());
		System.out.println(list2); //[11, 12, 13, 14, 15, 16]
		
		//flatMap()
		List<Integer> lst1=Arrays.asList(1,2);
		List<Integer> lst2=Arrays.asList(3,4);
		List<Integer> lst3=Arrays.asList(5,6);
		
		
		List<List<Integer>>finallist=Arrays.asList(lst1,lst2,lst3);
		
		List<Integer> finalresults=finallist.stream().flatMap(x->x.stream().map(n->n+10)).collect(Collectors.toList());
		
		System.out.println(finalresults);
		
		List<Integer> finalresultss=finallist.stream().flatMap(x->x.stream()).collect(Collectors.toList());
		
		System.out.println(finalresultss);
		
		
		// Phan nay la demo cua Generics, chen vo thu code vay thoi --> https://gpcoder.com/2868-huong-dan-su-dung-java-generics/
		KeyValuePair<String, Integer> entry = new KeyValuePair<String, Integer>("gpcoder", 123456789);
        String name = entry.getKey();
        Integer id = entry.getValue();
        System.out.println("Name = " + name + ", Id = " + id); // Name = gpcoder, Id = 123456789

        ContactEntry entry2 = new ContactEntry("gpcoder", 123456789);
        String name2 = entry2.getKey();
        Integer id2 = entry2.getValue();
        System.out.println("Name = " + name2 + ", Id = " + id2); // Name = gpcoder, Id = 123456789
	}

}

class KeyValuePair<K, V> {
    private K key;
    private V value;
 
    public KeyValuePair(K key, V value) {
        this.key = key;
        this.value = value;
    }
 
    public K getKey() {
        return key;
    }
 
    public void setKey(K key) {
        this.key = key;
    }
 
    public V getValue() {
        return value;
    }
 
    public void setValue(V value) {
        this.value = value;
    }
}

class ContactEntry extends KeyValuePair<String, Integer> {
	 
    public ContactEntry(String key, Integer value) {
        super(key, value);
    }
 
}
