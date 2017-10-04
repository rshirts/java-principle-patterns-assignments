package com.company;

public class AddCommand implements Command {
    AddObject addObject;

    AddCommand(AddObject addObject) {
        this.addObject = addObject;
    }

    @Override
    public void execute() {
        addObject.add();
        //todo: remove this
        System.out.println("Added Object.");
    }

    @Override
    public void undo() {
        addObject.remove();
    }
}
