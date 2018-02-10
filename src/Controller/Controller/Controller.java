package Controller.Controller;

import Model.Map.Direction;

public interface Controller {

    void handleEscape();
    void handleI();
    void handleE();
    void handleNumpad(Direction direction);


}