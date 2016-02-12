package application.types;

import application.graphics.sprite;

public class TWeapon {
	private String name;
	private int weight, count, capacity;
	private TCircle area;
	private sprite sprite, projectile;
	private double power;
	
	public TWeapon()
	{
		sprite = new sprite();
		projectile = new sprite();
	}
	
	public double calculate_damage(TPoint impact, TPlayer enemy)
	{
		if (!enemy.solid())
			return 0;

		double damage = (1 - impact.distance(enemy.getSprite().boundaries(), false) / area.getRadius()) * power; 	
		return damage > 0 ? damage : 0;
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
	
	public double getPower()
	{
		return power;
	}

	public String getName() {
		return name;
	}
}
