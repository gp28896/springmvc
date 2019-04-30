package com.neu.naam.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.naam.pojo.Advert;

@Component
public class AdvertValidator implements Validator {

	public boolean supports(Class aClass) {
		return aClass.equals(Advert.class);
	}

	private Pattern pattern;  
	 private Matcher matcher;  
	
	 private static final 
	 String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"  
			   + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";    
	 String STRING_PATTERN = "[a-zA-Z]+";
	
	public void validate(Object obj, Errors errors) {
		Advert newAdvert = (Advert) obj;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "error.invalid.title", "Title Required");
		 if (!(newAdvert.getTitle() != null && newAdvert.getTitle().isEmpty())) {  
			   pattern = Pattern.compile(STRING_PATTERN);  
			   matcher = pattern.matcher(newAdvert.getTitle());  
			   if (!matcher.matches()) {  
			    errors.rejectValue("title", "title.containNonChar",  
			      "Invalid title");  
			   }  
			  }
		 
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "filename", "error.invalid.filename", "Filename Required");
		 if (!(newAdvert.getFilename() != null && newAdvert.getFilename().isEmpty())) {  
			   pattern = Pattern.compile(STRING_PATTERN);  
			   matcher = pattern.matcher(newAdvert.getFilename());  
			   if (!matcher.matches()) {  
			    errors.rejectValue("filename", "filename.containNonChar",  
			      "Invalid File-Name");  
			   }  
			  }
		 
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "message", "error.invalid.filename", "Product Description Required");
		 if (!(newAdvert.getMessage() != null && newAdvert.getMessage().isEmpty())) {  
			   pattern = Pattern.compile(STRING_PATTERN);  
			   matcher = pattern.matcher(newAdvert.getMessage());  
			   if (!matcher.matches()) {  
			    errors.rejectValue("message", "message.containNonChar",  
			      "Invalid product-description");  
			   }  
			  }
	}
}
