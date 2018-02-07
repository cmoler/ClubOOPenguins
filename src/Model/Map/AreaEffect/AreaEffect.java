package Model.Map.AreaEffect;

import Model.Entity.Entity;
import Model.Map.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AreaEffect {

    private AtomicInteger totalEntitiesOn = new AtomicInteger(0);
    private Location location;

    public boolean isActive(){
        return totalEntitiesOn.get() > 0;
    }

    public void activate(Entity entity){
        AffectEntityThread thread = new AffectEntityThread(entity);
        thread.start();
    }

    public abstract void affect(Entity entity);

    private class AffectEntityThread extends Thread {

        private long effectIntervalInSeconds = 1;
        private Entity entity;

        AffectEntityThread(Entity entity) {
            this.entity = entity;
        }

        public void run() {
            System.out.print(entity.toString() + " entered " + this.toString()); // for testing
            totalEntitiesOn.getAndAdd(1);
            while (entity.getLocation() == location) {
                affect(entity);
                try {
                    Thread.sleep(effectIntervalInSeconds * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            totalEntitiesOn.decrementAndGet();
            System.out.print(entity.toString() + " exited " + this.toString()); // for testing
        }
    }
}
