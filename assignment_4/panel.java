import java.util.*;
import java.io.*;
public class panel extends Widget implements MouseWatcher,KeyboardWatcher{
	private ArrayList<Widget> widgets = new ArrayList<Widget>();
	private ArrayList<KeyboardWatcher> keyboard_widgets = new ArrayList<KeyboardWatcher>();
	private ArrayList<MouseWatcher> mouse_widgets = new ArrayList<MouseWatcher>();
	private ArrayList<Integer> xs = new ArrayList<Integer>();
	private ArrayList<Integer> ys = new ArrayList<Integer>();
	private MouseWatcher pw;
	private MouseWatcher cw;
	private int cpx = 0,cpy = 0;
	public panel(int x,int y){
		super(x,y);
	}
	public void addMouseWatcher(MouseWatcher m){
		mouse_widgets.add(m);
	}
	public void addKeyboardWatcher(KeyboardWatcher k){
		keyboard_widgets.add(k);
	}
	public void addWidget(Widget w,int x,int y){
		widgets.add(w);
		xs.add(x);
		ys.add(y);
		if(w instanceof textbox){
			w.register(this);
		}
		if(w instanceof button){
			w.register(this);
		}

	}
	public void moveTo(int x,int y){
		if(pw != null){
			pw.onExit();
		}
		for(MouseWatcher mw:mouse_widgets){
			Widget w = mw.getWidget();
			int i = widgets.indexOf(w);
			int px = xs.get(i);
			int py = ys.get(i);

			if(corresponding_widget(w,x,y,px,py) == 1){
				cw = mw;
				cw.onEnter();
				cpx = px;
				cpy = py;
				pw = cw;
				break;
			}
		}	
	}
	public int corresponding_widget(Widget w,int x,int y,int px,int py){
		if(px<=x&&x<=(px+w.get_width()) && (py)<=y&&y<=(py+w.get_height())) {
			return 1;
		}
		return 0;
	}
	public void onClick(int x,int y){
		if(cw != null){
			x-= cpx;
			y-= cpy;
			cw.onClick(x,y);
		}
	}
	public void onKbdEvent(char x){
		for(KeyboardWatcher kw : keyboard_widgets){
			kw.onKbdEvent(x);
		}
	}
	public void onExit(){

	}
	public void onEnter(){

	}
	public Widget getWidget(){
		return this;
	}
}