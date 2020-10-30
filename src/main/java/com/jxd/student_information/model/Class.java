package com.jxd.student_information.model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author xby
 * @since 2020-10-30
 */
@Data
public class Class {

    @TableId
    private Integer classNo;
    private Integer teacherId;

}
