package com.example.lucenedemo.interfaceInfo;
import java.lang.annotation.ElementType;

import java.lang.annotation.Retention;

import java.lang.annotation.RetentionPolicy;

import java.lang.annotation.Target;

/**
 * @author chenbiao
 * @version 1.0
 * @description
 * @date 2022/8/12 9:50
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogInfo {
}
