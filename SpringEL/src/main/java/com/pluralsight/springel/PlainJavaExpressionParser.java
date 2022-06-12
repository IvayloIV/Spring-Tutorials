package com.pluralsight.springel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.expression.Expression;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

@Configuration
public class PlainJavaExpressionParser {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            logger.info("--- Start of Plain Java result ---");
            SpelExpressionParser parser = new SpelExpressionParser();

            Expression expression = parser.parseExpression("'Test'");
            String message = (String) expression.getValue();
            logger.info(message);

            Expression expression2 = parser.parseExpression("'Test'.length() * 100");
            Integer count = (Integer) expression2.getValue();
            logger.info(count.toString());

            Expression expression3 = parser.parseExpression("#myprop");
            StandardEvaluationContext ec = new StandardEvaluationContext();
            ec.setVariable("myprop", "MyTest");
            Object result = expression3.getValue(ec);
            logger.info(result.toString());

            Expression expression4 = parser.parseExpression("name");
            User user = new User();
            StandardEvaluationContext ec2 = new StandardEvaluationContext(user);
            expression4.setValue(ec2, "Pesho");
            logger.info(user.getName());

            Expression expression5 = parser.parseExpression("#systemProperties['user.name']");
            StandardEvaluationContext ec3 = new StandardEvaluationContext();
            ec3.setVariable("systemProperties", System.getProperties());
            Object result2 = expression5.getValue(ec3);
            logger.info(result2.toString());

            Expression expression6 = parser.parseExpression("name");
            StandardEvaluationContext ec4 = new StandardEvaluationContext(user);
            expression6.setValue(ec4, result2);
            logger.info(user.getName());

            Expression expression7 = parser.parseExpression("The result of #{'4 + 6'} is equal to #{4 + 6}",
                    new TemplateParserContext());
            Object result3 = expression7.getValue();
            logger.info(result3.toString());
            logger.info("--- End of Plain Java result ---");
        };
    }
}
