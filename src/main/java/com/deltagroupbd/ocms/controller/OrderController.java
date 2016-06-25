package com.deltagroupbd.ocms.controller;

import java.util.ArrayList;
import java.util.Collection;
import com.deltagroupbd.ocms.model.OrderBasic;
import com.deltagroupbd.ocms.repository.OrderBasicRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class OrderController {

	@Autowired
    OrderBasicRepository repository;

    @ModelAttribute
    public void populateOrders(Model model) {
        Iterable<OrderBasic> itr = repository.findAll();
        ArrayList<OrderBasic>  orders = (ArrayList<OrderBasic>)(Collection<OrderBasic>)itr;
        model.addAttribute("orders" , orders);
    }


    @RequestMapping(value = "/neworder", method = RequestMethod.GET)
    public String orderForm(OrderBasic orderBasic) {
        return "merchandising/orderbasic";
    }
    @RequestMapping(value="/neworder", method=RequestMethod.POST)
    public String processOrder(@Valid @ModelAttribute OrderBasic orderBasic,  BindingResult bindingResult , final RedirectAttributes redirectAttributes) {
        Long orderId = orderBasic.getId();
        if (bindingResult.hasErrors()) {
            System.out.print("errror..........");
            return "merchandising/orderbasic";
        }
        repository.save(orderBasic);
        return "redirect:/orderbasic/edit/" + orderId;
    }

    @RequestMapping(value = "/orderbasic/{operation}/{orderId}", method = RequestMethod.GET)
    public String editRemoveOrderBasic(@PathVariable("operation") String operation,
            @PathVariable("orderId") Long orderId, final RedirectAttributes redirectAttributes,
            Model model) {
        OrderBasic orderbasic = repository.findOne(orderId);
        
        if(operation.equals("delete")) {
             if(orderbasic != null){
                 repository.delete(orderbasic);
                 redirectAttributes.addFlashAttribute("deletion", "success");
             }else {
                redirectAttributes.addFlashAttribute("deletion", "unsuccess");
             }
        } else if(operation.equals("edit")){
              if(orderbasic != null) {
                   model.addAttribute("orderBasic", orderbasic);
                   return "merchandising/orderbasic";
              } else {
                  redirectAttributes.addFlashAttribute("status","notfound");
              }
        }

        return "redirect:/neworder";
    } 

}