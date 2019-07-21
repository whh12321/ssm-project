package com.how2java.service.impl;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.how2java.mapper.CategoryMapper;
import com.how2java.pojo.Category;
import com.how2java.service.CategoryService;

 
@Service
public class CategoryServiceImpl  implements CategoryService{
    @Autowired
    CategoryMapper categoryMapper;
     
    public List<Category> list(){
        return categoryMapper.list();
    }
    
    public void deleteAll() {
        List<Category> cs = list();
        for (Category c : cs) {
             
            categoryMapper.delete(c.getId());
        }
    }
     
    @Override
    @Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
    public void addTwo() {
         
        Category c1 = new Category();
        c1.setName("短的名字");
        categoryMapper.add(c1);
         
        Category c2 = new Category();
        c2.setName("名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,");
        categoryMapper.add(c2);
    };
 
   
 
}