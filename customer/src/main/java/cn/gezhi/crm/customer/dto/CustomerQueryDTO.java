package cn.gezhi.crm.customer.dto;

/**
 * TODO
 *
 * @author pppppap
 */
public class CustomerQueryDTO {

    public int page = 1;

    public int pageSize = 5;

    public String searchType;

    private String name;

    private String idcard;

    private String tel;

    private Integer bankId;

    private Integer salesmanId;

    private Integer evaluteId;

    private String attentionLevel;

    private String customerLevel;

    private String securityId;

    private String process;

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public Integer getSalesmanId() {
        return salesmanId;
    }

    public void setSalesmanId(Integer salesmanId) {
        this.salesmanId = salesmanId;
    }

    public Integer getEvaluteId() {
        return evaluteId;
    }

    public void setEvaluteId(Integer evaluteId) {
        this.evaluteId = evaluteId;
    }

    public String getAttentionLevel() {
        return attentionLevel;
    }

    public void setAttentionLevel(String attentionLevel) {
        this.attentionLevel = attentionLevel;
    }

    public String getCustomerLevel() {
        return customerLevel;
    }

    public void setCustomerLevel(String customerLevel) {
        this.customerLevel = customerLevel;
    }

    public String getSecurityId() {
        return securityId;
    }

    public void setSecurityId(String securityId) {
        this.securityId = securityId;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    @Override
    public String toString() {
        return "CustomerQueryDTO{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                ", name='" + name + '\'' +
                ", idcard='" + idcard + '\'' +
                ", tel='" + tel + '\'' +
                ", bankId=" + bankId +
                ", salesmanId=" + salesmanId +
                ", evaluteId=" + evaluteId +
                ", attentionLevel='" + attentionLevel + '\'' +
                ", customerLevel='" + customerLevel + '\'' +
                ", securityId='" + securityId + '\'' +
                ", process='" + process + '\'' +
                '}';
    }
}
