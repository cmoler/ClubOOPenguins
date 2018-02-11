package Model.Map.AreaEffect;

import Model.Entity.Entity;

public class LevelUpAreaEffect extends AreaEffect{

    public LevelUpAreaEffect(){}

    public void affect(Entity entity) {
        int experienceToAdd = entity.getExperienceForNextLevel() - entity.getExperience();
        entity.gainExperience(experienceToAdd+1);
    }
}
