import java.util.*;
import java.io.*;	
abstract class Widget{
	private int width,height;
	public Widget(int x,int y){
		width = x;
		height = y;
	}
	public int get_width(){
		return width;
	}
	public int get_height(){
		return height;
	}
	public void register(panel p){

	}
}