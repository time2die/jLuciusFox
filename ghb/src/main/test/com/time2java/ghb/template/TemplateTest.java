package com.time2java.ghb.template;

import com.time2java.ghb.TestBeanFabric;
import com.time2java.ghb.TsTodoroApplication;
import freemarker.template.TemplateException;
import lombok.Getter;
import lombok.Setter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by time2die on 20.03.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TsTodoroApplication.class)
@Import(TestBeanFabric.class)
public class TemplateTest {

    @Setter
    @Getter
    @Autowired
    TemplateService templateService;

    @Test
    public void templateTest() throws IOException, TemplateException {
        HashMap<String, Object> data = new HashMap<String, Object>() {{
            put("name", "world");
        }};
        org.junit.Assert.assertEquals("hello world", (templateService.processTemplate("helloworld.ftl", data)));
    }

    @Test
    public void templateTestAsk() throws TemplateException, IOException {
        Assert.assertEquals("What are you doing now ?", templateService.processTemplate("ask.ftl", null));
    }

    @Test
    public void getAskMethodTest() throws IOException, TemplateException {
        Assert.assertEquals(templateService.getAskText(), templateService.processTemplate("ask.ftl", null) );
    }

}

