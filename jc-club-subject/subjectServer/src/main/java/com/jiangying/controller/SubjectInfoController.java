package com.jiangying.controller;

import com.jiangying.pojo.entity.SubjectInfo;
import com.jiangying.service.SubjectInfoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 题目信息表(SubjectInfo)表控制层
 *
 * @author makejava
 * @since 2024-05-30 11:38:10
 */
@RestController
@RequestMapping("subject")
public class SubjectInfoController {
    /**
     * 服务对象
     */
    @Resource
    private SubjectInfoService subjectInfoService;



    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<SubjectInfo> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.subjectInfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param subjectInfo 实体
     * @return 新增结果
     */
    @PostMapping("/category/add")
    public ResponseEntity<SubjectInfo> add(SubjectInfo subjectInfo) {

        return ResponseEntity.ok(this.subjectInfoService.insert(subjectInfo));
    }

    /**
     * 编辑数据
     *
     * @param subjectInfo 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<SubjectInfo> edit(SubjectInfo subjectInfo) {
        return ResponseEntity.ok(this.subjectInfoService.update(subjectInfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.subjectInfoService.deleteById(id));
    }

}

