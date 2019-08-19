package com.system.utils;

import org.springframework.web.servlet.view.InternalResourceView;

import java.io.File;
import java.util.Locale;

/**
 * @Author: Alex
 * @Date: 2019/8/19 9:12
 */
public class HtmlResourceView extends InternalResourceView {
    @Override
    public boolean checkResource(Locale locale){
        File file = new File(this.getServletContext().getRealPath("/") + getUrl());
        return file.exists();
    }
}
