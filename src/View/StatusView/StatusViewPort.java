package View.StatusView;


import Model.Entity.Entity;
import View.Viewport;

import java.awt.*;

public class StatusViewPort extends Viewport {

    public StatusViewPort(Entity entity){
        add(new StatsView(entity));
    }

}
