package com.tender.command;

import com.tender.servlet.ControllerHelper;

/**
 * Created by Денис on 05.01.2017.
 */
public class ActionFactory {

    public ActionCommand defineCommand(ControllerHelper controllerHelper){
        ActionCommand current = null;
        String action = controllerHelper.getParameter("command");
        if(action == null || action.isEmpty()){
            return null;
        }
        CommandType currentEnum = CommandType.valueOf(action.toUpperCase());
        current = currentEnum.getCurrentCommand();
        return current;
    }
}
