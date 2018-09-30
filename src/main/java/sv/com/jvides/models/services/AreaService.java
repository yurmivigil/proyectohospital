package sv.com.jvides.models.services;

import java.util.List;

import sv.com.jvides.models.entities.Area;

public interface  AreaService {


	public List<Area> findAll();
	
	public void save(Area area);
	
	public Area findOne(Long id);
	
	public void delete(Long id);
}
