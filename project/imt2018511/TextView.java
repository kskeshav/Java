package imt2018511;
import animation.SceneObject;
import animation.View;

public class TextView extends View {

	@Override
	public void clear() {
		System.out.println(" Clearing View \n");
	}

	@Override
	public void render(SceneObject s) {
		System.out.println("Object " + s.getObjName() + " at " + s.getPosition().getX()+","+s.getPosition().getY());
	}

}
