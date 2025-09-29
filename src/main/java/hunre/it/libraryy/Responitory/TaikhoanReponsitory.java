package hunre.it.libraryy.Responitory;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import hunre.it.libraryy.Entity.Taikhoan;

public interface TaikhoanReponsitory extends JpaRepository<Taikhoan, Long> {
	Optional<Taikhoan> findByUsername(String username);
}
