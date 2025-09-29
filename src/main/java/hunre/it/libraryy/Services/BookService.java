package hunre.it.libraryy.Services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hunre.it.libraryy.Entity.Book;
import hunre.it.libraryy.Responitory.BookReponsitory;


@Service
public class BookService {
	@Autowired
	public BookReponsitory repo;
	
	public List<Book> DanhsachTL(){
		return repo.findAll();
	}
	
	public Book LayTTByID(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	// thêm mới kiểm tra mã tl 
	public Book LuuTT(Book book) {
		if(repo.existsByMasach(book.masach)) {
			 throw new RuntimeException("Mã sách đã tồn tại.");
		}
		return repo.save(book);
	}
	
	public Book capNhat(Book book) {
	    return repo.save(book); 
	}

	public void XoaTT(Long id) {
		repo.deleteById(id);
	}
	//tim kiem
			public List<Book> searchByID(String keyword) {
			    return repo.searchByName(keyword);
			}


}
