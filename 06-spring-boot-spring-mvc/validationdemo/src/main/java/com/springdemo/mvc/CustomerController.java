package com.springdemo.mvc;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class CustomerController {
	
	//add an init binder to convert/trim the input string
	//remove leading and trailing white spaces
	//resolve issue for our validation
	
	//InitBinder is executed first.
	//this function will cheack for the leading and trailing white spaces in the input data
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		//here true means if only blank spaces are present it will make the blank spaces to null.
		//else it will delete trailing and front spaces
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@GetMapping("/")
	// Model allows us to share information between controllers and view pages
	public String showForm(Model theModel) {
		
		theModel.addAttribute("customer", new Customer());
		return "customer-form";
	}
	
	@PostMapping("/processForm")
	// @Valid - tell Spring MVC to perform validation
	// @ModelAttribute read the data from the model attribute "customer" that was subitted by the HTML form
	// Bindiing Result holds the result of the validation.
	public String processForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult theBindingResult) {
		
		System.out.println("First name: |" + customer.getFirstName()+ "|");
		System.out.println("Last name: |" + customer.getLastName()+ "|");
		
		
		System.out.println(theBindingResult.toString() );
		if(theBindingResult.hasErrors()) {
			return "customer-form";
		} else {
			return "customer-confirmation";
		}
	}

}
