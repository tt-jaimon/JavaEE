/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sna.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Jaimon TT
 */
@Named(value = "indexController")
@RequestScoped
public class IndexController {

    private String pageTitle;

    public IndexController() {
        // Set the page title 
        pageTitle = "Save Native Animals";
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }
}