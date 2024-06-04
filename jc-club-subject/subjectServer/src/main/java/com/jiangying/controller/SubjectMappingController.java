package com.jiangying.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiangying.pojo.entity.SubjectMapping;
import com.jiangying.service.SubjectMappingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 题目分类关系表(SubjectMapping)表控制层
 *
 * @author makejava
 * @since 2024-05-31 21:39:06
 */
@RestController
@RequestMapping("subjectMapping")
public class SubjectMappingController {
    /**
     * 服务对象
     */
    @Resource
    private SubjectMappingService subjectMappingService;

    /**
     * 分页查询
     *
     * @param subjectMapping 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    @GetMapping
//    public ResponseEntity<Page<SubjectMapping>> queryByPage(SubjectMapping subjectMapping, PageRequest pageRequest) {
//        return ResponseEntity.ok(this.subjectMappingService.queryByPage(subjectMapping, pageRequest));
//    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<SubjectMapping> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.subjectMappingService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param subjectMapping 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<SubjectMapping> add(SubjectMapping subjectMapping) {
        return ResponseEntity.ok(this.subjectMappingService.insert(subjectMapping));
    }

    /**
     * 编辑数据
     *
     * @param subjectMapping 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<SubjectMapping> edit(SubjectMapping subjectMapping) {
        return ResponseEntity.ok(this.subjectMappingService.update(subjectMapping));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.subjectMappingService.deleteById(id));
    }

}

