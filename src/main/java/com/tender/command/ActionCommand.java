package com.tender.command;

import com.tender.servlet.ControllerHelper;

/**
 * Created by Денис on 05.01.2017.
 */
public abstract class ActionCommand {
    public abstract String execute(ControllerHelper controllerHelper);
}
