package demo;
import java.util.*;
import animation.Scene;
public class DemoScene extends Scene{
	private ArrayList<SceneObject> obstacles;
	private ArrayList<SceneObject> actors;
	public DemoScene(){
		super();
	}
	protected void checkScene(){
		actors = getActors();
	}
}