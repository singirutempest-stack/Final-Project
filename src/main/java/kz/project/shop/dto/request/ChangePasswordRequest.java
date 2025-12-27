//package kz.project.shop.dto.request;
//
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
//public class ChangePasswordRequest {
//    private Long userId;
//    private String oldPassword;
//    private String newPassword;
//}


package kz.project.shop.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangePasswordRequest {

    private String oldPassword;
    private String newPassword;
}