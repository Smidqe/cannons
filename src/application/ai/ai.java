package application.ai;

import application.types.TPoint;
import application.types.TPointArray;

import java.util.Random;
import application.types.TPlayer;
import application.settings.*;
import application.math.*;
import application.misc.randoms;

@SuppressWarnings("unused")

class THitInfo
{
	private TPoint impact;
	private boolean hit;
	private double angle, power;
	
	THitInfo()
	{
		this.impact = new TPoint(-1, -1);
	}

}

@SuppressWarnings("unused")
public class ai extends TPlayer{
	
	
	private double prev_angle, cur_angle, prev_power, cur_power;
	private int current_weapon, last_health_player, direction;
	private TPoint last_hit, desired;
	private THitInfo history;
	private boolean initial_hit_done, previous_hitted, adjust_angle, adjust_speed, switch_weapon;
	private TPlayer enemy;
	
	public ai()
	{
		super(constants.MAX_HEALTH);
		
		last_hit = new TPoint(-1, -1);
		last_health_player = current_weapon = -1;
		prev_angle = cur_angle = 0.0;
	}
	
	public void set_enemy(TPlayer enemy)
	{
		this.enemy = enemy;
	}
	
	public void reset_variables()
	{
	}
	
	public void randomize()
	{
		
	}
	
	public void aim()
	{
		TPoint __player = this.getPosition();
		TPoint __enemy = enemy.getPosition();
		TPoint impact = new TPoint(-1, -1);
		
		if (direction == -1)
			direction = choose_direction();
		
		/*
		 	-- Progress (for the cannons)
		 		- Check the direction where does the enemy lie (always known)
		 		- Estimate the angle and the power
		 			- As turns progress the angle and power should get more accurate
		 			- Once the ideal power/angle has been found keep it, perhaps switch to a different weapon
		 				- Checks by whether the enemy has lost hp
		 			- Repeat
		 			
		 		- 
		 */
		
		enemy.modify(constants.PLAYER_VALUE_DAMAGE, (int) this.getWeapon().calculate_damage(impact, enemy));
	}
	
	public void choose_weapon()
	{
		
	}
	
	public double choose_velocity()
	{
		randoms rng = new randoms();
		
		if (previous_hitted)
			return prev_power;
		
		if (!initial_hit_done)
			return (double) rng.random(0, constants.MAX_POWER);
		
		this.choose_direction();
		
		return 0.0;
	}
	
	public int choose_direction()
	{
		return (this.getPosition().getX() > enemy.getPosition().getX()) ? 0 : 1;
	}
	
	public void set()
	{
		
	}
	
	
	
	public void result()
	{
		if (enemy.getHealth() < last_health_player)
			previous_hitted = true;
		
		if (previous_hitted && last_health_player - enemy.getHealth() < 20)
			adjust_speed = true;
			
		
		reset_variables();
	}
}
