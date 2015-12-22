
package cs425.mum.MUMScrum.service;

import java.util.List;
import cs425.mum.MUMScrum.domain.ReleaseBacklog;

public interface ReleaseBacklogservice {
     
	public List<ReleaseBacklog> getAllReleaseBacklogs();
	public ReleaseBacklog getProductBacklogId(long id);
	public void deleteProductBacklogById(long id);
	public void saveProductBacklog(ReleaseBacklog productBacklog);

	

}