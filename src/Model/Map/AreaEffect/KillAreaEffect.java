package Model.Map.AreaEffect;

import Model.Entity.Entity;

public class KillAreaEffect extends AreaEffect{

    public KillAreaEffect(){}

    public void affect(Entity entity) {
        entity.takeDamage(entity.getHealth());
        // dependent on Entity's default health level
    }
}

