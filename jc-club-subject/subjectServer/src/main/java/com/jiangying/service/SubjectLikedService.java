package com.jiangying.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiangying.pojo.entity.SubjectLiked;

/**
 * 题目点赞表(SubjectLiked)表服务接口
 *
 * @author makejava
 * @since 2024-06-02 19:53:48
 */
public interface SubjectLikedService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectLiked queryById(Long id);

    /**
     * 分页查询
     *
     * @param subjectLiked 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    Page<SubjectLiked> queryByPage(SubjectLiked subjectLiked, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param subjectLiked 实例对象
     * @return 实例对象
     */
    SubjectLiked insert(SubjectLiked subjectLiked);

    /**
     * 修改数据
     *
     * @param subjectLiked 实例对象
     * @return 实例对象
     */
    SubjectLiked update(SubjectLiked subjectLiked);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
