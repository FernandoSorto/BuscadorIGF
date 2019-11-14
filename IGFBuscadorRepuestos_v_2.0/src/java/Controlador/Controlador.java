/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Config.Conexion;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
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
public class Controlador {
    Conexion con = new Conexion();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(con.conectar());
    ModelAndView mav = new ModelAndView();
    
    @RequestMapping("index.htm")
    public ModelAndView Listar( 
                @RequestParam(value = "identificadorRep", required = false) String repId){
        
        
        //Si no hay string
        if(repId == null || repId.equals("")){
            String sql = "SELECT * FROM repuesto";
            List datos = this.jdbcTemplate.queryForList(sql);
            mav.addObject("lista", datos);
            mav.setViewName("index");
            return mav;
        }
        else{
           String sql = "SELECT * FROM repuesto WHERE repuesto.nombre = ?";
           List datos = this.jdbcTemplate.queryForList(sql, repId);
           mav.addObject("lista", datos);
           mav.setViewName("index");
           return mav; 
        }   
    }
    
    @RequestMapping(value = "registrarse.htm", method = RequestMethod.GET)
    public String redirect(){
        return "registrarse";
    }
    
    
}
