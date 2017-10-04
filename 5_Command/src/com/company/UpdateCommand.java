package com.company;

public class UpdateCommand implements Command {
    UpdateObject updateObject;

    UpdateCommand(UpdateObject updateObject) {
        this.updateObject = updateObject;
    }

    @Override
    public void execute() {
        updateObject.update();
        //todo: remove this
        System.out.println("Added Object.");
    }

    @Override
    public void undo() {
        updateObject.undo();
    }
}
