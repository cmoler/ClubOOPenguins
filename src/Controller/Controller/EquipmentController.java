package Controller.Controller;

import Model.Map.Direction;

public class EquipmentController implements Controller {

    private MainController mainController;


    public EquipmentController(MainController mainController){
        this.mainController = mainController;
    }

    @Override
    public void handleEscape() {

    }

    @Override
    public void handleI() {

    }

    @Override
    public void handleEnter() {

    }

    @Override
    public void handleNumpad(Direction direction) {
        //does nothing now
    }

}