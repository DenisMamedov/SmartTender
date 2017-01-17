package com.tender.controller;

import com.tender.command.*;
import com.tender.entity.Supplier;
import com.tender.service.ServiceManager;
import com.tender.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * Created by Денис on 11.01.2017.
 */
public class ControllerHelper {

    private static ControllerHelper instance = null;

    HashMap<String, ICommand> commands = new HashMap<>();
    HashMap<String, ICommand> adminCommands = new HashMap<>();

    private ControllerHelper() {
        commands.put("/", new CommandTender());
        commands.put("/registration", new CommandRegistration());
        commands.put("/login", new CommandLogin());
        commands.put("/logout", new CommandLogout());
        commands.put("/viewTender", new CommandViewTender());
        commands.put("/save", new CommandSave());
        commands.put("/history", new CommandShowHistory());
    }

    public ICommand getCommand(HttpServletRequest request) {

        String role = getRoleFromSession(request);
        ICommand command = null;

        if (role.equals("user"))
            command = commands.get(request.getParameter("command"));
        else if (role.equals("admin"))
            command = adminCommands.get(request.getParameter("command"));
        if (command == null)
            command = new CommandTender();
        return command;
    }

    private String getRoleFromSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String role = null;
        UserService userService = (UserService) ServiceManager.getService(UserService.class);
        if (session == null) {
            return "user";
        }
        role = userService.getRoleFromSession((Supplier) session.getAttribute("user"));
        return role;
    }

    public static ControllerHelper getInstance() {
        if (instance == null) {
            instance = new ControllerHelper();
        }
        return instance;
    }
}
