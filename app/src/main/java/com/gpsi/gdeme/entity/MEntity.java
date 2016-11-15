package com.gpsi.gdeme.entity;

import java.util.List;

/**
 * Created by Administrator on 2016-11-10.
 */
public class MEntity {


    /**
     * pageIndex : 1
     * totalPages : 302
     * pageSize : 2
     * totalRecords : 604
     * dataList : [{"infoId":3622,"title":"老年人食欲差怎么办？","source":"长寿乐园","image":"http://image.sifude.com/image/print/2dd05c6c8a84ceba95da3b8834910462.png","itId":null,"infoType":"长寿乐园","infoTime":null,"checkStatus":1,"checkTime":1478757105000,"opId":5180,"opName":"韩羚","createTime":1478747483000,"recordStatus":0},{"infoId":3621,"title":"女性小便黄是什么造成的？","source":"养生之道","image":"http://image.sifude.com/image/print/a2b34c68bfafaea094b57668e2e2a1b3.png","itId":null,"infoType":"时令直通车","infoTime":null,"checkStatus":1,"checkTime":1478757099000,"opId":5180,"opName":"韩羚","createTime":1478747224000,"recordStatus":0}]
     * havePrePage : false
     * haveNextPage : true
     */

    private ResultBean result;
    /**
     * result : {"pageIndex":1,"totalPages":302,"pageSize":2,"totalRecords":604,"dataList":[{"infoId":3622,"title":"老年人食欲差怎么办？","source":"长寿乐园","image":"http://image.sifude.com/image/print/2dd05c6c8a84ceba95da3b8834910462.png","itId":null,"infoType":"长寿乐园","infoTime":null,"checkStatus":1,"checkTime":1478757105000,"opId":5180,"opName":"韩羚","createTime":1478747483000,"recordStatus":0},{"infoId":3621,"title":"女性小便黄是什么造成的？","source":"养生之道","image":"http://image.sifude.com/image/print/a2b34c68bfafaea094b57668e2e2a1b3.png","itId":null,"infoType":"时令直通车","infoTime":null,"checkStatus":1,"checkTime":1478757099000,"opId":5180,"opName":"韩羚","createTime":1478747224000,"recordStatus":0}],"havePrePage":false,"haveNextPage":true}
     * description : 查询成功
     * status : true
     */

    private String description;
    private boolean status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public static class ResultBean {
        private int pageIndex;
        private int totalPages;
        private int pageSize;
        private int totalRecords;
        private boolean havePrePage;
        private boolean haveNextPage;
        /**
         * infoId : 3622
         * title : 老年人食欲差怎么办？
         * source : 长寿乐园
         * image : http://image.sifude.com/image/print/2dd05c6c8a84ceba95da3b8834910462.png
         * itId : null
         * infoType : 长寿乐园
         * infoTime : null
         * checkStatus : 1
         * checkTime : 1478757105000
         * opId : 5180
         * opName : 韩羚
         * createTime : 1478747483000
         * recordStatus : 0
         */

        private List<DataListBean> dataList;

        public int getPageIndex() {
            return pageIndex;
        }

        public void setPageIndex(int pageIndex) {
            this.pageIndex = pageIndex;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getTotalRecords() {
            return totalRecords;
        }

        public void setTotalRecords(int totalRecords) {
            this.totalRecords = totalRecords;
        }

        public boolean isHavePrePage() {
            return havePrePage;
        }

        public void setHavePrePage(boolean havePrePage) {
            this.havePrePage = havePrePage;
        }

        public boolean isHaveNextPage() {
            return haveNextPage;
        }

        public void setHaveNextPage(boolean haveNextPage) {
            this.haveNextPage = haveNextPage;
        }

        public List<DataListBean> getDataList() {
            return dataList;
        }

        public void setDataList(List<DataListBean> dataList) {
            this.dataList = dataList;
        }

        public static class DataListBean {
            private int infoId;
            private String title;
            private String source;
            private String image;
            private Object itId;
            private String infoType;
            private Object infoTime;
            private int checkStatus;
            private long checkTime;
            private int opId;
            private String opName;
            private long createTime;
            private int recordStatus;

            public int getInfoId() {
                return infoId;
            }

            public void setInfoId(int infoId) {
                this.infoId = infoId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public Object getItId() {
                return itId;
            }

            public void setItId(Object itId) {
                this.itId = itId;
            }

            public String getInfoType() {
                return infoType;
            }

            public void setInfoType(String infoType) {
                this.infoType = infoType;
            }

            public Object getInfoTime() {
                return infoTime;
            }

            public void setInfoTime(Object infoTime) {
                this.infoTime = infoTime;
            }

            public int getCheckStatus() {
                return checkStatus;
            }

            public void setCheckStatus(int checkStatus) {
                this.checkStatus = checkStatus;
            }

            public long getCheckTime() {
                return checkTime;
            }

            public void setCheckTime(long checkTime) {
                this.checkTime = checkTime;
            }

            public int getOpId() {
                return opId;
            }

            public void setOpId(int opId) {
                this.opId = opId;
            }

            public String getOpName() {
                return opName;
            }

            public void setOpName(String opName) {
                this.opName = opName;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public int getRecordStatus() {
                return recordStatus;
            }

            public void setRecordStatus(int recordStatus) {
                this.recordStatus = recordStatus;
            }
        }
    }
}
