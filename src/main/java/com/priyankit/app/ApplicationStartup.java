
package com.priyankit.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priyankit.app.bo.People;
@RestController
@SpringBootApplication
public class ApplicationStartup {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationStartup.class, args);
	}
	
	@RequestMapping("/getinfo")
	public List<People> getInfo(){
		
		List<People> peoples=new ArrayList<People>();
		People people=new People();
		people.setId(1);
		people.setName("Priyankit");
		peoples.add(people);
		return peoples;
		
		
	}
}
