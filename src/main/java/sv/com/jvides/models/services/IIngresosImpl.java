package sv.com.jvides.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sv.com.jvides.models.dao.IIngresoDao;
import sv.com.jvides.models.entities.Ingresos;

@Service
public class IIngresosImpl implements IIngresosService{


	@Autowired
	private IIngresoDao ingresoDao;
	@Override
	@Transactional(readOnly=true)
	public List<Ingresos> findAll() {		
		return (List<Ingresos>) ingresoDao.findAll();
	}
	@Override
	@Transactional(readOnly=true)
	public Ingresos findOne(Long id) {		
		return ingresoDao.findById(id).orElse(null);
	}
	@Override
	@Transactional
	public void save(Ingresos ingresos) {
		ingresoDao.save(ingresos);
	}
	@Override
	@Transactional
	public void delete(Long id) {
		ingresoDao.deleteById(id);
	}

}
