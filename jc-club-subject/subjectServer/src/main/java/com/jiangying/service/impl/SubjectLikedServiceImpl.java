package com.jiangying.service.impl;

import com.jiangying.pojo.entity.SubjectLiked;
import com.jiangying.mapper.SubjectLikedDao;
import com.jiangying.service.SubjectLikedService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

/**
 * 题目点赞表(SubjectLiked)表服务实现类
 *
 * @author makejava
 * @since 2024-06-02 19:53:48
 */
@Service("subjectLikedService")
public class SubjectLikedServiceImpl implements SubjectLikedService {
    @Resource
    private SubjectLikedDao subjectLikedDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubjectLiked queryById(Long id) {
        return this.subjectLikedDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param subjectLiked 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    @Override
//    public Page<SubjectLiked> queryByPage(SubjectLiked subjectLiked, PageRequest pageRequest) {
//        long total = this.subjectLikedDao.count(subjectLiked);
//        return new PageImpl<>(this.subjectLikedDao.queryAllByLimit(subjectLiked, pageRequest), pageRequest, total);
//    }

    /**
     * 新增数据
     *
     * @param subjectLiked 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectLiked insert(SubjectLiked subjectLiked) {
        this.subjectLikedDao.insert(subjectLiked);
        return subjectLiked;
    }

    /**
     * 修改数据
     *
     * @param subjectLiked 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectLiked update(SubjectLiked subjectLiked) {
        this.subjectLikedDao.update(subjectLiked);
        return this.queryById(subjectLiked.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.subjectLikedDao.deleteById(id) > 0;
    }
}
