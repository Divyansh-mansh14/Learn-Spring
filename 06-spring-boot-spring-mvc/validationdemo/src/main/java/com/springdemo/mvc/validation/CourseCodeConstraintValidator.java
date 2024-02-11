//  Creating a Custom Annotation


package com.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	
	String coursePrefix;
	@Override
	public void initialize(CourseCode theCourseCode) {
//		the value is accessed from the value() method is called which is in our case "LUV"
		coursePrefix = theCourseCode.value();
	}
	
	
	// Here theCode is the Actual value which is passed in the HTML from by the user.
	//we can give additional error message if we want
	//we can place additional error messagge here - theConstraintValidatorContext
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {

		boolean result;
		
		
		if(theCode != null) {
			result = theCode.startsWith(coursePrefix);
		} else {
			result = true;
		}		
		return result;
	}
}
