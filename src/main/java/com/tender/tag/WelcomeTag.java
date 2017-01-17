package com.tender.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by Денис on 16.01.2017.
 */
public class WelcomeTag extends SimpleTagSupport {

    private String supplierName;

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    StringWriter sw = new StringWriter();

    @Override
    public void doTag() {
        try {
            if (!supplierName.isEmpty()) {
                JspWriter out = getJspContext().getOut();
                out.println("Добро пожаловать " + supplierName);
            } else {
                getJspBody().invoke(sw);
                getJspContext().getOut().println(sw.toString());
            }

        } catch (JspException | IOException e) {
            e.printStackTrace();
        }

    }
}
