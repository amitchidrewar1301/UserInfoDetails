package info.controller;


import info.dto.UserInfoDto;
import info.entity.UserContactInfo;
import info.service.UserContactInfoService;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class UserContactInfoController {

    private  static  final Logger logger = LoggerFactory.getLogger(UserContactInfoController.class);

    @Autowired
    private UserContactInfoService userContactInfoService;


    @PostMapping(value="/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveUserContractInfo(@Valid @RequestBody UserContactInfo userContractInfo){
        logger.info("User  details - {}", userContractInfo);
        return userContactInfoService.saveUserContactInfo(userContractInfo);
    }

    @GetMapping(value = "/user/{ids}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUserContactInfoByIds(@RequestParam ("ids") String ids)  {
        return userContactInfoService.getUserContactInfoByIds(ids);
    }

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllUserContactInfo() {
        return userContactInfoService.getAllUserContactInfo();
    }

    @GetMapping(value="/user/{id}")
    public ResponseEntity getUserContactInfoById(@PathVariable long id) {
        return userContactInfoService.getUserContactInfoById(id);
    }

    @DeleteMapping (value="/user/{id}")
    public ResponseEntity deleteUserContactInfoById(@PathVariable long id) {
       return userContactInfoService.deleteUserContactInfoById(id);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity updateUserContactInfoById(@Valid @RequestBody UserInfoDto userInfoDto , @PathVariable long id)
    {
        return userContactInfoService.updateUserContactInfoById(id,userInfoDto);
    }

    @DeleteMapping (value="/users")
    public ResponseEntity deleteAllUserContactInfo() {
        return userContactInfoService.deleteAllUserContactInfo();
    }

}
