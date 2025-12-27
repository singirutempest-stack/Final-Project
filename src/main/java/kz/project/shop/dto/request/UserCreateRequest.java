package kz.project.shop.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateRequest {
    private String email;
    private String password;
}
