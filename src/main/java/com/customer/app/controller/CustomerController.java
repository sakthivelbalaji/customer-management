package com.customer.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.customer.app.dto.Customerdto;
import com.customer.app.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService customerservices;
	
	
	 @RequestMapping("/read-contact")
	    public String showReadContactPage(Model model) {
	        model.addAttribute("customerdtos", customerservices.findAll());
	        return "readcontact";
	    }

	    @RequestMapping("/create-contact")
	    public String showCreateCustomerdtoPage(Model model) {
	        model.addAttribute("command", new Customerdto());
	        return "createcontact";
	    }

	    @RequestMapping(value = "/create-contact", method = RequestMethod.POST)
	    public String createCustomerdto(@ModelAttribute("customerdto") Customerdto customerdto) {
	    	customerservices.saveCustomerdto(customerdto);
	        return "redirect:/read-contact";
	    }

	    @RequestMapping(value = "/update-contact/{id}")
	    public String showUpdateCustomerdtoPage(@PathVariable int id, Model model) {
	        model.addAttribute("id", id);
	        model.addAttribute("command", customerservices.findById(id).orElse(null));
	        return "updatecontact";
	    }

	    @RequestMapping(value = "/update-contact/{id}", method = RequestMethod.POST)
	    public String updateCustomerdto(@PathVariable int id, @ModelAttribute("customerdto") Customerdto customerdto) {
	    	customerservices.updateCustomerdto(id, customerdto);
	        return "redirect:/read-contact";
	    }

	    @RequestMapping(value = "/delete-contact/{id}")
	    public String deleteCustomerdto(@PathVariable int id) {
	    	customerservices.deleteById(id);
	        return "redirect:/read-contact";
	    }
	
	
	
	

	/*
	 * @GetMapping(value = "/add/customer") public String showLoginPage(ModelMap
	 * model) { return "customer"; }
	 * 
	 * @RequestMapping(value = "/add/customer", method = RequestMethod.POST) public
	 * String addcustomer(Model model, @Validated Customerdto dto) {
	 * customerservices.save(dto); return "customerget"; }
	 * 
	 * 
	 * @GetMapping(value ="/get/customer") public String getcustomer() { return
	 * customerservices.findAll().toString();
	 * 
	 * }
	 * 
	 * 
	 * @GetMapping(value = "/get/customer")
	 * 
	 * @ResponseBody public ModelAndView getcustomer(@RequestParam Integer cid) {
	 * ModelAndView mv = new ModelAndView("Getdata.jsp"); Customerdto customerdto =
	 * customerservices.findById(cid).orElse(new Customerdto());
	 * 
	 * //System.out.println(customerservices.findByMaterial("ipad"));
	 * //System.out.println(customerservices.findByCidGreaterThan(102)); //
	 * System.out.println(customerservices.findBymaterialSorted("ipad"));
	 * mv.addObject(customerdto).toString(); return mv; }
	 */
	/*
	 * @GetMapping(value = "/get/customer/{cutomer_id}") public String
	 * getcustomer(@PathVariable("cutomer_id") long cutomer_id) { return
	 * customerservices.findById(cutomer_id).toString();
	 * 
	 * }
	 * 
	 * @PutMapping(value = "/put/customer") public String putcutomer(Model
	 * model, @RequestParam Customerdto dto) { return "customer"; }
	 * 
	 * @DeleteMapping(value= "/delete/customer/{delete}") public String
	 * deletecustomer(@PathVariable long customer_id) { Customerdto dto =
	 * customerservices.getOne(customer_id); customerservices.delete(dto);
	 * return"deleted";
	 * 
	 * 
	 * }
	 */

}
