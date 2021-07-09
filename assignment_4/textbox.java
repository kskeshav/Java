public class textbox extends Widget implements MouseWatcher,KeyboardWatcher{
	private int pointer = 0;
	private String s = "";
	public textbox(int x,int y){
		super(x,y);
		
	}
	public Widget getWidget(){
		return this;
	}
	public void moveTo(int x,int y){

	}
	public void onEnter(){
		pointer = 1;
	}
	public void onExit(){
		pointer = 0;
	}
	public void onClick(int x,int y){
		
	}
	public void register(panel p){
		p.addMouseWatcher(this);
		p.addKeyboardWatcher(this);
	}
	public void onKbdEvent(char x){
		if(pointer == 1){
			s += x;
			System.out.println(s);
		}
	}
	
}