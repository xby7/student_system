package com.jxd.student_information.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.student_information.mapper.IMenuMapper;
import com.jxd.student_information.model.Menu;
import com.jxd.student_information.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author ZhouYufei
 * @description
 * @date 2020-10-19 10:22
 */
@Service
public class MenuServiceImpl extends ServiceImpl<IMenuMapper, Menu> implements IMenuService {
    @Autowired
    private IMenuMapper menuMapper;


    /**
     * 查询菜单
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> queryMenuInfo(String userId) {
        //System.out.println("MenuServiceImpl-"+userId);
        //查询出所有菜单
        List<Map<String, Object>> allMenu = menuMapper.queryMenuInfo(userId);
        //根节点
        //System.out.println("MenuServiceImpl-1");
        /*for (Map<String, Object> map : allMenu) {
            System.out.println(map.get("menu_id"));
        }*/
        List<Map<String, Object>> menuList = new ArrayList<>();
        for (Map<String, Object> nav : allMenu) {
            String parent_id = String.valueOf(nav.get("parent_id"));

            //System.out.println("MenuServiceImpl-parent_id:"+parent_id);
            if("0".equals(parent_id)){//父节点是0的，为根节点。
                menuList.add(nav);
            }
        }
	      /* 根据Menu类的order排序 */
	     // Collections.sort(rootMenu, order());

        //为根菜单设置子菜单，getClild是递归调用的
        for (Map<String, Object> nav : menuList) {
	        /* 获取根节点下的所有子节点 使用getChild方法*/
            String menu_id = String.valueOf(nav.get("menu_id"));
            List<Map<String, Object>> childList = getChild(menu_id, allMenu);
//	        nav.setChildren(childList);//给根节点设置子节点
            nav.put("subMenuList", childList);
        }
        //排序
        menuList.sort(new Comparator<Map<String, Object>>() {
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                Integer name1 = Integer.valueOf(o1.get("order_num").toString());//name1是从你list里面拿出来的一个
                Integer name2 = Integer.valueOf(o2.get("order_num").toString()); //name1是从你list里面拿出来的第二个name
                return name2.compareTo(name1);
            }
        });
        return menuList;
    }

    /**
     * 	获取子节点
     * @param menu_id 父节点id
     * @param allMenu 所有菜单列表
     * @return 每个根节点下，所有子菜单列表
     */
    private List<Map<String, Object>> getChild(String menu_id, List<Map<String, Object>> allMenu){
        //子菜单
        List<Map<String, Object>> childList = new ArrayList<>();
        for (Map<String, Object> nav : allMenu) {
            // 遍历所有节点，将所有菜单的父id与传过来的根节点的id比较
            //相等说明：为该根节点的子节点。
            String parent_id = String.valueOf(nav.get("parent_id"));
            if(menu_id.equals(parent_id)){
                childList.add(nav);
            }
        }
        //递归
        for (Map<String, Object> nav : childList) {
            String tempId = String.valueOf(nav.get("menu_id"));
            //nav.setChildren(,getChild(tempId, allMenu));
            nav.put("subMenuList", getChild(tempId, allMenu));
        }
        //Collections.sort(childList,order());//排序
        //如果节点下没有子节点，返回一个空List（递归退出）
        if(childList.size() == 0){
            return new ArrayList<>();
        }
        //排序
        childList.sort(new Comparator<Map<String, Object>>() {
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                Integer name1 = Integer.valueOf(o1.get("order_num").toString());//name1是从你list里面拿出来的一个
                Integer name2 = Integer.valueOf(o2.get("order_num").toString()); //name1是从你list里面拿出来的第二个name
                return name1.compareTo(name2);
            }
        });

        return childList;
    }
}
