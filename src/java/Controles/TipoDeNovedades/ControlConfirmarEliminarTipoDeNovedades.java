package Controles.TipoDeNovedades;

import Modelos.Conectar;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


public class ControlConfirmarEliminarTipoDeNovedades {
    
    private JdbcTemplate jdbcTemplate;
    
    public ControlConfirmarEliminarTipoDeNovedades(){
        
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar());
        
    }
    
    @RequestMapping("confirmareliminartipodenovedades.htm")
    public ModelAndView novedades(HttpServletRequest request){
        
        int id_novedad=Integer.parseInt(request.getParameter("id_novedad"));
        this.jdbcTemplate.update("delete from nm_tipo_novedad where id_novedad=?",id_novedad);
        return new ModelAndView("redirect:/tipodenovedades.htm");
    
    }
    
}
