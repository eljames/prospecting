package br.prospecting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.prospecting.bal.Origin;
import br.prospecting.repository.DBException;
import br.prospecting.repository.OriginRepository;

@Service
public class OriginServiceImpl implements OriginService {
	
	@Autowired
	private OriginRepository originRep;

	@Transactional
	@Override
	public void saveOrigin(Origin origin) throws DBException {
		originRep.save(origin);
	}

	@Override
	public void getOrigin(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Origin> getOriginList() {
		return null;
		
	}

	@Override
	public void updateOrigin(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeOrigin(Origin origin) {
		// TODO Auto-generated method stub
		
	}
	
	
}
