package com.stq.modelVo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tianqiang.shao on 16-1-15.
 */
public class Page<T>  implements Serializable{

    private static final long serialVersionUID = 1L;
    /**
     * 前端需要返回的数据
     */
    private List<T>  datas;

    /**
     * 总记录数
     */
    private int totalSize;
    /**
     * 总页数
     */
    private int totalnumber;
    /**
     * 每页显示的条数
     */
    private int pageSize;
    /**
     *  当前第几页
     */
    private int currentNum;
    /**
     * 查询起始位置
     */
    private int startPos;
    /**
     * 查询终止位置
     */
    private int endPos;
    private String order;
    private String asc_desc;


    /**
     * 分页对象
     */
    private T obj;
    /**
     * 默认页大小
     */
    public final static int defaultPageSize = 10;

    /**
     * 计算其它属性
     * @param totalSize 总纪录数
     * @param currentNum 当前页
     * @param pageSize 页大小
     */
    public void calculate(int totalSize, int currentNum, int pageSize) {
        if (totalSize < 1) return;
        if (pageSize == 0) return;
        if (currentNum < 1) currentNum = 1;
        this.currentNum = currentNum;
        this.pageSize = pageSize;
        this.totalSize = totalSize;
        if (pageSize > 0) {
            if (totalSize % pageSize > 0){
                this.totalnumber = totalSize / pageSize + 1;
            }else{
                this.totalnumber = totalSize / pageSize;
            }
            if (currentNum > totalnumber) this.currentNum = totalnumber;
            if (this.currentNum < 1) this.currentNum = 1;
            startPos = (this.currentNum - 1) * pageSize;
            //endPos = this.currentNum * pageSize;
            endPos=pageSize;
        } else {
            startPos = 0;
            endPos = this.defaultPageSize;
        }
    }


    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getAsc_desc() {
        return asc_desc;
    }

    public void setAsc_desc(String asc_desc) {
        this.asc_desc = asc_desc;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public int getTotalnumber() {
        return totalnumber;
    }

    public void setTotalnumber(int totalnumber) {
        this.totalnumber = totalnumber;
    }

    public int getPageSize() {
    if(pageSize==0)
        pageSize=20;
       return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentNum() {
        return currentNum;
    }

    public void setCurrentNum(int currentNum) {
        this.currentNum = currentNum;
    }

    public int getStartPos() {
        return startPos;
    }

    public void setStartPos(int startPos) {
        this.startPos = startPos;
    }

    public int getEndPos() {
        return endPos;
    }

    public void setEndPos(int endPos) {
        this.endPos = endPos;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

}
