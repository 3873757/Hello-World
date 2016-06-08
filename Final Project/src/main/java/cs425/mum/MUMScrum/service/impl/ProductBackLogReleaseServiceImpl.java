package cs425.mum.MUMScrum.service.impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cs425.mum.MUMScrum.domain.ProductBackLogRelease;
import cs425.mum.MUMScrum.domain.ReleaseBacklog;
import cs425.mum.MUMScrum.repository.ProductBacklogRepository;
import cs425.mum.MUMScrum.repository.ReleaseRepository;

import cs425.mum.MUMScrum.service.ProductBackLogReleaseService;

@Service
@Transactional
public class ProductBackLogReleaseServiceImpl implements ProductBackLogReleaseService {

	@Autowired
	private ReleaseRepository releaseRepository;
	private ProductBacklogRepository ProductBacklogRepository;
	
	public void saveProductBackLogRelease(ProductBackLogRelease release) {
	
		releaseRepository.save(release);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<ProductBackLogRelease> getAllProductBackLogReleases() {
		return (List<ProductBackLogRelease>)releaseRepository.findAll();
	}

	public ProductBackLogRelease getAllProductBackLogReleasesById(long id) {
		return releaseRepository.findOne(id);
	}


	public void deleteProductBackLogReleaseById(long id) {
		releaseRepository.delete(id);
	}



	 public void CreateProductBL(ReleaseBacklog productBacklog){
		 ProductBacklogRepository.save(productBacklog);
	    }
	

}
