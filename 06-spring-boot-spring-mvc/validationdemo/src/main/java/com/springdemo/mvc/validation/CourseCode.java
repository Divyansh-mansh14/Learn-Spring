//  Creating a Custom Annotation


package com.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
//Target means where are we gonna apply this new annotaiton that we are creating
@Target({ElementType.METHOD, ElementType.FIELD})
//It means how long the marked annotation be stored or used
//By this we mean retain this annotation in the byte code and use/process ot at the Runtime by the JVM
@Retention(RetentionPolicy.RUNTIME)

//@Interface is special type it is used for creating annotation
public @interface CourseCode {
	
//	define course code
	public String value() default "LUV";
//	define error message
	public String message() default "must start with LUV";
//	define default groups
	public Class<?>[] groups() default {};
	
//	payload gives additional details about the error which has occured
//	define default payloads
	public Class<? extends Payload>[] payload() default {};	
}
