package application.types;

import application.graphics.sprite;

public class TWeapon {
	private int power, weight, count, capacity, radius;
	private sprite sprite, projectile;
	
	public TWeapon()
	{
		sprite = new sprite();
		projectile = new sprite();
	}
	
	public int calculate_damage(TPoint impact, TPlayer enemy)
	{
		if (impact.distance(enemy.getPosition()) > radius)
			return 0;
		
		/*
		 	--- Method::
		 		- The closer to the center (direct hit), then the power is at the maximium!
		 		
		 */
		
		return -1;
	}
	
	public void setSprite(sprite s)
	{
		this.sprite = s;
	}
	
	public boolean use()
	{
		if (count == 0)
			return false;
		
		this.count--;
		
		return true;
	}
	
	public boolean stock(int amount)
	{
		if (count == capacity)
			return false;
		
		if (count + amount > capacity)
			count += (capacity - count);
		else
			count += amount;
		
		return true;
	}
	
	public sprite getProjectile()
	{
		return this.projectile;
	}
	
	public sprite getSprite()
	{
		return this.sprite;
	}
	
	public boolean stock()
	{
		return stock(1);
	}
	
	public int getAmmoCount()
	{
		return this.count;
	}
	
	public int getWeight()
	{
		return this.weight;
	}
	
	public int getPower()
	{
		return power;
	}
}
