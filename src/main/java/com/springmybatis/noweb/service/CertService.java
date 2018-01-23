package com.springmybatis.noweb.service;


import javax.annotation.Resource;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.springmybatis.noweb.entiy.Cert;
import com.springmybatis.noweb.mapper.CertMapper;
@Service("CertService")
public class CertService extends ServiceImpl<CertMapper, Cert> {

	@Resource
	private CertMapper certMapper;
	
	
	
	/**
	 * 查询证书可用数量
	 * @return
	 */
	public Integer selectCountAvailableNum() {
		return certMapper.selectCountAvailableNum();
	}
	/**
	 * 查询已生成的证书数量
	 * @return
	 */
	public Integer selectCountAllNum() {
		return certMapper.selectCountAllNum();
	}
	
	/**
	 * 更新证书状态为已请求导出
	 * @param batchNumber 导出的编号
	 * @param exportNum	导出的数量
	 */

	public synchronized void upToExportedStatus(String batchNumber,Integer exportNum) {
		certMapper.upToExportedStatus(batchNumber,exportNum);
	}

}
