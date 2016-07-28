package com.priyankit.app.controller.rest;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priyankit.app.bo.People;

@RestController
public class SwaggerController {

	@ApiOperation(value = "getGreeting", nickname = "getGreeting")
	@ApiImplicitParams({
        @ApiImplicitParam(name = "name", value = "User's name", required = false, dataType = "string", paramType = "query", defaultValue="Niklas")
      })
	@ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = SwaggerController.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")}) 
	@RequestMapping("/greeting")
	public List<People> getInfo(){
		
		List<People> peoples=new ArrayList<People>();
		People people=new People();
		people.setId(1);
		people.setName("Priyankit");
		peoples.add(people);
		return peoples;
		
		
	}
}
