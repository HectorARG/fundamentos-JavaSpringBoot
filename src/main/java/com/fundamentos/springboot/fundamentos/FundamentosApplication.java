package com.fundamentos.springboot.fundamentos;

import com.fundamentos.springboot.fundamentos.been.MyBean;
import com.fundamentos.springboot.fundamentos.been.MyBeanWhitPrperties;
import com.fundamentos.springboot.fundamentos.been.MyBeanWithDependency;
import com.fundamentos.springboot.fundamentos.component.ComponentDependency;
import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWhitPrperties myBeanWhitPrperties;
	private UserRepository userRepository;

	private final Log logger = LogFactory.getLog(this.getClass());

	public FundamentosApplication(
			@Qualifier("componentTwoImplement") ComponentDependency componentDependency,
			MyBean myBean,
			MyBeanWithDependency myBeanWithDependency,
			MyBeanWhitPrperties myBeanWhitPrperties,
			UserRepository userRepository
	){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWhitPrperties = myBeanWhitPrperties;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		this.ejemplosAnteriores();
		this.saveUserInDataBase();
		this.getInformationJpqlFromUser("marisol@domain.com");
	}

	public void saveUserInDataBase(){
		User user1 = new User("John", "john@domain.com", LocalDate.of(2021, 3, 13));
		User user2 = new User("Marco", "marco@domain.com", LocalDate.of(2021, 12, 8));
		User user3 = new User("Daniela", "daniela@domain.com", LocalDate.of(2021, 9, 8));
		User user4 = new User("Marisol", "marisol@domain.com", LocalDate.of(2021, 6, 18));
		User user5 = new User("Karen", "karen@domain.com", LocalDate.of(2021, 1, 1));
		User user6 = new User("Carlos", "carlos@domain.com", LocalDate.of(2021, 7, 7));
		User user7 = new User("Enrique", "enrique@domain.com", LocalDate.of(2021, 11, 12));
		User user8 = new User("Luis", "luis@domain.com", LocalDate.of(2021, 2, 27));
		User user9 = new User("Paola", "paola@domain.com", LocalDate.of(2021, 4, 10));
		List<User> list = Arrays.asList(user1,user2,user3,user4,user5,user6,user7,user8,user9);
		list.stream().forEach(this.userRepository::save);
	}

	private void getInformationJpqlFromUser(String email){
		logger.info("User with method findMyUserByEmailNative: " + userRepository.findByUserEmail("marco@domain.com")
				.orElseThrow(() -> new RuntimeException("No se encontro el usuario por el email dado")));

		userRepository.findByAndSort("M", Sort.by("id").descending())
				.stream()
				.forEach(user -> logger.info("Usuarios con metodo sort: " + user));
	}

	private void ejemplosAnteriores(){
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWhitPrperties.function());
		logger.error("Esto es un error del log");
		logger.info("Mensaje informativo de informacion");
		logger.debug("Mensaje informativo debug");
	}
}
