package com.jiangying.service;

import com.jiangying.pojo.entity.SubjectMapping;

import java.util.List;

/**
 * 题目分类关系表(SubjectMapping)表服务接口
 *
 * @author makejava
 * @since 2024-05-31 21:39:07
 */
public interface SubjectMappingService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectMapping queryById(Long id);

    /**
     * 分页查询
     *
     * @param subjectMapping 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    Page<SubjectMapping> queryByPage(SubjectMapping subjectMapping, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param subjectMapping 实例对象
     * @return 实例对象
     */
    SubjectMapping insert(SubjectMapping subjectMapping);

    /**
     * 修改数据
     *
     * @param subjectMapping 实例对象
     * @return 实例对象
     */
    SubjectMapping update(SubjectMapping subjectMapping);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    List<SubjectMapping> queryListByCategoryId(Long id);
}
