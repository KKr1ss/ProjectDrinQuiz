/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectdrinquiz.WebHandlers;

import com.mycompany.projectdrinquiz.WebHandlers.Base.WebHandler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.Scanner;
import javax.swing.text.Document;
/**
 *
 * @author kkris
 */
public class Web_NapiKvizHandler extends WebHandler {

    @Override
    protected List<String> convertWebPageStringToList(String webResult) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
