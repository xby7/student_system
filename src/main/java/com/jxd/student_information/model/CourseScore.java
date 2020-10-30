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
public class CourseScore {

    @TableId
    private Integer scoreId;
    private Integer courseId;
    private Integer studentId;
    private Integer score;

}
