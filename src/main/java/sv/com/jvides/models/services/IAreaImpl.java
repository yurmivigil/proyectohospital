package sv.com.jvides.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sv.com.jvides.models.dao.IAreaDao;
import sv.com.jvides.models.dao.IAreaDao;
import sv.com.jvides.models.entities.Area;

@Service
public class IAreaImpl implements AreaService{


	@Autowired
	private IAreaDao areaDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Area> findAll() {		
		return (List<Area>) areaDao.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Area findOne(Long id) {		
		return areaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void save(Area area) {
		areaDao.save(area);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		areaDao.deleteById(id);
	}
}
