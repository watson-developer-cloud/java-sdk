package com.ibm.watson.developer_cloud.spring.boot;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

public class WatsonServiceCondition implements Condition {

  @Override
  public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata metadata) {
    Map<String, Object> attributes = metadata.getAnnotationAttributes(ConditionalOnWatsonServiceProperties.class.getName());
    String prefix = (String)attributes.get("prefix");

    // If the service is specifically marked as enabled, the condition is true
    if (Boolean.valueOf(conditionContext.getEnvironment().getProperty(prefix + ".enabled"))) {
      return true;
    }

    // If any of the configuration properties for the service are present, the condition is true
    String url = conditionContext.getEnvironment().getProperty(prefix + ".url");
    String username = conditionContext.getEnvironment().getProperty(prefix + ".username");
    String password = conditionContext.getEnvironment().getProperty(prefix + ".password");
    String versionDate = conditionContext.getEnvironment().getProperty(prefix + ".versionDate");
    if (url != null || username != null || password != null || versionDate != null) {
      return true;
    }

    return false;
  }
}
