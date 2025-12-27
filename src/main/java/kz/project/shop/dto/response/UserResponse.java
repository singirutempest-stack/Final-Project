package kz.project.shop.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserResponse {
    private Long id;
    private String email;
    private boolean blocked;
    private Set<String> roles;
}
