package com.jiangying.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiangying.pojo.entity.SubjectLabel;
import com.jiangying.service.SubjectLabelService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 题目标签表(SubjectLabel)表控制层
 *
 * @author makejava
 * @since 2024-05-31 16:44:56
 */
@RestController
@RequestMapping("subjectLabel")
public class SubjectLabelController {
    /**
     * 服务对象
     */
    @Resource
    private SubjectLabelService subjectLabelService;

    /**
     * 分页查询
     *
     * @param subjectLabel 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    @GetMapping
//    public ResponseEntity<Page<SubjectLabel>> queryByPage(SubjectLabel subjectLabel, PageRequest pageRequest) {
//        return ResponseEntity.ok(this.subjectLabelService.queryByPage(subjectLabel, pageRequest));
//    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<SubjectLabel> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.subjectLabelService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param subjectLabel 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<SubjectLabel> add(SubjectLabel subjectLabel) {
        return ResponseEntity.ok(this.subjectLabelService.insert(subjectLabel));
    }

    /**
     * 编辑数据
     *
     * @param subjectLabel 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<SubjectLabel> edit(SubjectLabel subjectLabel) {
        return ResponseEntity.ok(this.subjectLabelService.update(subjectLabel));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.subjectLabelService.deleteById(id));
    }

}

