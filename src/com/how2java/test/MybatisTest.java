package com.how2java.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.how2java.mapper.CategoryMapper;
import com.how2java.pojo.Category;
import com.how2java.service.CategoryService;
import com.how2java.util.Page;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {

	/*
	 * @Autowired private CategoryMapper categoryMapper;
	 * 
	 * @Test public void testAdd() {
	 * 
	 * for (int i = 0; i < 100; i++) { Category category=new Category();
	 * category.setName("new Category"); categoryMapper.add(category); } }
	 * 
	 * @Test public void testTotal() { int total=categoryMapper.total();
	 * System.out.println(total); }
	 * 
	 * @Test public void testList() { Page p=new Page(); p.setStart(2);
	 * p.setCount(3); List<Category> ls=categoryMapper.list(p); for(Category cs:ls)
	 * { System.out.println(cs.getName()); } }
	 */
	 @Autowired
	    private CategoryService categoryService;
	 
	    @Test
	    public void testAddTwo() {
	        categoryService.deleteAll();
	        categoryService.addTwo();
	         
	    }
	
}
