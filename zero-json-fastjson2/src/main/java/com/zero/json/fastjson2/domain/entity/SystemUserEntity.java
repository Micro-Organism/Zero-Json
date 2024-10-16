package com.zero.json.fastjson2.domain.entity;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class SystemUserEntity {

    private BigDecimal money;

    @JSONField(format= "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

}
