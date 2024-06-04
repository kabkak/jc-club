package com.jiangying.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiangying.pojo.entity.SubjectRadio;
import com.jiangying.mapper.SubjectRadioDao;
import com.jiangying.service.SubjectRadioService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

/**
 * 单选题信息表(SubjectRadio)表服务实现类
 *
 * @author makejava
 * @since 2024-06-02 19:53:48
 */
@Service("subjectRadioService")
public class SubjectRadioServiceImpl implements SubjectRadioService {
    @Resource
    private SubjectRadioDao subjectRadioDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubjectRadio queryById(Long id) {
        return this.subjectRadioDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param subjectRadio 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    @Override
//    public Page<SubjectRadio> queryByPage(SubjectRadio subjectRadio, PageRequest pageRequest) {
//        long total = this.subjectRadioDao.count(subjectRadio);
//        return new PageImpl<>(this.subjectRadioDao.queryAllByLimit(subjectRadio, pageRequest), pageRequest, total);
//    }

    /**
     * 新增数据
     *
     * @param subjectRadio 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectRadio insert(SubjectRadio subjectRadio) {
        this.subjectRadioDao.insert(subjectRadio);
        return subjectRadio;
    }

    /**
     * 修改数据
     *
     * @param subjectRadio 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectRadio update(SubjectRadio subjectRadio) {
        this.subjectRadioDao.update(subjectRadio);
        return this.queryById(subjectRadio.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.subjectRadioDao.deleteById(id) > 0;
    }
}
