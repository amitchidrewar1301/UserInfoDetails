package com.user.service;

import static com.user.util.UserContactInfoUtil.buildUserContactInfo;
import static com.user.util.UserContactInfoUtil.buildUserContactInfoForFindById;
import static com.user.util.UserContactInfoUtil.buildUserInfoDto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import info.dto.AddressDto;
import info.dto.UserInfoDto;
import info.entity.Address;
import info.entity.UserContactInfo;
import info.repository.UserContactInfoRepository;
import info.service.UserContactInfoService;
import info.service.UserContactInfoServiceImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith({MockitoExtension.class})
public class UserContactInfoServiceTest {

  @InjectMocks
  UserContactInfoService userContactInfoService = new UserContactInfoServiceImpl();

  @Mock
  UserContactInfoRepository userContactInfoRepository;


  List<UserContactInfo> listOfUserContactInfo = null;
  UserContactInfo userContactInfo = null;
  UserInfoDto userInfoDto = null;

  @BeforeEach
  public void setup() {
    listOfUserContactInfo = buildUserContactInfo();
    userContactInfo = buildUserContactInfoForFindById();
    userInfoDto = buildUserInfoDto();

  }

  @Test
  public void test1() {
    when(userContactInfoRepository.findAll()).thenReturn(listOfUserContactInfo);
    ResponseEntity responseEntity = userContactInfoService.getAllUserContactInfo();
    assertNotNull(responseEntity);
    assertThat(responseEntity.getStatusCode().is2xxSuccessful()).isTrue();
    ArrayList arrayList = (ArrayList) responseEntity.getBody();
    assertThat(((ArrayList) responseEntity.getBody()).size()).isEqualTo(2);
  }



}
