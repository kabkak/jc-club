package com.jiangying.service;


import com.jiangying.pojo.entity.SubjectInfo;

/**
 * 题目信息表(SubjectInfo)表服务接口
 *
 * @author makejava
 * @since 2024-05-30 11:38:21
 */
public interface SubjectInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectInfo queryById(Long id);

//    /**
//     * 分页查询
//     *
//     * @param subjectInfo 筛选条件
//     * @param pageRequest      分页对象
//     * @return 查询结果
//     */
//    Page<SubjectInfo> queryByPage(SubjectInfo subjectInfo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param subjectInfo 实例对象
     * @return 实例对象
     */
    SubjectInfo insert(SubjectInfo subjectInfo);

    /**
     * 修改数据
     *
     * @param subjectInfo 实例对象
     * @return 实例对象
     */
    SubjectInfo update(SubjectInfo subjectInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
