package application.ai;

import application.types.TPoint;
import application.types.TPointArray;

import java.util.Random;
import application.types.TPlayer;
import application.settings.*;
import application.math.*;
import application.misc.randoms;

@SuppressWarnings("unused")
public class ai {
	
	
	private double prev_angle, cur_angle, prev_power, cur_power;
	private int current_weapon, last_health_player;
	private TPoint last_hit, desired;
	private TPointArray prev_hits;
	private boolean initial_hit_done, previous_hitted, adjust_angle, adjust_speed, switch_weapon;
	private TPlayer enemy;
	
	public ai()
	{
		last_hit = new TPoint(-1, -1);
		last_health_player = current_weapon = -1;
		prev_angle = cur_angle = 0.0;
	}
	
	public void reset_variables()
	{
	}
	
	public void randomize()
	{
		
	}
	
	public void aim()
	{
		/*
			-- the whole brain of the ai --
		 */
	
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
		if (enemy.getPosition().distance(last_hit) > 40)
			return -1;
		
		return 0;
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
