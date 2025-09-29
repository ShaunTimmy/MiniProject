package hunre.it.libraryy.Responitory;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.ResponseBody;

import hunre.it.libraryy.Entity.Book;
@ResponseBody
public interface BookReponsitory extends JpaRepository<Book, Long> {
	boolean existsByMasach(String masach);
	@Query("SELECT tv FROM Book tv WHERE tv.masach LIKE %:keyword%")
    List<Book> searchByName(@Param("keyword") String keyword);

}
