package application.settings;

public final class constants {
	//maximum values
	public static final int MAX_POWER = 100;
	public static final int MAX_ANGLE = 90;
	public static final int MAX_HEALTH = 500;
	
	//direction constants
	public static final int DIRECTION_WEST = 0;
	public static final int DIRECTION_EAST = 1;
	
	//player constants
	public static final int PLAYER_VALUE_HEALTH = 0;
	public static final int PLAYER_VALUE_HITS = 1;
	public static final int PLAYER_VALUE_HITS_TAKEN = 2;
	public static final int PLAYER_VALUE_SHOTS = 3;
	public static final int PLAYER_VALUE_DAMAGE = 4;
	
	//for a sprite index.
	public static final int SPRITE_INDEX_CANNONS_PLAYER = 0;
	public static final int SPRITE_INDEX_CANNONS_HIGH = 1;
	
	//physics constants
	public static final double GRAVITATIONAL = 9.81;
	
	//corner constants used in various places!
	public static final int CORNER_NE = 0;
	public static final int CORNER_SE = 1;
	public static final int CORNER_SW = 2;
	public static final int CORNER_NW = 3;
	
	//constants for box sides
	public static final int SIDE_NORTH = 0;
	public static final int SIDE_EAST = 1;
	public static final int SIDE_SOUTH = 2;
	public static final int SIDE_WEST = 3;
	
	public static final int DISTANCE_START = 0;
	public static final int DISTANCE_END = 1;
	public static final int DISTANCE_BETWEEN = 2;
}
