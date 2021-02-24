package com.qi.shiro.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDIY {
    private String name;
    private String pwd;
    private String id;
    private String perms;
}
