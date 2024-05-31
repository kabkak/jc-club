package com.jiangying.service.impl;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiangying.mapper.SubjectCategoryDao;
import com.jiangying.pojo.entity.SubjectCategory;
import com.jiangying.service.SubjectCategoryService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

/**
 * 题目分类(SubjectCategory)表服务实现类
 *
 * @author makejava
 * @since 2024-05-31 16:21:36
 */
@Service("subjectCategoryService")
public class SubjectCategoryServiceImpl implements SubjectCategoryService {
    @Resource
    private SubjectCategoryDao subjectCategoryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubjectCategory queryById(Long id) {
        return this.subjectCategoryDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param subjectCategory 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    @Override
//    public Page<SubjectCategory> queryByPage(SubjectCategory subjectCategory, PageRequest pageRequest) {
//        long total = this.subjectCategoryDao.count(subjectCategory);
//        return new PageImpl<>(this.subjectCategoryDao.queryAllByLimit(subjectCategory, pageRequest), pageRequest, total);
//    }

    /**
     * 新增数据
     *
     * @param subjectCategory 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectCategory insert(SubjectCategory subjectCategory) {
        this.subjectCategoryDao.insert(subjectCategory);
        return subjectCategory;
    }

    /**
     * 修改数据
     *
     * @param subjectCategory 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectCategory update(SubjectCategory subjectCategory) {
        this.subjectCategoryDao.update(subjectCategory);
        return this.queryById(subjectCategory.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.subjectCategoryDao.deleteById(id) > 0;
    }

    @Override
    public List<SubjectCategory> queryByCategoryTypeId(Long categoryType) {
        return this.subjectCategoryDao.queryByCategoryTypeId(categoryType);
    }
}
