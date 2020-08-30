package com.example.demo.service;

import com.example.demo.dao.CategoryDAO;
import com.example.demo.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryDAO categoryDAO;

    public List<Category> list() {
        //springboot2.2.1（含）以上的版本Sort已经不能再实例化了，构造方法已经是私有的了！
//        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return categoryDAO.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public Category get(int id) {
        Category c= categoryDAO.findById(id).orElse(null);
        return c;
    }
}

