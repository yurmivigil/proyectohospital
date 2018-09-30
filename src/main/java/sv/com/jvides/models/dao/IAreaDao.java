package sv.com.jvides.models.dao;


import org.springframework.data.repository.CrudRepository;

import sv.com.jvides.models.entities.Area;
import sv.com.jvides.models.entities.Customer;

public interface IAreaDao extends CrudRepository<Area, Long>  {

}
