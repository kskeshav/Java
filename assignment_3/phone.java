//package net;
import java.util.*;
abstract class phone{
	private int number,on_call = 0,c_number;
	private network c_network;
	private String modem_manufacturer;
	public phone(int n,String modem){
		number = n;
		modem_manufacturer = modem;
	}
	public void add_to_network(network net){
		net.add_number(this);
		c_network = net;
	}
	public int get_number(){
		return number;
	}
	public String get_modem(){
		return modem_manufacturer;
	}
	String recieve_call(int n){
		if(on_call == 0){
			c_number = n;
			on_call = 1;
			return "successful"; 	
		}
		return "not successfull";
	}
	public void hang_up(){
		on_call = 0;
	}
	public String call_request(int n){
		if(on_call == 1){
			return "not successfull";
		}
		else{
			if(c_network.c_request(this,n).equals("successful")){
				c_number = n;
				on_call = 1;
				return "successful";
			}
			else{
				return "not successful";
			}
		}
	}
	public int get_on_call(){
		return on_call;
	}
	public void request_hangup(){
		if(on_call == 1){
			hang_up();
			c_network.hangup_request(c_number);
		}
	}	
}