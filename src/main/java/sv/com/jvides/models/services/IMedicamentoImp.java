package sv.com.jvides.models.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sv.com.jvides.models.dao.MedicamentoDao;
import sv.com.jvides.models.entities.Medicamento;

@Service
public class IMedicamentoImp implements IMedicamentoService{

	@Autowired
	private MedicamentoDao medicamentoDao;

	@Override
	@Transactional(readOnly=true)
	public List<Medicamento> findAll() {
		// TODO Auto-generated method stub
		return (List<Medicamento>) medicamentoDao.findAll();
	}

	@Override
	public void save(Medicamento medicamento) {
		// TODO Auto-generated method stub
		medicamentoDao.save(medicamento);
		
	}

	@Override
	public Medicamento findOne(Long id) {
		// TODO Auto-generated method stub
		return medicamentoDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		medicamentoDao.deleteById(id);
		
	}
	
}
