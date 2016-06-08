
package cs425.mum.MUMScrum.service;

import java.util.List;
import cs425.mum.MUMScrum.domain.ProductBackLogRelease;

public interface ProductBackLogReleaseService {
	public void saveProductBackLogRelease(ProductBackLogRelease release);
	public List<ProductBackLogRelease> getAllProductBackLogReleases();
	public ProductBackLogRelease getAllProductBackLogReleasesById(long id);
	public void deleteProductBackLogReleaseById(long id);
}
