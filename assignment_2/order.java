package assignment_2;
import java.util.Scanner;
import java.util.*;
import java.io.*; 
//import assignment_2.*;
class order{
	String item;
	int quantity;
	int o_id;
	public order(String i,int q,int oid){
		item = i;
		quantity = q;
		o_id = oid;
	}
	public int get_quantity(){
		return quantity;
	}
	public String get_item(){
		return item;
	}
	public int get_order_id(){
		return o_id;
	}
}
