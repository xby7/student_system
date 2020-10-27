package com.jxd.emp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.emp.mapper.IBookMapper;
import com.jxd.emp.model.Book;
import com.jxd.emp.service.IBookService;
import org.springframework.stereotype.Service;

/**
 * @ClassName BookServiceImpl
 * @Description TODO
 * @Author xiaBoYang
 * @Date 2020/10/23
 * @Version 1.0
 */
@Service
public class BookServiceImpl extends ServiceImpl<IBookMapper, Book> implements IBookService {
}
