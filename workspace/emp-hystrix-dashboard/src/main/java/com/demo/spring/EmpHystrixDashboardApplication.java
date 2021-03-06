package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class EmpHystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpHystrixDashboardApplication.class, args);
	}
}
