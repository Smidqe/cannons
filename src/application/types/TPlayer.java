package application.types;

import java.util.ArrayList;
import application.settings.constants;
import application.debug.debug;
import application.graphics.sprite;

public class TPlayer {
	private int health, hits, hits_taken, shots, damage;
	private boolean solid;
	
	private ArrayList<TWeapon> weapons;
	private TPoint position;
	private String name;
	private TWeapon weapon;
	private sprite sprite;
	
	public TPlayer(int health)
	{
		this.health = health;
		this.hits = this.hits_taken = this.shots = this.damage = 0;
	}

	public void modify(int value, int amount)
	{
		int modified = 0;
		
		switch(value)
		{
			case constants.PLAYER_VALUE_HEALTH: modified = this.health += amount; 
				break;
			case constants.PLAYER_VALUE_HITS: modified = this.hits += amount; 
				break;
			case constants.PLAYER_VALUE_HITS_TAKEN: modified = this.hits_taken += amount; 
				break; 
			case constants.PLAYER_VALUE_SHOTS: modified = this.shots += amount; 
				break;
			case constants.PLAYER_VALUE_DAMAGE: modified = this.damage += amount; 
				break;
		}
		
		set(value, modified);
	}
	
	public void set(int value, int amount)
	{
		switch(value)
		{
			case constants.PLAYER_VALUE_HEALTH: this.health = amount; 
				break;
			case constants.PLAYER_VALUE_HITS: this.hits = amount; 
				break;
			case constants.PLAYER_VALUE_HITS_TAKEN: this.hits_taken = amount; 
				break; 
			case constants.PLAYER_VALUE_SHOTS: this.shots = amount; 
				break;
			case constants.PLAYER_VALUE_DAMAGE: this.damage = amount; 
				break;
		}
	}
	
	public TWeapon find_weapon(String name)
	{
		for (TWeapon w : weapons)
			if (w.getName().equals(name))
				return w;
		
		return null;
	}
	
	public void switch_weapon(int index)
	{
		this.weapon = weapons.get(index);
	}
	
	public void switch_weapon(String name)
	{
		this.weapon = find_weapon(name);
		
		if (this.weapon == null)
		{
			this.weapon = weapons.get(0);
			debug.log.entry(true, "Weapon: " + name + " not found resetting to default to weapon.");
		}
	}
	
	public int getHitsTaken()
	{
		return this.hits_taken;
	}
	
	public int getShots()
	{
		return this.shots;
	}
	
	public int getHits()
	{
		return this.hits;
	}
	
	public int getDamage()
	{
		return this.damage;
	}
	
	public sprite getSprite()
	{
		return this.sprite;
	}
	
	public TPoint getPosition() 
	{
		return position;
	}
	
	public TWeapon getWeapon()
	{
		return this.weapon;
	}
	
	public ArrayList<TWeapon> getWeapons()
	{
		return this.weapons;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getHealth()
	{
		return health;
	}

	public boolean solid() {
		// TODO Auto-generated method stub
		return this.solid;
	}
}
