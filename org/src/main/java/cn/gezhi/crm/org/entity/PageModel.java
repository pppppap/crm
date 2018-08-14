package cn.gezhi.crm.org.entity;

import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * 分页模型
 *
 * @author pppppap
 */
public class PageModel<E> implements Serializable {

    private static final long serialVersionUID = 3265524976080127173L;

    private long totalCount; //总记录数

    private int pageSize = 10; //每页显示的数量

    private int totalPage; //总页数

    private int currentPage = 1; //当前页数

    private List<E> list; //分页集合列表

    private String url; //分页跳转的URL

    public PageModel() {
    }

    public PageModel(List<E> list) {
        if (list instanceof Page) {
            Page page = (Page) list;
            this.currentPage = page.getPageNum();
            this.pageSize = page.getPageSize();
            this.totalPage = page.getPages();
            this.totalCount = page.getTotal();
            this.list = page.getResult();
        } else if (list instanceof Collection) {
            this.currentPage = 1;
            this.pageSize = list.size();
            this.totalPage = this.pageSize > 0 ? 1 : 0;
            this.totalCount = list.size();
            this.list = list;
        }
    }

    public PageModel(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount >= 0 ? totalCount : 0;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
