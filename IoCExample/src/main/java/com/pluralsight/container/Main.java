package com.pluralsight.container;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private final static String beanFilePath = "C:\\Users\\Ivaylo_nikolaev\\Desktop\\IoCExample\\src\\main\\resources\\beans.json";
    private final static Map<Class<?>, Class<?>> types = new HashMap<>();
    static {
        types.put(boolean.class, Boolean.class);
        types.put(byte.class, Byte.class);
        types.put(short.class, Short.class);
        types.put(char.class, Character.class);
        types.put(int.class, Integer.class);
        types.put(long.class, Long.class);
        types.put(float.class, Float.class);
        types.put(double.class, Double.class);
    }


    private List<ConfiguraionBeans> beansConfig = new ArrayList<>();
    private Map<String, Object> beans = new HashMap<>();

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.parseConfiguration(beanFilePath);
        MyService myService = (MyService) main.getBean(MyService.class);
        System.out.println();
    }

    private void parseConfiguration(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        this.beansConfig = mapper.readValue(new File(filePath), new TypeReference<List<ConfiguraionBeans>>(){});
    }

    private Object getBean(Class clazz) throws Exception {
        String beanName = clazz.getName();
        if (beans.containsKey(beanName)) {
            return beans.get(beanName);
        }

        ConfiguraionBeans beanConfig = findBeanConfig(beanName);
        Class<?> clazzTo = Class.forName(beanConfig.getTo());
        Constructor constructor = getTheLongestParamConstructor(clazzTo);
        Parameter[] parameters = constructor.getParameters();
        Object[] params = new Object[parameters.length];

        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];

            String parameterName = parameter.getName();
            Class<?> parameterType = parameter.getType();
            Object instance;

            if (types.containsValue(parameterType) || parameterType.getName().equals(String.class.getName())) {
                Object paramValue = findParamValueByName(beanConfig.getParams(), parameterName);
                instance = initializePrimitive(parameterType, paramValue);
            } else if (types.containsKey(parameterType)) {
                Object paramValue = findParamValueByName(beanConfig.getParams(), parameterName);
                instance = initializePrimitive(types.get(parameterType), paramValue);
            } else {
                instance = getBean(parameterType);
            }

            params[i] = instance;
        }

        Object bean = constructor.newInstance(params);
        beans.put(beanConfig.getFrom(), bean);
        beans.put(beanConfig.getTo(), bean);
        return bean;
    }

    private Object initializePrimitive(Class clazz, Object paramValue) throws Exception {
        Constructor constructor = clazz.getConstructor(paramValue.getClass());
        return constructor.newInstance(paramValue);
    }

    private Object findParamValueByName(List<BeanParams> params, String parameterName) {
        for (BeanParams param : params) {
            if (param.getName().equals(parameterName)) {
                return param.getValue();
            }
        }

        throw new IocException("Parameter value doesn't exist!");
    }

    private Constructor getTheLongestParamConstructor(Class<?> clazz) {
        int paramsCount = -1;
        Constructor longestParamConstructor = null;
        for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
            if (paramsCount < constructor.getParameterCount()) {
                paramsCount = constructor.getParameterCount();
                longestParamConstructor = constructor;
            }
        }

        if (longestParamConstructor == null) {
            throw new IocException("Bean " + clazz.getName() + " doesn't have constructor!");
        }

        return longestParamConstructor;
    }

    private ConfiguraionBeans findBeanConfig(String beanName) {
        for (ConfiguraionBeans configuraionBeans : beansConfig) {
            if (configuraionBeans.getFrom().equals(beanName) || configuraionBeans.getTo().equals(beanName)) {
                return configuraionBeans;
            }
        }

        throw new IocException("Bean doesn't exist!");
    }
}
