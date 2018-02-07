package Model.Map.AreaEffect;

import Model.Entity.Entity;

public class DamageAreaEffect extends AreaEffect{

    private int damageAmount;

    public DamageAreaEffect(int damageAmount){
        this.damageAmount = damageAmount;
    }

    public void affect(Entity entity) {
        entity.takeDamage(damageAmount);
    }
}
