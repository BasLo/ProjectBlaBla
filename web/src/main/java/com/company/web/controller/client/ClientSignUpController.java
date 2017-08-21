package com.company.web.controller.client;

import com.company.common.buisness.service.registration.ClientRegistrationService;
import com.company.common.dto.web.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller
public class ClientSignUpController {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private ClientRegistrationService registrationService;

    @RequestMapping(value = "/signUpView", method = RequestMethod.GET)
    public ModelAndView signUpView(ModelAndView modelAndView){
        modelAndView.setViewName("defaultTemplate");
        modelAndView.addObject("content", "/WEB-INF/template/body/sign_up_content.jsp");
        return  modelAndView;
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public ModelAndView singUp(@Valid @NotNull final UserDto userDto,
                               BindingResult bindingResult, ModelAndView modelAndView, WebRequest request){
        LOGGER.debug("Registering user account with information: {}", userDto);

        if (!bindingResult.hasErrors()) {
            registrationService.addUserByRegistrationForm(userDto, bindingResult, request);
        }else {
            //TODO: something wrong!
        }
        return modelAndView;
    }

    @RequestMapping(value = "/mailRegistrationConfirm", method = RequestMethod.GET)
    public String confirmEmailRegistration(WebRequest request, @RequestParam("token") String token, ModelAndView modelAndView){
        return registrationService.processEmailRegistrationConfirm(token, request,modelAndView );
    }

    @Autowired
    @Qualifier("clientRegistrationServiceImpl")
    public void setRegistrationService(ClientRegistrationService registrationService) {
        this.registrationService = registrationService;
    }

}