package com.jiangying.service.impl;


import com.jiangying.mapper.SubjectCategoryDao;
import com.jiangying.pojo.entity.SubjectCategory;
import com.jiangying.pojo.entity.SubjectLabel;
import com.jiangying.pojo.entity.SubjectMapping;
import com.jiangying.pojo.vo.CategoryAndLabel;
import com.jiangying.pojo.vo.SubjectLabelVO;
import com.jiangying.service.SubjectCategoryService;
import com.jiangying.service.SubjectLabelService;
import com.jiangying.service.SubjectMappingService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;


import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

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
    @Resource
    private SubjectLabelService subjectLabelService;
    @Resource
    private SubjectMappingService subjectMappingService;

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
    public List<SubjectCategory> queryByCategoryTypeId(Integer categoryType) {
        return this.subjectCategoryDao.queryByCategoryTypeId(categoryType);
    }

    @Override
    public List<SubjectCategory> queryCategoryByPrimary(Long parentId, Integer categoryType) {
        return this.subjectCategoryDao.queryCategoryByPrimary(parentId, categoryType);
    }

    @Override
    public List<CategoryAndLabel> queryCategoryAndLabel(Long id) {
        List<SubjectCategory> subjectCategoryList = this.subjectCategoryDao.queryListById(id);
        if (CollectionUtils.isEmpty(subjectCategoryList)) {
            throw new RuntimeException("查询失败");
        }


        List<CategoryAndLabel> result = new LinkedList<>();

        subjectCategoryList.forEach(subjectCategory -> {
            CategoryAndLabel categoryAndLabel = new CategoryAndLabel();
            BeanUtils.copyProperties(subjectCategory, categoryAndLabel);
            List<SubjectMapping> subjectMappingList = subjectMappingService.queryListByCategoryId(subjectCategory.getId());
            List<Long> labelIdList = subjectMappingList.stream()
                    .map(SubjectMapping::getLabelId)
                    .distinct()
                    .collect(Collectors.toList());

            List<SubjectLabelVO> subjectLabelVOList = subjectLabelService.queryByLabelIdList(labelIdList);
            categoryAndLabel.setLabelList(subjectLabelVOList);
            result.add(categoryAndLabel);

        });
        return result;

    }
}
