package io.useraccount;

import io.useraccount.api.util.DatabaseLoader;
import io.useraccount.api.entities.UserEntity;
import io.useraccount.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableSwagger2
public class Swagger2SpringBoot implements CommandLineRunner {

	private static final Logger log = (Logger) LoggerFactory.getLogger(Swagger2SpringBoot.class);


	@Autowired
	UserRepository userRepository;

	@Autowired
	DatabaseLoader databaseLoader;


	@Override
	public void run(String... arg0) throws Exception {
		if (arg0.length > 0 && arg0[0].equals("exitcode")) {
			throw new ExitException();
		}
	}

	public static void main(String[] args) throws Exception {
		new SpringApplication(Swagger2SpringBoot.class).run(args);
	}

	class ExitException extends RuntimeException implements ExitCodeGenerator {
		private static final long serialVersionUID = 1L;

		@Override
		public int getExitCode() {
			return 10;
		}

	}

	//See what we have in the database
	@PostConstruct
	void seeTheRoster(){
		for(UserEntity userEntity : userRepository.findAll()){
			log.info(userEntity.toString());
		}
	}

}
