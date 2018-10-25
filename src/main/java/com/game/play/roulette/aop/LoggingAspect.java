/**
 * Module: roulette
 */
package com.game.play.roulette.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * AspectImpl.java - This class is used to address cross cutting concern - logging around methods.
 * 
 * @since 23 Sep 2018
 */
@Aspect
@Configuration
public class LoggingAspect {

    private final static Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    // @Around(value = "execution(* com.game.play.roulette.bettype.*.*(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        joinPoint.proceed();
    }

}
