package com.how2java.controller;
 
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.pojo.Category;
import com.how2java.service.CategoryService;
import com.how2java.util.Page;
 
//告诉spring mvc这是一个控制器类
@Controller
//@RequestMapping("/*") 表示路径/*会映射到该方法上
@RequestMapping("")
public class CategoryController {
	@ResponseBody
    @RequestMapping("/submitCategory")
    public String submitCategory(@RequestBody Category category) {
        System.out.println("SSM接受到浏览器提交的json，并转换为Category对象:"+category);
        return "ok";
    }
     /*将controller的方法返回的对象通过适当的转换器转换为指定的格式之后，
      * 写入到response对象的body区，通常用来返回JSON数据或者是XML*/
    @ResponseBody
    @RequestMapping("/getOneCategory")
    public String getOneCategory() {
         Category c = new Category();
         c.setId(100);
         c.setName("第100个分类");
         JSONObject json= new JSONObject();
         json.put("category", JSONObject.toJSON(c));
         return json.toJSONString();
    }
    @ResponseBody
    @RequestMapping("/getManyCategory")
    public String getManyCategory() {
        List<Category> cs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Category c = new Category();
            c.setId(i);
            c.setName("分类名称:"+i);
            cs.add(c);
        }
 
        return JSONObject.toJSON(cs).toString();
    }
    
    
    @Autowired
    CategoryService categoryService;
 
    @RequestMapping("listCategory")
    public ModelAndView listCategory(Page page){
     //SpringMVC通过 ModelAndView 对象把模型和视图结合在一起
    	//模型是 cs，视图是cs的内容
        ModelAndView mav = new ModelAndView();
        PageHelper.offsetPage(page.getStart(), 5);
        List<Category> cs= categoryService.list();
        int total = (int)new PageInfo<>(cs).getTotal();
         
        page.calculateLast(total);
         
        // 放入转发参数
        mav.addObject("cs", cs);
        // 放入jsp路径
        mav.setViewName("listCategory");
        return mav;
    }
 
}