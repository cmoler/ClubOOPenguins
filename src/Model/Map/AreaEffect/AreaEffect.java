package Model.Map.AreaEffect;

import Model.Entity.Entity;
import Model.Map.Location;

import java.util.List;
import java.util.Timer;

public abstract class AreaEffect {

    private Timer timer;
    private boolean active;
    private List<Entity> entities;
    private Location location;

    public boolean isActive() {
        return active;
    }

    public void activate(Entity entity){

    }

    public void deActive(Entity entity){

    }

    public abstract void affect();
}
