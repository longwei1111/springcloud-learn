package com.coolw.springcloud.domain;

import com.coolw.springcloud.api.BaseDomain;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @Classname User
 * @Description
 * @Date 2021/2/2 9:45
 * @Author lw
 */
@Getter
@Setter
@Builder
public class User extends BaseDomain {

    private static final long serialVersionUID = 3391470912504085770L;

    private long id;
    private String userName;
    private String password;
    private String mobileNo;
}
