/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Config.Conexion;


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



/**
 *
 * @author Luis
 */
@Controller
public class DBServiceController {
    
    Conexion con = new Conexion(); 
    ModelAndView mav = new ModelAndView();
    
    @RequestMapping("insertarMasivamente.htm")
    public ModelAndView extraccion(
            @RequestParam(value = "url_db", required = false) String url, 
            @RequestParam(value = "user_db", required = false) String userName,
            @RequestParam(value = "pass_db", required = false) String contrasenia) throws SQLException{
        
        ResultSet rs=null; 
        List<String> tn = new ArrayList<>();
         
        if(url!=null){
            Connection jdbcConnection = DriverManager.getConnection(url, userName, contrasenia); 
            DatabaseMetaData md = jdbcConnection.getMetaData();
            rs = md.getTables(null, null, "%", null);  
            while (rs.next()) {
                String str = rs.getString("table_name");
                tn.add(str);
            }
        } 
        mav.addObject("rs", rs);
        mav.addObject("tn", tn);
        
        mav.addObject("url_db", url);
        mav.addObject("user_db", userName);
        mav.addObject("pass_db", contrasenia);
        
        mav.setViewName("insertarMasivamente");
        return mav;
    }
    
    @RequestMapping(value="insertarMasivamente.htm", method=RequestMethod.POST, params={"tb_nam","url_db","user_db","pass_db"})
    public ModelAndView mostrarInfo(
            @RequestParam(value = "tb_nam", required = true) String tb_nam,
            @RequestParam(value = "url_db", required = false) String url_db,
            @RequestParam(value = "user_db", required = false) String user_db,
            @RequestParam(value = "pass_db", required = false) String pass_db) throws SQLException{
        
        Statement st = null;
        String query = "SELECT * FROM " + tb_nam;
        
        Connection jdbcConnection = DriverManager.getConnection(url_db, user_db, pass_db);
        st = jdbcConnection.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();
        
        ArrayList list = new ArrayList();
        ArrayList list_nom = new ArrayList();
        
        while (rs.next()){
            HashMap row = new HashMap(columns);
            for(int i=1; i<=columns; ++i){           
                row.put(md.getColumnName(i),rs.getObject(i));
            }
             list.add(row);
        }
        
        mav.addObject("rs", list);
        mav.setViewName("insertarMasivamente_2");
        return mav;
    }
    
    @RequestMapping("insertarMasivamente_2.htm")
    public ModelAndView finalizar(){
        
       
        mav.setViewName("insertarMasivamente_2");
        return mav;
    }
    
}
