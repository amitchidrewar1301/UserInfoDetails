package com.user.util;

import info.dto.AddressDto;
import info.dto.UserInfoDto;
import info.entity.Address;
import info.entity.UserContactInfo;
import java.util.ArrayList;
import java.util.List;

public class UserContactInfoUtil {

  public static List<UserContactInfo> buildUserContactInfo() {

    List<UserContactInfo> listOffUser = new ArrayList<>();
    UserContactInfo userContactInfo = new UserContactInfo();

    userContactInfo.setId(1L);
    userContactInfo.setFirstName("FirstName");
    userContactInfo.setLastName("LastName");
    userContactInfo.setPhoneNo("1234567890");
    Address address = new Address();
    address.setId(1L);
    address.setDoorNo("30A");
    address.setStreetName("Street Name");
    address.setPostCode("XXZ123");
    userContactInfo.setAddress(address);

    UserContactInfo userContractInfo1 = new UserContactInfo();
    userContractInfo1.setId(2L);
    userContractInfo1.setFirstName("FirstName1");
    userContractInfo1.setLastName("LastName1");
    userContractInfo1.setPhoneNo("1234567891");
    Address address1 = new Address();
    address1.setId(2L);
    address1.setDoorNo("30B");
    address1.setStreetName("Street Name1");
    address1.setPostCode("XXZ121");
    userContractInfo1.setAddress(address1);

    listOffUser.add(userContactInfo);
    listOffUser.add(userContractInfo1);

    return listOffUser;

  }

  public static UserContactInfo buildUserContactInfoForFindById() {

    UserContactInfo userContactInfo = new UserContactInfo();
    userContactInfo.setId(1L);
    userContactInfo.setFirstName("FirstName");
    userContactInfo.setLastName("LastName");
    userContactInfo.setPhoneNo("1234567890");
    Address address = new Address();
    address.setId(1L);
    address.setDoorNo("30A");
    address.setStreetName("Street Name");
    address.setPostCode("XXZ123");
    userContactInfo.setAddress(address);

    return userContactInfo;

  }

  public static UserInfoDto buildUserInfoDto() {
    UserInfoDto userInfoDto = new UserInfoDto();
    userInfoDto.setFirstName("UpdatedFirstName");
    userInfoDto.setLastName("UpdatedLastName");
    AddressDto addressDto = new AddressDto();
    addressDto.setDoorNo("U30A");
    addressDto.setStreetName("Updated Street Name");
    addressDto.setPostCode("UXXZ123");
    userInfoDto.setAddress(addressDto);
    return userInfoDto;

  }
}
