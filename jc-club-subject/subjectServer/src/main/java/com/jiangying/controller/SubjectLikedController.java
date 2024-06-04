package com.jiangying.controller;

import com.jiangying.pojo.entity.SubjectLiked;
import com.jiangying.service.SubjectLikedService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 题目点赞表(SubjectLiked)表控制层
 *
 * @author makejava
 * @since 2024-06-02 19:53:48
 */
@RestController
@RequestMapping("subjectLiked")
public class SubjectLikedController {
    /**
     * 服务对象
     */
    @Resource
    private SubjectLikedService subjectLikedService;

    /**
     * 分页查询
     *
     * @param subjectLiked 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    @GetMapping
//    public ResponseEntity<Page<SubjectLiked>> queryByPage(SubjectLiked subjectLiked, PageRequest pageRequest) {
//        return ResponseEntity.ok(this.subjectLikedService.queryByPage(subjectLiked, pageRequest));
//    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<SubjectLiked> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.subjectLikedService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param subjectLiked 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<SubjectLiked> add(SubjectLiked subjectLiked) {
        return ResponseEntity.ok(this.subjectLikedService.insert(subjectLiked));
    }

    /**
     * 编辑数据
     *
     * @param subjectLiked 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<SubjectLiked> edit(SubjectLiked subjectLiked) {
        return ResponseEntity.ok(this.subjectLikedService.update(subjectLiked));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.subjectLikedService.deleteById(id));
    }

}

