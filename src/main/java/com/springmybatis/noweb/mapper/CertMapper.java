package com.springmybatis.noweb.mapper;


import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.springmybatis.noweb.entiy.Cert;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lxh
 * @since 2018-01-18
 */
@MapperScan
public interface CertMapper extends BaseMapper<Cert> {
	Integer selectCountAvailableNum();
	Integer selectCountAllNum();
	void upToExportedStatus(@Param("batchNumber") String batchNumber,@Param("exportNum") Integer exportNum);
}
