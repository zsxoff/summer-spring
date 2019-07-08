package com.routine.summer.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorCustomController implements ErrorController {

    @RequestMapping(value = "/error")
    public String handleError(HttpServletRequest request) {

        final Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        final Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");

        final String exceptionMsg;
        if (exception != null) {
            exceptionMsg = exception.toString();
        } else {
            exceptionMsg = "...";
        }

        // TODO Kill me.
        return String.format(
                "<html><body><h2>Oh no!</h2><div>status: %s</div><div>msg: %s</div></body></html>",
                statusCode, exceptionMsg);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
