//package net;
import java.util.*;
public class network{
	private ArrayList<phone> phones = new ArrayList<phone>();
	void add_number(phone p){
		phones.add(p);
	}
	String c_request(phone p1,int n){
		for(phone ip:phones){
			if(ip.get_number() == n){
				return ip.recieve_call(p1.get_number());
			}
		}
		return "not successful";
	}
	void hangup_request(int n){
		for(phone ip:phones){
			if(ip.get_number() == n){
				ip.hang_up();
			}
		}
	}
}