package com.java.reflection.section02_object_creation_and_constructors.ex04_restricted_classes_dependency_injection.tic_tac_toe.ai_version;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.CONSTRUCTOR)
public @interface Dependency {

}
