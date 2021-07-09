import java.util.*;
public class analyzer{
	private List<String> words = new ArrayList<String>();
	private List<Character> alp = new ArrayList<Character>();
	public void add(String s){
		words.add(s);
	}
	public void prints(){
		List<String> rw = new ArrayList<String>();
		rw.add("groups");
		rw.add("collections");
		rw.add("elements");
		Set<String> sw = new LinkedHashSet<String>(words);
		System.out.println(sw);
		List<String> lw= new ArrayList<String>(sw);
		List<String> olw = new ArrayList<String>(lw);
		Collections.sort(lw,new a());
		System.out.println(lw);
		lw = olw;
		Collections.sort(lw,new ssize());
		System.out.println(lw);
		lw = olw;
		Collections.sort(lw,new f(words));
		System.out.println(lw);
		lw = olw;
		Collections.sort(rw,new rwa(lw));
		System.out.println(rw);
		Collections.sort(rw,new rwb(words));
		System.out.println(rw);

		/*for (ListIterator<String> it = words.listIterator();it.hasNext() ; ) {
			alp.add(it.next().charAt(0));
		}
		for(ListIterator<Character> it = alp.listIterator();it.hasNext();){
			System.out.println(it.next() + " " + Collections.frequency(alp,it.next()));
		}*/

	}
}
class ssize implements Comparator<String>{
	public int compare(String s1,String s2){
		return s1.length() - s2.length();
	}
}
class a implements Comparator<String>{
	public int compare(String s1,String s2){
		return s1.compareTo(s2);
	}
}
class f implements Comparator<String>{
	private List<String> lw;
	public f(List<String> l){
		lw = l;
	}
	public int compare(String s1,String s2){
		return (Collections.frequency(lw,s1) - Collections.frequency(lw,s2));
	}
}
class rwa implements Comparator<String>{
	private List<String> sw;
	public rwa(List<String> l){
		sw = l;
	}
	public int compare(String s1,String s2){
		return sw.indexOf(s1) - sw.indexOf(s2);
	}
}
class rwb implements Comparator<String>{
	private List<String> sw;
	public rwb(List<String> l){
		sw = l;
	}
	public int compare(String s1,String s2){
		return (Collections.frequency(sw,s2) - Collections.frequency(sw,s1));
	}
}