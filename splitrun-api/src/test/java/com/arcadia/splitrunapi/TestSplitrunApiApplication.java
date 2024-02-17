package com.arcadia.splitrunapi;

import com.arcadia.splitrun.SplitrunApiApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestSplitrunApiApplication {

	public static void main(String[] args) {
		SpringApplication.from(SplitrunApiApplication::main).with(TestSplitrunApiApplication.class).run(args);
	}

}
