package com.sddk.test.yugabytedemo.rest;

import com.sddk.test.yugabytedemo.dto.CustomerDto;
import com.sddk.test.yugabytedemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer")
public class CustomerController {
  @Autowired
  CustomerService customerService;

  @PostMapping("/")
  public CustomerDto create(@RequestBody CustomerDto dto) {
    return customerService.create(dto);
  }

}
