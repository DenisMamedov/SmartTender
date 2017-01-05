package com.tender.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Денис on 02.01.2017.
 */
public interface ICommand {

    String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
