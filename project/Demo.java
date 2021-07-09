import animation.*;
import imt2018511.*;
import java.util.*;

// Driver class to set up and exercise the animation
public class Demo {

	public static void main(String[] args) {
		Scene scene = new DemoScene();
		scene.setView(new TextView()); // can be replaced with other Views that will be provided
		
		// populate the scene with objects implemented by the team
		for(int i=1;i<6;i++) {
			SceneObject s = new DemoSceneObject();
			s.setPosition(i*5, i*5);  
			scene.addObstacle(s); // using appropriate derived classes
		}
			
		for(int i=0;i<6;i++) {
			SceneObject s = new DemoSceneObject();
			s.setPosition(50 - i*5, 30 + i*5);  // these will be changed for the demo
			s.setDestPosition(0, 0);
			scene.addActor(s); // using appropriate derived classes
		}
		
		scene.animate();
	}

}
