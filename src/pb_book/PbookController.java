package pb_book;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PbookController {
	protected static void listPbook() {
		PbookDao dao = new PbookDaoOracleImpl();
		List<PbookVo> list = dao.getList();
		// Iterator √ﬂ√‚
		Iterator<PbookVo> it = list.iterator();
		
		while (it.hasNext()) {
			PbookVo vo = it.next();
			System.out.printf("%d , %s , %s, %s%n", vo.getId(),vo.getName(),
					vo.getHp(),vo.getTel());
		}
		System.out.println();
	}
	
	protected static void searchPbook() {
		Scanner scanner= new Scanner(System.in);
		System.out.print("SEARCH: ");
		String keyword = scanner.next();
		
		PbookDao dao = new PbookDaoOracleImpl();
		List<PbookVo> list = dao.search(keyword);
		Iterator<PbookVo> it = list.iterator();
		while(it.hasNext()) {
			PbookVo vo = it.next();
			System.out.println(vo);
		}
//		scanner.close();
		
	}
	protected static void insertPbook() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("NAME: ");
		String name = scanner.next();
		System.out.print("H.P: ");
		String hp = scanner.next();
		System.out.print("TEL: ");
		String tel = scanner.next();
		
		PbookVo vo = new PbookVo(name,hp,tel);
		PbookDao dao = new PbookDaoOracleImpl();
		boolean success = dao.insert(vo);
		System.out.println(success ? "Added success":"ERROR");
//		scanner.close();
		
	}
	protected static void deletePbook() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("DELETE ID: ");
		long id = scanner.nextLong();
		PbookDao dao = new PbookDaoOracleImpl();
		boolean success = dao.delete(id);
		System.out.println(success ? "Deleted success":"ERROR");
//		scanner.close();
	}
	

	
	

}
