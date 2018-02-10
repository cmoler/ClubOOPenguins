package Controller.Controller;

import Model.Map.Direction;

public class EquipmentController implements Controller {

    private MainController mainController;

    public EquipmentController(MainController mainController){
        this.mainController = mainController;
    }

    @Override
    public void handleEscape() {
        System.out.println("PRESSED ESCAPE while in EQUIpment");
    }

    @Override
    public void handleI() {

    }

    @Override
    public void handleE() {

    }

    @Override
    public void handleNumpad(Direction direction) {

    }

}