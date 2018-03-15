package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;


import edu.eci.pdsw.samples.entities.Item;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author 2106913
 */
public interface ItemMapper {
    
    
    public List<Item> consultarItems();
    
     public Item consultarItem(@Param("iditem") int id);
    
    public void insertarItem(@Param("item") Item it);

    public void insertarItem(int id, String nombre, String descripcion, Date fechaLanzamiento, long tarifaxDia, String formatoRenta, String genero, int id0);

        
}
