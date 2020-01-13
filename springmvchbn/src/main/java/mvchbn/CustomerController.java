package mvchbn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
	@Autowired
CustomerDao dao;
	@RequestMapping(value="/addcust",method=RequestMethod.GET)
	public String ShowAddCustomerForm(){
		return "AddCustomer";
	}
	@RequestMapping(value="/addcust",method=RequestMethod.POST)
	public ModelAndView addcustomer(@ModelAttribute("customer") Customer cust){
		ModelAndView mav=new ModelAndView();
		dao.addCustomer(cust);
		mav.setViewName("redirect:viewcustomers");
		return mav;
		
	}
	@RequestMapping(value="/updatecust",method=RequestMethod.GET)
	public String ShowUpdateCustomerForm(){
		return "UpdateCustomer";
	}
	@RequestMapping(value="/updatecust",method=RequestMethod.POST)
	public ModelAndView updatecustomer(@ModelAttribute("customer") Customer cust){
		ModelAndView mav=new ModelAndView();
		dao.updateCustomer(cust);
		mav.setViewName("redirect:viewcustomers");
		return mav;
		
	}
	@RequestMapping(value="/deletecust",method=RequestMethod.GET)
	public String ShowDeleteCustomerForm(){
		return "DeleteCustomer";
	}
	@RequestMapping(value="/deletecust",method=RequestMethod.POST)
	public ModelAndView deletecustomer(@ModelAttribute("customer") Customer cust){
		ModelAndView mav=new ModelAndView();
		dao.deleteCustomer(cust);
		mav.setViewName("redirect:viewcustomers");
		return mav;
	}
	
	
	@RequestMapping(value="viewcustomers")
	public ModelAndView getCustomers(){
		ModelAndView mav=new ModelAndView();
		List<Customer> list=dao.getCustomers();
		mav.addObject("customers", list);
		mav.setViewName("ViewCustomers");
		return mav;
		
	}

}