public class label extends Widget implements KeyboardWatcher{
	public label(int x,int y){
		super(x,y);
	}
	public void onKbdEvent(char x){

	}
	public Widget getWidget(){
		return this;
	}
}