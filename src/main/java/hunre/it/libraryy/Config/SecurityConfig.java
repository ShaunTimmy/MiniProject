package hunre.it.libraryy.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import hunre.it.libraryy.Services.TaikhoanServices;

@Configuration
public class SecurityConfig {
	@Autowired
	private TaikhoanServices services;

	@Bean
	public BCryptPasswordEncoder passBcry() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(services);
		authProvider.setPasswordEncoder(passBcry());
		return authProvider;
	}
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(auth->auth
				.requestMatchers("/login",  "/register","/thuvien/search","/css/**").permitAll()
				.anyRequest().authenticated()
				)
		.formLogin(form-> form
				.loginPage("/login")
				.defaultSuccessUrl("/thuvien", true)
				.permitAll()
				)
		
		.logout(logout->logout
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login?logout")
				.permitAll())
		.csrf(csrf -> csrf
	            .ignoringRequestMatchers("/thuvien/search") // loại bỏ CSRF nếu cần POST
	    );
			
		return http.build();
	}
}
