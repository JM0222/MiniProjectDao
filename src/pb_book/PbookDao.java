package pb_book;

import java.util.List;

public interface PbookDao {
	
	public List<PbookVo> getList();
	
	public List<PbookVo> search(String keyword);
	
	public boolean insert(PbookVo vo);
	
	public boolean delete(Long id);
	
}
