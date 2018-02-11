package Controller.Controller;

import Model.Map.Direction;

public interface Controller {

    void handleEscape();
    void handleI();
    void handleT();
    void handleEnter();
    void handleNumpad(Direction direction);


}