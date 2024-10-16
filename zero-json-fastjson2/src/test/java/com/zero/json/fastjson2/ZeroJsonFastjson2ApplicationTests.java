package com.zero.json.fastjson2;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONReader;
import com.zero.json.fastjson2.domain.entity.SystemUserEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@SpringBootTest
class ZeroJsonFastjson2ApplicationTests {

    @BeforeEach
    public void before()  {
        log.info("init some data");
    }

    @AfterEach
    public void after(){
        log.info("clean some data");
    }

    @Test
    public void parseArray()  {
        String json="[{\"create_time\":\"2024-07-03 09:03:26.968\",\"money\":-40090.0700}]";
        System.out.println(json);
        List<SystemUserEntity> list1 = JSON.parseArray(json, SystemUserEntity.class, JSONReader.Feature.SupportSmartMatch);
        System.out.println(list1);
    }

    @Test
    public void toJSONString() throws ParseException {
        SystemUserEntity  user =  new SystemUserEntity();
        BigDecimal money = BigDecimal.valueOf(-40090.07d);
        money = money.setScale(4, RoundingMode.HALF_UP);
        user.setMoney(money);

        String createTime ="2024-07-03 09:03:26.968";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date date = format.parse(createTime);
        user.setCreateTime(date);

        List<SystemUserEntity> list = new ArrayList<>();
        list.add(user);
        String json=JSON.toJSONString(list);
        //String json=JSON.toJSONString(list,  JSONWriter.Feature.WriteBigDecimalAsPlain);
        System.out.println(json);
    }

}
