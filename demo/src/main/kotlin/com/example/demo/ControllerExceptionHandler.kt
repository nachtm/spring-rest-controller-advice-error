package com.example.demo

import org.apache.logging.log4j.LogManager
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ControllerExceptionHandler {

  @ExceptionHandler(IllegalArgumentException::class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  fun handleIllegalArgumentException(e: IllegalArgumentException): String {
    log.warn("Successfully caught an illegal argument exception: ", e)
    return "Got an illegal argument exception. Fix your arguments!"
  }

  /**
   * In production, we have similar filters for ClientAbortExceptions and many other exceptions as
   * well.
   *
   * We also have a fallback exception handler that logs unhandled exceptions at an ERROR level.
   *
   * These are omitted here, since the particular bug in question doesn't include those. But the
   * intention is that we get no ERROR logs when ClientAbortExceptions or IllegalArgumentExceptions
   * are thrown.
   */

  companion object {

    private val log = LogManager.getLogger()
  }
}
