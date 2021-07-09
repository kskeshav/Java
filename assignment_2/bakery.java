package assignment_2;

import java.util.Scanner;
import java.util.*;
import java.io.*;
//import assignment_2.*;
class bakery{
	int id;
	ArrayList<order> orders = new ArrayList<order>();
	public bakery(int b_id){
		id = b_id +1;
		order dorder = new order("do",0,0);
		orders.add(dorder);
	}
	public void get_order_b(order o){
		for (int i = 0;i<orders.size();i++) {
			if(o.get_quantity()>(orders.get(i)).get_quantity()){
				orders.add(i,o);
				break;
			}
		}
	}
	public String toString(){
		String str = "Bakery " + (id) + "\n";
		for (int i = 0;i<orders.size()-1;i++ ) {
		 	str += "Order " + (orders.get(i)).get_order_id() + " "+
		 	(orders.get(i)).get_item() +" "+ (orders.get(i)).get_quantity() + "\n";
		} 
		return str;
	}
}
