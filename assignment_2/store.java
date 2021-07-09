package assignment_2;

import java.util.Scanner;
import java.util.*;
import java.io.*; 
import assignment_2.*;
public class store{
	private int no_of_bakeries,no_of_dairies,bi = 0,di = 0,o_id = 0;
	ArrayList<bakery> bakeries = new ArrayList<bakery>(no_of_bakeries);
	ArrayList<dairy> dairies = new ArrayList<dairy>(no_of_dairies);
	public store(int b,int d){
		no_of_dairies = d;
		no_of_bakeries = b;
		for(int id = 0;id<no_of_bakeries;id++){
			bakery nb = new bakery(id);
			bakeries.add(nb);	  	
		}
		for(int id = 0;id<no_of_dairies;id++){
			dairy nd  = new dairy(id);
			dairies.add(nd);	  	
		}
	}
	public void get_order(String oi,int oq){
		if(!oi.equals("End")){
			o_id +=1;
			order o = new order(oi,oq,o_id);
			if(o.get_item().equals("Bread") || o.get_item().equals("Cake") 
				|| o.get_item().equals("Muffin")){
				(bakeries.get(bi%no_of_bakeries)).get_order_b(o);
				bi +=1;
			}
			else{
				dairies.get(di%no_of_dairies).get_order_d(o);
				di+=1;
			}
		}
	}
	public void print_orders(){
		for (int i = 0;i<no_of_bakeries ;i++ ) {
			System.out.println((bakeries.get(i)).toString());
		}
		for (int i = 0;i<no_of_dairies ;i++ ) {
			System.out.println((dairies.get(i)).toString());
		}
	}
}
