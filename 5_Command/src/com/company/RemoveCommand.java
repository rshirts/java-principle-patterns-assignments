package com.company;

public class RemoveCommand implements Command {
    RemoveObject removeObject;

    RemoveCommand(RemoveObject removeObject) {
        this.removeObject = removeObject;
    }

    @Override
    public void execute() {
        removeObject.remove();
    }

    @Override
    public void undo() {
        removeObject.add();
    }
}
