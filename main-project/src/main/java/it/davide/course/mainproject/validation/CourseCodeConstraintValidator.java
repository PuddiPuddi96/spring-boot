package it.davide.course.mainproject.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator
        implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode courseCode) {
        coursePrefix = courseCode.value();
    }

    @Override
    public boolean isValid(
            String s, //HTML form data entered by the user -> string to validate
            ConstraintValidatorContext constraintValidatorContext) {

        if(null != s)
            return s.startsWith(coursePrefix);
        return false;
    }
}
