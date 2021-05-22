package com.annotations;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ObjectToJsonConvertor {
    public String objectToJson(Object object) throws JsonSerializationException, CapitalizeException{
        try{
            checkIfSerializable(object);
            initializeObject(object);
            return getJsonString(object);
        }
        catch (Exception e){
            throw new JsonSerializationException(e.getMessage());
        }
    }
    private void checkIfSerializable(Object object){
        if(Objects.isNull(object)){
            throw new JsonSerializationException("can't serialize the null object");
        }
        Class<?> clazz = object.getClass();
        if(!clazz.isAnnotationPresent(JsonSerializable.class)){
            throw new JsonSerializationException("the class"+ clazz.getName()+ " is not annotated with JsonSerializable");
        }
    }
    public void initializeObject(Object object)throws IllegalArgumentException, IllegalAccessException, InvocationTargetException{
        Class<?> clazz = object.getClass();
        for(Method method : clazz.getDeclaredMethods()){
            if(method.isAnnotationPresent(Init.class)){
                method.setAccessible(true);
                try {
                    method.invoke(object);
                }
                catch (Exception e){
                    throw new CapitalizeException("number cannot be converted to string");
                }
            }
        }
    }
    private String getJsonString(Object object) throws IllegalAccessException {
        Class<?> clazz = object.getClass();
        Map<String, String> objToJson= new HashMap<>();
        for(Field field : clazz.getDeclaredFields()){
            field.setAccessible(true);
            if(field.isAnnotationPresent(JsonElement.class)){
                objToJson.put(getKey(field), (String) field.get(object));
            }
        }
        String jsonString = objToJson.entrySet()
                            .stream()
                            .map(entry -> "\"" + entry.getKey() + "\":\"" + entry.getValue() + "\"")
                            .collect(Collectors.joining(","));
        return "{"+jsonString+"}";
    }
    private String getKey(Field field){
        String value = field.getAnnotation(JsonElement.class).key();
        return value.isEmpty()?field.getName():value;
    }
}
