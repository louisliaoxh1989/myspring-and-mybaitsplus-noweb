package com.springmybatis.noweb.entiy;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;

/**
 * <p>
 * 
 * </p>
 *
 * @author lxh
 * @since 2018-01-18
 */
public class Cert extends Model<Cert> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * rsa密钥
     */
	private String rsa;
    /**
     * chipID
     */
	private String chipId;
	private String rootKey;
	private String keyId;
	private String eccCrtm;
	private String eccCrtm1;
	private String rsaCa;
    /**
     * psk密钥
     */
	private String psk;
    /**
     * psk明文
     */
	private String pskPlain;
    /**
     * 导出批次号
     */
	private String batchNumber;
    /**
     * key加入时间
     */
	private Date addDate;
    /**
     * 证书生成时间
     */
	private Date genDate;
    /**
     * 导出时间
     */
	private Date exportDate;
    /**
     * 证书状态(0新加入,1 证书已生成,2已请求导出,3用户已下载证书)
     */
	private Integer status;
    /**
     * rpc状态(-1发送失败,0没有,1已发送但还没有接到证书信息,2rpc整个过程已完成)
     */
	private Integer rpcStatus;
	
	private Date rpcDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRsa() {
		return rsa;
	}

	public void setRsa(String rsa) {
		this.rsa = rsa;
	}

	public String getChipId() {
		return chipId;
	}

	public void setChipId(String chipId) {
		this.chipId = chipId;
	}

	public String getRootKey() {
		return rootKey;
	}

	public void setRootKey(String rootKey) {
		this.rootKey = rootKey;
	}

	public String getKeyId() {
		return keyId;
	}

	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}

	public String getEccCrtm() {
		return eccCrtm;
	}

	public void setEccCrtm(String eccCrtm) {
		this.eccCrtm = eccCrtm;
	}

	public String getEccCrtm1() {
		return eccCrtm1;
	}

	public void setEccCrtm1(String eccCrtm1) {
		this.eccCrtm1 = eccCrtm1;
	}

	public String getRsaCa() {
		return rsaCa;
	}

	public void setRsaCa(String rsaCa) {
		this.rsaCa = rsaCa;
	}

	public String getPsk() {
		return psk;
	}

	public void setPsk(String psk) {
		this.psk = psk;
	}

	public String getPskPlain() {
		return pskPlain;
	}

	public void setPskPlain(String pskPlain) {
		this.pskPlain = pskPlain;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public Date getGenDate() {
		return genDate;
	}

	public void setGenDate(Date genDate) {
		this.genDate = genDate;
	}

	public Date getExportDate() {
		return exportDate;
	}

	public void setExportDate(Date exportDate) {
		this.exportDate = exportDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}


	public Integer getRpcStatus() {
		return rpcStatus;
	}

	public void setRpcStatus(Integer rpcStatus) {
		this.rpcStatus = rpcStatus;
	}

	public Date getRpcDate() {
		return rpcDate;
	}

	public void setRpcDate(Date rpcDate) {
		this.rpcDate = rpcDate;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Cert{" +
			"id=" + id +
			", rsa=" + rsa +
			", chipId=" + chipId +
			", rootKey=" + rootKey +
			", keyId=" + keyId +
			", eccCrtm=" + eccCrtm +
			", eccCrtm1=" + eccCrtm1 +
			", rsaCa=" + rsaCa +
			", psk=" + psk +
			", pskPlain=" + pskPlain +
			", batchNumber=" + batchNumber +
			", addDate=" + addDate +
			", genDate=" + genDate +
			", exportDate=" + exportDate +
			", status=" + status +
			", rpcStatus=" + rpcStatus +
			"}";
	}
}
