package com.jiangying.service;

import com.jiangying.pojo.entity.SubjectLabel;
import com.jiangying.pojo.vo.SubjectLabelVO;

import java.util.List;


/**
 * 题目标签表(SubjectLabel)表服务接口
 *
 * @author makejava
 * @since 2024-05-31 16:44:56
 */
public interface SubjectLabelService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectLabel queryById(Long id);
    List<SubjectLabelVO> queryByCategoryId(Long categoryId);

    /**
     * 分页查询
     *
     * @param subjectLabel 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    Page<SubjectLabel> queryByPage(SubjectLabel subjectLabel, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param subjectLabel 实例对象
     * @return 实例对象
     */
    SubjectLabel insert(SubjectLabel subjectLabel);

    /**
     * 修改数据
     *
     * @param subjectLabel 实例对象
     * @return 实例对象
     */
    SubjectLabel update(SubjectLabel subjectLabel);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);


    List<SubjectLabelVO> queryByLabelIdList(List labelIdList);

}
