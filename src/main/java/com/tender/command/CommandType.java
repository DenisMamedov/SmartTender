package com.tender.command;

/**
 * Created by Денис on 05.01.2017.
 */
public enum CommandType {

    MAIN {
        {
        this.command = new MainCommand();
    }
    },
    INDEX {
        {
            this.command = new IndexCommand();
        }
    },
    ;
    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
