package imt2018511;

import java.util.*;

import animation.BBox;
import animation.Point;
import animation.SceneObject;

public class DemoSceneObject extends SceneObject {

	private Point cp,dp;
	private DemoBBox b;
	private static int count = 0;
	private ArrayList<SceneObject> actors;
	private ArrayList<SceneObject> obstacles;
	private String name;

	public DemoSceneObject(){
		name = "object"+count;
		cp = new Point(0,0);
		dp = new Point(0,0);
		count++;
	}
	@Override
	public String getObjName() {
		return name;
	}

	@Override
	public Point getPosition() {
		return cp;
	}

	@Override
	public void setPosition(int x, int y) {
		cp.setPos(x,y);	
	}

	public void setDestPosition(int x, int y) {
		dp.setPos(x,y);
	}
	
	@Override
	public BBox getBBox() {
		b = new DemoBBox(cp,this.getOutline().get(2));
		return b;
	}

	@Override
	protected ArrayList<Point> getOutline() {
		ArrayList<Point> outline = new ArrayList<Point>();
		outline.add(cp);
		Point tp = new Point(cp.getX()+1,cp.getY());
		outline.add(tp);
		tp.setPos(cp.getX()+1,cp.getY()+1);
		outline.add(tp);
		tp.setPos(cp.getX(),cp.getY()+1);
		outline.add(tp);
		return outline;
	}
	private boolean moveup(int deltaT){
		int ox = cp.getX();
		int oy = cp.getY();
		for(int i = 1;i<=deltaT;i++){
			setPosition(cp.getX(),cp.getY()+1);
			if(collide()){
				setPosition(ox,oy);
				return false;
			}
		}
		return true;
	}
	private boolean movedown(int deltaT){
		int ox = cp.getX();
		int oy = cp.getY();
		for(int i = 1;i<=deltaT;i++){
			setPosition(cp.getX(),cp.getY()-1);
			if(collide()){
				setPosition(ox,oy);
				return false;
			}
		}
		return true;
	}
	private boolean moveright(int deltaT){
		int ox = cp.getX();
		int oy = cp.getY();
		for(int i = 1;i<=deltaT;i++){
			setPosition(cp.getX()+1,cp.getY());
			if(collide()){
				setPosition(ox,oy);
				return false;
			}
		}
		return true;
	}
	private boolean moveleft(int deltaT){
		int ox = cp.getX();
		int oy = cp.getY();
		for(int i = 1;i<=deltaT;i++){
			setPosition(cp.getX()-1,cp.getY());
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
			if(actors.get(i) != this)
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
		deltaT = deltaT/100;
		if(deltaT>Math.abs(dp.getX()-cp.getX())){
		 	deltaX = Math.abs(dp.getX()-cp.getX());
		}
		else{
		 	deltaX = deltaT;
		}
		if(deltaT>Math.abs(dp.getY()-cp.getY())){
		 	deltaY = Math.abs(dp.getY()-cp.getY());
		}
		else{
		 	deltaY = deltaT;
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
