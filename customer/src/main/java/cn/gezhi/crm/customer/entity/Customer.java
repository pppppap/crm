package cn.gezhi.crm.customer.entity;

import java.util.Date;

public class Customer {
    protected Integer id;

    protected String name;

    protected String idcard;

    protected String tel;

    protected Long loan;

    protected Integer bankId;

    protected Long realloan;

    protected String process;

    protected Long common;

    protected String note;

    protected Integer salesmanId;

    protected String attentionLevel;

    protected Integer evaluteId;

    protected String customerLevel;

    protected Date date;

    protected String securityId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public Long getLoan() {
        return loan;
    }

    public void setLoan(Long loan) {
        this.loan = loan;
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public Long getRealloan() {
        return realloan;
    }

    public void setRealloan(Long realloan) {
        this.realloan = realloan;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process == null ? null : process.trim();
    }

    public Long getCommon() {
        return common;
    }

    public void setCommon(Long common) {
        this.common = common;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Integer getSalesmanId() {
        return salesmanId;
    }

    public void setSalesmanId(Integer salesmanId) {
        this.salesmanId = salesmanId;
    }

    public String getAttentionLevel() {
        return attentionLevel;
    }

    public void setAttentionLevel(String attentionLevel) {
        this.attentionLevel = attentionLevel == null ? null : attentionLevel.trim();
    }

    public Integer getEvaluteId() {
        return evaluteId;
    }

    public void setEvaluteId(Integer evaluteId) {
        this.evaluteId = evaluteId;
    }

    public String getCustomerLevel() {
        return customerLevel;
    }

    public void setCustomerLevel(String customerLevel) {
        this.customerLevel = customerLevel == null ? null : customerLevel.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSecurityId() {
        return securityId;
    }

    public void setSecurityId(String securityId) {
        this.securityId = securityId == null ? null : securityId.trim();
    }

    public Customer() {
    }

    public Customer(Integer id, String name, String idcard, String tel, Long loan, Integer bankId, Long realloan, String process, Long common, String note, Integer salesmanId, String attentionLevel, Integer evaluteId, String customerLevel, Date date, String securityId) {
        this.id = id;
        this.name = name;
        this.idcard = idcard;
        this.tel = tel;
        this.loan = loan;
        this.bankId = bankId;
        this.realloan = realloan;
        this.process = process;
        this.common = common;
        this.note = note;
        this.salesmanId = salesmanId;
        this.attentionLevel = attentionLevel;
        this.evaluteId = evaluteId;
        this.customerLevel = customerLevel;
        this.date = date;
        this.securityId = securityId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idcard='" + idcard + '\'' +
                ", tel='" + tel + '\'' +
                ", loan=" + loan +
                ", bankId=" + bankId +
                ", realloan=" + realloan +
                ", process='" + process + '\'' +
                ", common=" + common +
                ", note='" + note + '\'' +
                ", salesmanId=" + salesmanId +
                ", attentionLevel='" + attentionLevel + '\'' +
                ", evaluteId=" + evaluteId +
                ", customerLevel='" + customerLevel + '\'' +
                ", date=" + date +
                ", securityId='" + securityId + '\'' +
                '}';
    }
}