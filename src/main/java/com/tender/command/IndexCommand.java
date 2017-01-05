package com.tender.command;

import com.tender.servlet.ControllerHelper;

/**
 * Created by Денис on 05.01.2017.
 */
public class IndexCommand extends ActionCommand {
    @Override
    public String execute(ControllerHelper controllerHelper) {
        MainCommand mainCommand = new MainCommand();
        return mainCommand.execute(controllerHelper);
    }
}
