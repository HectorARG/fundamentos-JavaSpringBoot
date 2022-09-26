package com.fundamentos.springboot.fundamentos;

import com.fundamentos.springboot.fundamentos.been.MyBean;
import com.fundamentos.springboot.fundamentos.been.MyBeanWhitPrperties;
import com.fundamentos.springboot.fundamentos.been.MyBeanWithDependency;
import com.fundamentos.springboot.fundamentos.component.ComponentDependency;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWhitPrperties myBeanWhitPrperties;

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	public FundamentosApplication(
			@Qualifier("componentTwoImplement") ComponentDependency componentDependency,
			MyBean myBean,
			MyBeanWithDependency myBeanWithDependency,
			MyBeanWhitPrperties myBeanWhitPrperties
	){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWhitPrperties = myBeanWhitPrperties;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWhitPrperties.function());
		LOGGER.error("Esto es un error del log");
		LOGGER.info("Mensaje informativo de informacion");
		LOGGER.debug("Mensaje informativo debug");
	}
}
