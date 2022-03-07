package cn.edu.tynu.controller;

import cn.edu.tynu.Send;
import cn.edu.tynu.domain.User;
import cn.edu.tynu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 添加用户
     * @param user
     * @return
     */
    @RequestMapping("/add")
    public String add(User user){
        System.out.println(user);
        userService.addUser(user);
        System.out.println("表现层，添加用户...");
        return "success";
    }

    /**
     * 测试查询所有用户
     * @param model
     * @return
     */
    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("表现层，查询所有用户...");
        //调用service的方法
        List<User> list = userService.findAll();
        for (User user : list) {
            System.out.println(user);
        }
        model.addAttribute("list",list);
        return "list";
    }

    /**
     * 向校企通发送请求
     * @return
     */
    @RequestMapping("/send")
    public String send(){
        //生成当前日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = sdf.format(new Date());
        System.out.println(dateStr);

        String url = "http://yx.ty-ke.com/Home/Monitor/monitor_add";
        //String url = "http://101.43.175.192/index.php";
        String info;

        List<User> list = userService.findAll();
        for (User user : list) {
            info = "mobile=" + user.getMobile() +
                    "&title=36.3" +
                    "&jk_type=健康" +
                    "&wc_type=否" +
                    "&jc_type=否" +
                    "&province=山西省" +
                    "&city=晋中市" +
                    "&district=榆次区" +
                    "&address=山西省晋中市榆次区魏榆路辅路" +
                    "&image_img=&" +
                    "created=%E6%97%A5%E6%9C%9F%EF%BC%9A" + dateStr +
                    "&is_verify=0" +
                    "&similarity_num=0";
            System.out.println(info);
            Send.sendPostUrl(url,info);
        }
        System.out.println("校企通打卡成功.....");
        return "success";
    }
}