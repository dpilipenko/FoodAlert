package com.dpilipenko.foodalert.web;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class Interceptor extends HandlerInterceptorAdapter {

  Logger log = Logger.getLogger(Interceptor.class);

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    log.info(getIPAddress(request));
    return super.preHandle(request, response, handler);
  }

  protected String getIPAddress(HttpServletRequest request) {
    return request.getRemoteAddr();
  }
}
