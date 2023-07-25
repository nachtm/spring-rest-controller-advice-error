package com.example.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.TimeUnit

@RestController
class EndpointThatThrows {

  @GetMapping("throw/illegal-argument-exception")
  fun throwAnIllegalArgumentException(
      @RequestParam(required = false, defaultValue = "0") waitForSeconds: Long
  ) {
    TimeUnit.SECONDS.sleep(waitForSeconds)
    throw IllegalArgumentException("This is what you asked for.")
  }
}