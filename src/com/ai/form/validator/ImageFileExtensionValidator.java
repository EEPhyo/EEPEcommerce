package com.ai.form.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


import org.springframework.web.multipart.MultipartFile;

public class ImageFileExtensionValidator implements ConstraintValidator<ImageFileExtension, MultipartFile> {

    @Override
    public void initialize(ImageFileExtension constraintAnnotation) {
        // Initialization if needed
    }

    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext context) {
        if (file == null || file.isEmpty()) {
            return true;  // Allow null or empty files
        }
        
        String contentType = file.getContentType();
        if (contentType != null && (contentType.equals("image/jpeg") || contentType.equals("image/jpg") || contentType.equals("image/png"))) {
            return true;  // Valid file type
        }

        return false;  // Invalid file type
    }
}
