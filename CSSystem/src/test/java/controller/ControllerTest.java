package controller;

import com.zihua.controller.SystemController;
import com.zihua.entity.User;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by zihua on 17-1-24.
 */
public class ControllerTest {

    @Test
    public void test1() {
        SystemController controller = new SystemController();

    }

    @Test
    public void test2() throws Exception{
        SystemController controller=new SystemController();
        MockMvc mockMvc=standaloneSetup(controller).build();
        mockMvc.perform(get("/add?name=dodod")).andReturn();
    }


    @Test
    public void test3(){
        User a=new User();
        a.setName("zihua");
        a.setPassword("123456");
        a.setId(12345);
        System.out.println(a.getClass().getSimpleName());
    }

    @Test
    public void test4(){
        String s="    ";
        s=s.replaceAll("[ ]+","");
        System.out.println(Integer.valueOf(s));
    }
}
