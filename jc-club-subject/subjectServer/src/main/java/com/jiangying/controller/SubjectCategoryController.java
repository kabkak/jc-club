package com.jiangying.controller;


import com.jiangying.pojo.entity.SubjectCategory;
import com.jiangying.result.Result;
import com.jiangying.service.SubjectCategoryService;

import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 题目分类(SubjectCategory)表控制层
 *
 * @author makejava
 * @since 2024-05-31 16:21:33
 */
@RestController
@RequestMapping("subjectCategory")
public class SubjectCategoryController {
    /**
     * 服务对象
     */
    @Resource
    private SubjectCategoryService subjectCategoryService;

//    /**
//     * 分页查询
//     *
//     * @param subjectCategory 筛选条件
//     * @param pageRequest      分页对象
//     * @return 查询结果
//     */
//    @GetMapping
//    public ResponseEntity<Page<SubjectCategory>> queryByPage(SubjectCategory subjectCategory, PageRequest pageRequest) {
//        return ResponseEntity.ok(this.subjectCategoryService.queryByPage(subjectCategory, pageRequest));
//    }

    /**
     * 通过主键查询单条数据
     *
     * @param categoryType 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public Result<SubjectCategory> queryById(@PathVariable("id") @Validated Long categoryType) {
        if (ObjectUtils.isEmpty(this.subjectCategoryService.queryById(categoryType))) {
            return Result.error("查询失败");
        }
        return Result.success(this.subjectCategoryService.queryById(categoryType));
    }

    /**
     * 查询分类
     *
     * @param categoryType
     * @return
     */
    @PostMapping("/queryPrimaryCategory")
    public Result<List<SubjectCategory>> queryCategoryTypeById(@Validated Long categoryType) {
        List<SubjectCategory> subjectCategory = this.subjectCategoryService.queryByCategoryTypeId(categoryType);
        if (ObjectUtils.isEmpty(subjectCategory)) {
            return Result.error("查询失败");
        }
        return Result.success(subjectCategory);
    }

    /**
     * 新增数据
     *
     * @param subjectCategory 实体
     * @return 新增结果
     */
    @PostMapping
    public Result<SubjectCategory> add(SubjectCategory subjectCategory) {
        return Result.success(this.subjectCategoryService.insert(subjectCategory));
    }

    /**
     * 编辑数据
     *
     * @param subjectCategory 实体
     * @return 编辑结果
     */
    @PutMapping
    public Result<SubjectCategory> edit(SubjectCategory subjectCategory) {
        return Result.success(this.subjectCategoryService.update(subjectCategory));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public Result<Boolean> deleteById(Long id) {
        return Result.success(this.subjectCategoryService.deleteById(id));
    }

}

