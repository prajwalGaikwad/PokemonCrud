package com.work.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.work.demo.model.Ash;
import com.work.demo.repository.AshRepository;

@Service
public class AshService {

	@Autowired
	private AshRepository ashRepo;
	
	public Ash create(Ash ash) {
		return ashRepo.save(ash);
	}
	
	
	public Ash getAsh(Integer ashId) {
		Optional<Ash> findById = ashRepo.findById(ashId);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}
	
	public List<Ash> findAll(int page, int limit) {
		if(page > 0) page = page-1;
		
		Pageable pageableRequest= PageRequest.of(page, limit);
		
		Page<Ash> ashPage = ashRepo.findAll(pageableRequest);
		
		List<Ash> ashs = ashPage.getContent();
		
		if(ashs!=null && !ashs.isEmpty()) {
		  return ashs;
		}
		return ashs;

	}
	
	public String delete(Integer ashId) {
		try {
			ashRepo.deleteById(ashId);
		} catch (Exception e) {
			return "ash is not exist for id :" + ashId;
		}

		return "ash is deleted for :" + ashId;
	}
	
	public Ash update(Ash ash) {
		Optional<Ash> findById = ashRepo.findById(ash.getAshId());
		if (findById.isPresent()) {
			return  ashRepo.save(ash);
		} else {
			return null;
		}

	}
}

