package cs425.mum.MUMScrum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cs425.mum.MUMScrum.domain.ReleaseBacklog;
import cs425.mum.MUMScrum.repository.ProductBacklogRepository;
import cs425.mum.MUMScrum.service.ReleaseBacklogservice;

@Service
@Transactional
public class ReleaseBacklogserviceImpl implements ReleaseBacklogservice {
	
	@Autowired
	private ProductBacklogRepository productBacklogRepository;

	public List<ReleaseBacklog> getAllReleaseBacklogs() {
		return (List<ReleaseBacklog>)this.productBacklogRepository.findAll();
		
	}

	
	public void saveProductBacklog(ReleaseBacklog productBacklog) {
		this.productBacklogRepository.save(productBacklog);
		
	}

	@Override
	public ReleaseBacklog getProductBacklogId(long id) {
		// TODO Auto-generated method stub
		return this.productBacklogRepository.findOne(id);
	}

	
	@Override
	public void deleteProductBacklogById(long id) {
		// TODO Auto-generated method stub
		this.productBacklogRepository.delete(id);
	}

	
}
