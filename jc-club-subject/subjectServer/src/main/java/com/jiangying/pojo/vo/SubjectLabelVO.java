package com.jiangying.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 题目标签表(SubjectLabel)实体类
 *
 * @author makejava
 * @since 2024-05-31 16:44:56
 */
@Data
public class SubjectLabelVO implements Serializable {

/**
     * 主键
     */
    private Long id;
/**
     * 标签分类
     */
    private String labelName;
/**
     * 排序
     */
    private Integer sortNum;

    private String categoryId;


}

