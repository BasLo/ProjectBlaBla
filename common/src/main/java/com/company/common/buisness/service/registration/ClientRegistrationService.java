package com.company.common.buisness.service.registration;

import com.company.common.dto.web.ClientDto;
import com.company.domain.entity.user.User;

public interface ClientRegistrationService {

     User addUserByRegistrationForm(ClientDto clientDto);
}
