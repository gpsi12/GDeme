package com.gpsi.gdeme.bean;

/**
 * 类描述：
 * Created by Gpsi on 2016-11-28.
 */

public class LoginBean {
    /**
     * childId : 8120
     * head : http://test-sifude-file.img-cn-beijing.aliyuncs.com/null
     * account : GD
     * phone : 15236633096
     * token : 1becf26e-f364-37a6259c-7f4c5f47
     */

    private ResultBean result;
    /**
     * result : {"childId":8120,
     * "head":"http://test-sifude-file.img-cn-beijing.aliyuncs.com/null","
     * account":"GD",
     * "phone":"15236633096",
     * "token":"1becf26e-f364-37a6259c-7f4c5f47"}
     * description : 登录成功
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
        private int childId;
        private String head;
        private String account;
        private String phone;
        private String token;

        public int getChildId() {
            return childId;
        }

        public void setChildId(int childId) {
            this.childId = childId;
        }

        public String getHead() {
            return head;
        }

        public void setHead(String head) {
            this.head = head;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
