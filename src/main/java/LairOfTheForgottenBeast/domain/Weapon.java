package LairOfTheForgottenBeast.domain;

/**
 * Represents a weapon that can be used by a player, creature, etc.
 * 
 * @author Nick D'Orazio
 * @since 1.0.0
 *
 */
public class Weapon {
	/**
	 * The weapons hit point damage
	 */
	private int attackDamage;
	/**
	 * The name of the weapon, if customizaton is needed
	 */
	private String name;
	
	/**
	 * Constructor, default implementation
	 */
	public Weapon() {
		this("Default Weapon", 100);
	}
	
	/**
	 * Constructs a weapon with a specific name and hit points on attack.
	 * 
	 * @param name Used to set a specific name to a weapon
	 * @param damage The hit points the damage will do.
	 */
	public Weapon(String name, int damage) {
		this.name = name;
		this.attackDamage = damage;
	}
	
	/**
	 * Retrieves the specific name of the weapon
	 * 
	 * @return The name of the weapon
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gives the weapon a specific name.
	 * 
	 * @param name The name to give to the weapon
	 * @return A boolean expression (sanity check) representing if the name was successfully set.
	 */
	public boolean setName(String name) {
		if (name == null) 
			return false;
		this.name = name;
		return true;
	}
	
	/**
	 * Retrieves the hit point damage the weapon will deal.
	 * @return The numeric value of hit point damage.
	 */
	public int getDamage() {
		return attackDamage;
	}
	
	/**
	 * Sets the hit point damage this weapon will yield.
	 * 
	 * @param damage The hit point value to set to the weapon.
	 * @return A boolean expression (sanity check) if the hit point damage value was successfully set.
	 */
	public boolean setDamage(int damage) {
		if (damage <= 0) 
			return false;
		this.attackDamage = damage;
		return true;
	}
}
