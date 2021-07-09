//package assignment_2;
import java.util.Scanner;
import java.util.*;
import java.io.*; 
import assignment_2.store;
public class manager{
	public static void main(String[] args) {
		Scanner uinput = new Scanner(System.in);
		int b = uinput.nextInt();
		int d = uinput.nextInt();
		store s = new store(b,d);
		int f = 0;
		while(f == 0){
			String item = uinput.next();
			if(!(item.equals("End"))){
				int q = uinput.nextInt();
				s.get_order(item,q);
			}
			else{
				s.get_order(item,0);
				f = 1;
			}
		}
		s.print_orders();
	}
}