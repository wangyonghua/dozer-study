package com.dozerstudy.demo;

import com.dozerstudy.demo.model.NotSameAttributeA;
import com.dozerstudy.demo.model.NotSameAttributeB;
import org.dozer.Mapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {

    @Autowired
    Mapper mapper;

    @Test
    public void testNotSameAttributeMapping() {
//        NotSameAttributeA src = new NotSameAttributeA();
//        src.setId(007);
//        src.setName("邦德");
//        src.setDate(new Date());
//
//        NotSameAttributeB desc = mapper.map(src, NotSameAttributeB.class);
//        System.out.println(desc);
//        Assert.assertNotNull(desc);

//        System.out.println("float" + Float.MAX_VALUE);
        System.out.println(String.valueOf(new Date()));
    }

}
