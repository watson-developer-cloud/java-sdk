package com.ibm.watson.developer_cloud.spring.boot;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Conditional(WatsonServiceCondition.class)
public @interface ConditionalOnWatsonServiceProperties {
  public String prefix();
}
