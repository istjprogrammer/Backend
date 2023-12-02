package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.SampleService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@Tag(name="샘플~~   ", description="sample controller")
public class SampleController {

   @Autowired
   SampleService sampleService;

   @Operation(summary = "IS SAMPLE")
   @Parameters({
      @Parameter(name = "userId", description = "회원 아이디",
            required = true, in = ParameterIn.QUERY,
            schema = @Schema(type = "string"))
   })
   @GetMapping("/example")
   public String example(@RequestParam("userId") String userId){
      sampleService.sample();
      return userId;
   }
   
   @PostMapping("/example")
   public User saveUser(@RequestBody User user) {
	   log.info("{}", user.toString());
	   sampleService.saveUsers(user.getId(), user.getUserId(), user.getUserName());
	   return user;
   }

}
