package com.arcadia.splitrunworker;

import com.arcadia.splitrun.SplitrunWorkerApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestSplitrunWorkerApplication {

	public static void main(String[] args) {
		SpringApplication.from(SplitrunWorkerApplication::main).with(TestSplitrunWorkerApplication.class).run(args);
	}

}
