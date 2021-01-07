
public class Fighter extends Heroes{
	
	public Fighter(String Name, int AttackDamage, int Defense, int HitChance) {
		super(Name, "Fighter", AttackDamage, Defense, 0, HitChance);
	}

	@Override
	public String UniqueAbility() {
		this.AttackDamage = AttackDamage + 10;
		return "ARGHHHHHHHHHHHHHHHHHHHHHHHH! MY ATTACK IS NOW " + this.AttackDamage;
	}

	public String toString() {
		return "Name: " + this.Name + "\nHero Type: " + this.HeroType + "\nExp: " + this.Exp + "\nLevel: " + this.Level + "\nAttackDamage: " + this.AttackDamage + "\nDefense: " + this.Defense + "\nHealth: " + this.Health + "\nMagic Damage: " + this.MagicDamage + "\nHit Chance: " + this.HitChance + "\n";
	}


}
