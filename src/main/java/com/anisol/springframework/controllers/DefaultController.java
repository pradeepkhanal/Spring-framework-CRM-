
package com.anisol.springframework.controllers;

import com.anisol.springframework.dao.CustomerDAO;
import com.anisol.springframework.dto.CustomerDTO;
import com.anisol.springframework.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/")
public class DefaultController {
    @Autowired
    private CustomerDAO  customerDAO ;
    
    @RequestMapping(method = RequestMethod.GET)
  // @ResponseBody
    public String index(Model model){
        try{
        model.addAttribute("customer", customerDAO.getAll());        
        }catch(Exception ex ){
            System.out.println(ex.getMessage());
        }
     return "index";
             }
    
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(){
        return "customer/add";
    }
     @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String save(@ModelAttribute("CustomerDTO")CustomerDTO cDTO){
        try{
            Customer c = new Customer(1,cDTO.getFirstName(),cDTO.getLastName(),cDTO.getEmail(),cDTO.getContactNo());
        customerDAO.insert(c);
        }catch(Exception ex){}
        return "redirect:/";
    }
    
    
}
