package hunre.it.libraryy.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import hunre.it.libraryy.Entity.Taikhoan;
import hunre.it.libraryy.Responitory.TaikhoanReponsitory;
@Service
public class TaikhoanServices implements UserDetailsService {
	@Autowired
	private TaikhoanReponsitory repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Taikhoan tk=repo.findByUsername(username).orElseThrow(() 
				-> new UsernameNotFoundException("User not found"));
		return User.builder()
				.username(tk.getUsername())
				.password(tk.getPassword())
				.roles("ADMIN") 
				.build();
	}
	

}
