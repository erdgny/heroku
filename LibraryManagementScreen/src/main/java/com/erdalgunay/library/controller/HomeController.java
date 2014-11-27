package com.erdalgunay.library.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

/**
 * Created with IntelliJ IDEA.
 * User: erdalgunay
 * Date: 26/11/14
 * Time: 15:31
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping
    public String getHomePage() {
        return "redirect:/books";
    }

}
