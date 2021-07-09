public class button extends Widget implements MouseWatcher{
	private int pointer = 0;
	public button(int x,int y){
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
	public void register(panel p){
		p.addMouseWatcher(this);
	}
	public void onClick(int x,int y){
		if(pointer == 1){
			System.out.println("Selected point:"+x+" "+y);
		}
	}

}