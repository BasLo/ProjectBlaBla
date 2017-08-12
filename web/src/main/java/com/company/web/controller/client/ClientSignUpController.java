package com.company.web.controller.client;

import com.company.common.buisness.service.registration.ClientRegistrationService;
import com.company.common.dto.web.ClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotNull;

@Controller
public class ClientSignUpController {

    private ClientRegistrationService clientRegistrationService;

    @RequestMapping(value = "/signUpView", method = RequestMethod.GET)
    public ModelAndView signUpView(ModelAndView modelAndView){
        modelAndView.setViewName("defaultTemplate");
        modelAndView.addObject("content", "/WEB-INF/template/body/sign_up_content.jsp");
        return  modelAndView;
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public ModelAndView singUp(@ModelAttribute("clientDto") @NotNull ClientDto clientDto,
                               BindingResult bindingResult, ModelAndView modelAndView){
        if (!bindingResult.hasErrors()) {
            clientRegistrationService.addUserByRegistrationForm(clientDto);
        }else {
            //TODO: something wrong!
        }
        return modelAndView;
    }

    @Autowired
    @Qualifier("clientRegistrationServiceImpl")
    public void setClientRegistrationService(ClientRegistrationService clientRegistrationService) {
        this.clientRegistrationService = clientRegistrationService;
    }
}