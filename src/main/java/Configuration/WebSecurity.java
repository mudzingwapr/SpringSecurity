package Configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
	@Autowired
	private DataSource dataSource;
	@Autowired
	private BCryptPasswordEncoder bcrp;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		//create database connection 
		.dataSource(dataSource)
		//fetch uname,pwd,enabled using username

		.usersByUsernameQuery("select uname,upwd,from usrtab where uname=?")
		//fetch un, role using username input entered

		.authoritiesByUsernameQuery("select uname,urole from usertab where uname=?")
		//prvde password encorcoder object ref
		.passwordEncoder(bcrp);

	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/home").permitAll()
		.antMatchers("/welcome").authenticated()
		.antMatchers("/employ").hasAuthority("EMPLOYEE")
		.antMatchers("/student").hasAuthority("STUDENT")
		.antMatchers("/admin").hasAuthority("ADMIN")
		.anyRequest().authenticated()


		.and()
		.formLogin()
		.defaultSuccessUrl("/welcome",true)

		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))

		.and()
		.exceptionHandling()
		.accessDeniedPage("/denied")

		;


	}



}
