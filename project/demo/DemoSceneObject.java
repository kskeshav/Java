package demo;

import java.util.ArrayList;

import animation.BBox;
import animation.Point;
import animation.SceneObject;

public class DemoSceneObject extends SceneObject {

	private Point cp,dp;
	private DemoBBox b;
	private static int count;
	private ArrayList<SceneObject> actors;
	private ArrayList<SceneObject> obstacles;

	@Override
	public String getObjName() {
		// TODO Auto-generated method stub
		String name = "object"
		return "";
	}

	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		return cp;
	}

	@Override
	public void setPosition(int x, int y) {
		// TODO Auto-generated method stub
		cp.setPos(x,y);	
	}

	public void setDestPosition(int x, int y) {
		dp.setPos(x,y);
	}
	
	@Override
	public BBox getBBox() {
		// TODO Auto-generated method stub
		b = new DemoBBox(cp,this.getOutline().get(2));
		return b;
	}

	@Override
	protected ArrayList<Point> getOutline() {
		// TODO Auto-generated method stub
		ArrayList<Point> outline = new ArrayList<Point>();
		outline.add(cp);
		Point tp = new Point(cp.getX()+5,cp.getY());
		outline.add(tp);
		tp.setPos(cp.getX()+5,cp.getY()+5);
		outline.add(tp);
		tp.setPos(cp.getX(),cp.getY()+5);
		outline.add(tp);
		return outline;
	}
	private boolean moveup(int deltaT){
		int ox = cp.getX();
		int oy = cp.getY();
		for(int i = 1;i<=deltaT;i++){
			setPosition(cp.getX(),cp.getY()+i);
			if(collide()){
				setPosition(ox,oy);
				return false;
			}
		}
		return true;
	}
	private void movedown(int deltaT){
		int ox = cp.getX();
		int oy = cp.getY();
		for(int i = 1;i<=deltaT;i++){
			setPosition(cp.getX(),cp.getY()-i);
			if(collide()){
				setPosition(ox,oy);
				return false;
			}
		}
		return true;
	}
	private void moveright(int deltaT){
		int ox = cp.getX();
		int oy = cp.getY();
		for(int i = 1;i<=deltaT;i++){
			setPosition(cp.getX()+i,cp.getY());
			if(collide()){
				setPosition(ox,oy);
				return false;
			}
		}
		return true;
	}
	private void moveleft(int deltaT){
		int ox = cp.getX();
		int oy = cp.getY();
		for(int i = 1;i<=deltaT;i++){
			setPosition(cp.getX()-i,cp.getY());
			if(collide()){
				setPosition(ox,oy);
				return false;
			}
		}
		return true;
	}
	private boolean collide(){
		for(int i = 0;i<actors.size();i++)
		{
			if(actors().get(i) != this)
				{
					if(getBBox().intersects(actors.get(i).getBBox()))
					{
						return true;
					}
				}	
			for(int j=0;j<obstacles.size();j++)
			{
				if(getBBox().intersects(obstacles.get(j).getBBox()))
				{
					return true;
				}
			}
		}
		return false;
	}
	@Override
	protected void updatePos(int deltaT) {
		int deltaX,deltaY;
		if(deltaT/100<Math.abs(dp.getX()-cp.getX())){
		 	deltaX = Math.abs(dp.getX()-cp.getX());
		}
		else{
		 	deltaX = deltaT/100;
		}
		if(deltaT/100<Math.abs(dp.getY()-cp.getY())){
		 	deltaY = Math.abs(dp.getY()-cp.getY());
		}
		else{
		 	deltaY = deltaT/100;
		}
		actors = DemoScene.getScene().getActors();
		obstacles = DemoScene.getScene().getObstacles();
		if(cp.getX()<dp.getX()){
			if(!(moveright(deltaX))){
				if(!(moveup(deltaY))){
					if(!(movedown(deltaY))){

					}
				}
			}
			
		}
		else if(cp.getX()>dp.getX()){
			if(!(moveleft(deltaX))){
				if(!(moveup(deltaY))){
					if(!(movedown(deltaY))){

					}
				}
			}
		}
		else if(cp.getY()<dp.getY()){
			if(!(moveup(deltaY))){
				if(!(moveright(deltaX))){
					if(!(moveleft(deltaX))){

					}
				}
			}
		}
		else if(cp.getY()>dp.getY()){
			if(!(movedown(deltaY))){
				if(!(moveright(deltaX))){
					if(!(moveleft(deltaX))){

					}
				}
			}
		}
	}

}
