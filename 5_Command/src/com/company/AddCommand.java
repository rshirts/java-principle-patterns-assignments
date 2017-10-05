package com.company;

public class AddCommand implements Command {
    AddObject addObject;

    AddCommand(AddObject addObject) {
        this.addObject = addObject;
    }

    @Override
    public void execute() {
        addObject.add();
    }

    @Override
    public void undo() {
        addObject.remove();
    }
}
