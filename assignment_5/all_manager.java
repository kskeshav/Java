import java.util.*;
public class all_manager{
	public static void main(String[] args) {
		analyzer a = new analyzer();
		int f = 0;
		Scanner u = new Scanner(System.in);
		String instring = u.nextLine();
		String[] words = instring.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
		List<String> lw = Arrays.asList(words);
		for(ListIterator<String> it = lw.listIterator(); it.hasNext(); ){
			a.add(it.next());
		}
		a.prints();
	}
}