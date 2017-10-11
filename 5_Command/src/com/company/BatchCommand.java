package com.company;

public class BatchCommand implements Command {
    BatchObject batchObject;

    BatchCommand(BatchObject batchObject) {
        this.batchObject = batchObject;
    }

    @Override
    public void execute() {
        batchObject.execute();
    }

    @Override
    public void undo() {
        batchObject.undo();
    }
}
