package cn.sz.zl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableScheduling       //启动时间计划
@EnableTransactionManagement    //启动事物管理
public class NewGBk31Application {

	public static void main(String[] args) {
		SpringApplication.run(NewGBk31Application.class, args);
	}
}
