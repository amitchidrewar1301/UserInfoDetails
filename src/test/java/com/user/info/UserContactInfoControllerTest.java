package com.user.info;

import static com.user.util.UserContactInfoUtil.buildUserContactInfo;
import static com.user.util.UserContactInfoUtil.buildUserContactInfoForFindById;
import static com.user.util.UserContactInfoUtil.buildUserInfoDto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import info.controller.UserContactInfoController;
import info.dto.AddressDto;
import info.dto.UserInfoDto;
import info.entity.Address;
import info.entity.UserContactInfo;
import info.service.UserContactInfoService;
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
public class UserContactInfoControllerTest {

  @InjectMocks
  private UserContactInfoController controller;

  @Mock
  private UserContactInfoService userContactInfoService;

  List<UserContactInfo> listOfUserContactInfo = null;
  UserContactInfo userContactInfo = null;
  UserInfoDto userInfoDto = null;

  @BeforeEach
  public void setup() {
    listOfUserContactInfo = buildUserContactInfo();
    userContactInfo = buildUserContactInfoForFindById();
    userInfoDto = buildUserInfoDto();

  }

  //get all user contact info test case
  @Test
  public void shouldReturnAllUserContactInfoTest() {
    when(userContactInfoService.getAllUserContactInfo()).thenReturn(ResponseEntity.ok(listOfUserContactInfo));
    ResponseEntity responseEntity = controller.getAllUserContactInfo();
    assertNotNull(responseEntity);
    assertThat(responseEntity.getStatusCode().is2xxSuccessful()).isTrue();
    ArrayList arrayList = (ArrayList) responseEntity.getBody();
    assertThat(((ArrayList) responseEntity.getBody()).size()).isEqualTo(2);

  }

//  //get user contact info by id test case
//  @Test
//  public void shouldReturnUserContactInfoByIdTest() {
//    when(userContactInfoRepository.findById(1L))
//        .thenReturn(java.util.Optional.ofNullable(userContactInfo));
//    ResponseEntity responseEntity = controller.getUserContactInfoById(1L);
//    assertNotNull(responseEntity);
//    assertThat(responseEntity.getStatusCode().is2xxSuccessful()).isTrue();
//    UserContactInfo userContactInfo = (UserContactInfo) responseEntity.getBody();
//    assertThat(userContactInfo.getFirstName()).isEqualTo("FirstName");
//    assertThat(userContactInfo.getPhoneNo()).isEqualTo("1234567890");
//    assertThat(userContactInfo.getAddress().getPostCode()).isEqualTo("XXZ123");
//
//  }
//
//
//  //get user contact info by ids (1,2,3 etc) test case
//  @Test
//  public void shouldReturnUserDetailsByIdsTest() {
//    when(userContactInfoRepository.findAllById(Arrays.asList(1L, 2L)))
//        .thenReturn(listOfUserContactInfo);
//    ResponseEntity responseEntity = controller.getUserContactInfoByIds("1,2");
//    assertNotNull(responseEntity);
//    assertThat(responseEntity.getStatusCode().is2xxSuccessful()).isTrue();
//    ArrayList arrayList = (ArrayList) responseEntity.getBody();
//    assertThat(((ArrayList) responseEntity.getBody()).size()).isEqualTo(2);
//
//  }
//
//  //delete user contact info by ids test case
//  @Test
//  public void shouldDeleteUserContactInfoByIdTest() {
//    when(userContactInfoRepository.findById(1L))
//        .thenReturn(java.util.Optional.ofNullable(userContactInfo));
//    doNothing().when(userContactInfoRepository).deleteById(1L);
//    ResponseEntity responseEntity = controller.deleteUserContactInfoById(1L);
//    assertNotNull(responseEntity);
//    assertThat(responseEntity.getStatusCode().is2xxSuccessful()).isTrue();
//  }
//
//  //save user contact info test case
//  @Test
//  public void shouldSaveUserContactInfoTest() {
//    when(userContactInfoRepository.save(userContactInfo)).thenReturn(userContactInfo);
//    ResponseEntity responseEntity = controller.saveUserContractInfo(userContactInfo);
//    assertNotNull(responseEntity);
//    assertThat(responseEntity.getStatusCode().is2xxSuccessful()).isTrue();
//  }
//
//  //update user contact info by id test case
//  @Test
//  public void shouldUpdateUserContactInfoByIdTest() {
//    when(userContactInfoRepository.findById(1L))
//        .thenReturn(java.util.Optional.ofNullable(userContactInfo));
//    when(userContactInfoRepository.save(userContactInfo)).thenReturn(userContactInfo);
//    ResponseEntity responseEntity = controller.updateUserContactInfoById(userInfoDto, 1L);
//    assertNotNull(responseEntity);
//    assertThat(responseEntity.getStatusCode().is2xxSuccessful()).isTrue();
//
//    UserContactInfo userContactInfo = (UserContactInfo) responseEntity.getBody();
//    assertThat(userContactInfo.getFirstName()).isEqualTo("UpdatedFirstName");
//  }



}

