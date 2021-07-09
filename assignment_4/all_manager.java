import java.util.*;
import java.io.*;
public class all_manager{
	public static void main(String[] args) {
		int f = 0,x = 0,y = 0;
		panel p = new panel(600,800);
		textbox t = new textbox(400,200);
		button b=  new button(200,100);
		p.addWidget(t,100,300);
		p.addWidget(b,250,100);
		Scanner u = new Scanner(System.in);
		while(f == 0){
			String si = u.next();
			if(si.equals("MoveTo")){
				x = u.nextInt();
				y = u.nextInt();
				p.moveTo(x,y);
			}
			else if(si.equals("MouseClick")){
				p.onClick(x,y);
			}
			else if(si.equals("KeyPressed")){
				char c = u.next().charAt(0);
				p.onKbdEvent(c);
			}
			else{
				f = 1;
			}
		}
	}
}