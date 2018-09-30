package sv.com.jvides.models.services;

import java.util.List;

import sv.com.jvides.models.entities.Medicamento;;

public interface IMedicamentoService {
public List<Medicamento> findAll();
	
	public void save(Medicamento medicamento);
	
	public Medicamento findOne(Long id);
	
	public void delete(Long id);
}

