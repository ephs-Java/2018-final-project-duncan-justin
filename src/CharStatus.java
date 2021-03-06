

import java.util.ArrayList;

public class CharStatus {
	
	private int hitpoints;
	private int nonLethal;
	private boolean conscious;
	private ArrayList<Integer> effectIdList;
	
	public CharStatus(int h){
		hitpoints = h;
		nonLethal = 0;
		conscious = true;
		effectIdList = new ArrayList<>();
	}
	
//getters
	
	public int getHealth(){
		return hitpoints;
	}
	public int getNonlethal(){
		return nonLethal;
	}
	public boolean isConscious(){
		return conscious;
	}
	public boolean effectActive(int e){
		for(int id: effectIdList){
			if(id == e){
				return true;
			}
		}
		return false;
	}
	public ArrayList<Integer> getEffectList(){
		return effectIdList;
	}
	
//setters
	
	public void changeHealth(int h){
		hitpoints += h;
	}
	public void setNonlethal(int n){
		nonLethal = n;
	}
	public void changeNonlethal(int n){
		nonLethal += n;
		if (nonLethal >= hitpoints) {
			conscious = false;
		}
	}
	public void startEffect(int id){
		effectIdList.add(id);
	}
	public void endEffect(int id){
		effectIdList.remove(id);
	}
	
	public void setHealth(int h){
		hitpoints = h;
	}
}
