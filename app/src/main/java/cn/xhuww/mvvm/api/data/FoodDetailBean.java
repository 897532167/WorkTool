package cn.xhuww.mvvm.api.data;

import java.util.List;

/**
 * 作者：xhu_ww on 2018/3/13
 * 用途：
 */
public class FoodDetailBean {

    /**
     * showapi_res_error :
     * showapi_res_code : 0
     * showapi_res_body : {"datas":[{"id":"5819e55df2954c15f83d3bbd","type_v3":"创意菜 鸡蛋","type_v2":"菜式 蛋类","des":"生活里真的是创意无限,虽然都是一样的柴米油盐,有些家吃的欢,有些家吃的愁。所以要吃的好，不在于你买了什么，而是你即使用简单的材料也能做出让家人有惊喜的美食。今天这道美食就是这样，简单的食材，只用到了一个鸡蛋和一张海苔就能让你尝到从没吃过的味道，不用加一点调料，不用盐，不用味精！","type_v1":"热门专题 蛋奶豆制品","cpName":"爆浆鸡蛋","smallImg":"http://app2.showapi.com/img/caipuImg3/201611110205/1478801151775155_smallImg.jpg","steps":[{"content":"准备好一张海苔","imgUrl":"http://app2.showapi.com/img/caipuImg3/201611110205/1478801150911864_1.jpg","orderNum":1},{"content":"把海苔放在一制盘子里","imgUrl":"http://app2.showapi.com/img/caipuImg3/201611110205/1478801151018866_2.jpg","orderNum":2},{"content":"准备好一点温水","imgUrl":"http://app2.showapi.com/img/caipuImg3/201611110205/147880115109369_3.jpg","orderNum":3},{"content":"在海苔的四周抹上温水","imgUrl":"http://app2.showapi.com/img/caipuImg3/201611110205/1478801151135287_4.jpg","orderNum":4},{"content":"打入一个鸡蛋","imgUrl":"http://app2.showapi.com/img/caipuImg3/201611110205/1478801151293194_5.jpg","orderNum":5},{"content":"把海苔包起，捏紧","imgUrl":"http://app2.showapi.com/img/caipuImg3/201611110205/1478801151375757_6.jpg","orderNum":6},{"content":"锅里放入适量的油，烧热后放入油炸","imgUrl":"http://app2.showapi.com/img/caipuImg3/201611110205/1478801151439629_7.jpg","orderNum":7},{"content":"炸到外面有点松脆的感觉就可以了","imgUrl":"http://app2.showapi.com/img/caipuImg3/201611110205/1478801151541259_8.jpg","orderNum":8}],"type":"热门专题 蛋奶豆制品 菜式 蛋类 创意菜 鸡蛋","yl":[{"ylName":"鸡蛋","ylUnit":""},{"ylName":"海苔","ylUnit":""}],"tip":"1. 海苔四周抹水是因为放入鸡蛋后可以把海苔包拢，鸡蛋不会流出； 2. 如果有的海苔太薄，建议用两张比较安全； 3. 煎之前油要烧热再放入才会炸的快，大约炸一分钟左右就可以了。 4. 用平底锅也可以少放油，就是把平底锅倾斜一下油就集中到一边了。","largeImg":"http://app2.showapi.com/img/caipuImg3/201611110205/1478801151716465_largeImg.jpg"}],"ret_code":"0","flag":true,"page":1,"remark":"查询成功!","allNum":1,"msg":"查询成功!","allPage":1}
     */

    private String showapi_res_error;
    private int showapi_res_code;
    private ShowapiResBodyBean showapi_res_body;

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public ShowapiResBodyBean getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBodyBean showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public static class ShowapiResBodyBean {
        /**
         * datas : [{"id":"5819e55df2954c15f83d3bbd","type_v3":"创意菜 鸡蛋","type_v2":"菜式 蛋类","des":"生活里真的是创意无限,虽然都是一样的柴米油盐,有些家吃的欢,有些家吃的愁。所以要吃的好，不在于你买了什么，而是你即使用简单的材料也能做出让家人有惊喜的美食。今天这道美食就是这样，简单的食材，只用到了一个鸡蛋和一张海苔就能让你尝到从没吃过的味道，不用加一点调料，不用盐，不用味精！","type_v1":"热门专题 蛋奶豆制品","cpName":"爆浆鸡蛋","smallImg":"http://app2.showapi.com/img/caipuImg3/201611110205/1478801151775155_smallImg.jpg","steps":[{"content":"准备好一张海苔","imgUrl":"http://app2.showapi.com/img/caipuImg3/201611110205/1478801150911864_1.jpg","orderNum":1},{"content":"把海苔放在一制盘子里","imgUrl":"http://app2.showapi.com/img/caipuImg3/201611110205/1478801151018866_2.jpg","orderNum":2},{"content":"准备好一点温水","imgUrl":"http://app2.showapi.com/img/caipuImg3/201611110205/147880115109369_3.jpg","orderNum":3},{"content":"在海苔的四周抹上温水","imgUrl":"http://app2.showapi.com/img/caipuImg3/201611110205/1478801151135287_4.jpg","orderNum":4},{"content":"打入一个鸡蛋","imgUrl":"http://app2.showapi.com/img/caipuImg3/201611110205/1478801151293194_5.jpg","orderNum":5},{"content":"把海苔包起，捏紧","imgUrl":"http://app2.showapi.com/img/caipuImg3/201611110205/1478801151375757_6.jpg","orderNum":6},{"content":"锅里放入适量的油，烧热后放入油炸","imgUrl":"http://app2.showapi.com/img/caipuImg3/201611110205/1478801151439629_7.jpg","orderNum":7},{"content":"炸到外面有点松脆的感觉就可以了","imgUrl":"http://app2.showapi.com/img/caipuImg3/201611110205/1478801151541259_8.jpg","orderNum":8}],"type":"热门专题 蛋奶豆制品 菜式 蛋类 创意菜 鸡蛋","yl":[{"ylName":"鸡蛋","ylUnit":""},{"ylName":"海苔","ylUnit":""}],"tip":"1. 海苔四周抹水是因为放入鸡蛋后可以把海苔包拢，鸡蛋不会流出； 2. 如果有的海苔太薄，建议用两张比较安全； 3. 煎之前油要烧热再放入才会炸的快，大约炸一分钟左右就可以了。 4. 用平底锅也可以少放油，就是把平底锅倾斜一下油就集中到一边了。","largeImg":"http://app2.showapi.com/img/caipuImg3/201611110205/1478801151716465_largeImg.jpg"}]
         * ret_code : 0
         * flag : true
         * page : 1
         * remark : 查询成功!
         * allNum : 1
         * msg : 查询成功!
         * allPage : 1
         */

        private String ret_code;
        private boolean flag;
        private int page;
        private String remark;
        private int allNum;
        private String msg;
        private int allPage;
        private List<DatasBean> datas;

        public String getRet_code() {
            return ret_code;
        }

        public void setRet_code(String ret_code) {
            this.ret_code = ret_code;
        }

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public int getAllNum() {
            return allNum;
        }

        public void setAllNum(int allNum) {
            this.allNum = allNum;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public int getAllPage() {
            return allPage;
        }

        public void setAllPage(int allPage) {
            this.allPage = allPage;
        }

        public List<DatasBean> getDatas() {
            return datas;
        }

        public void setDatas(List<DatasBean> datas) {
            this.datas = datas;
        }

        public static class DatasBean {
            /**
             * id : 5819e55df2954c15f83d3bbd
             * type_v3 : 创意菜 鸡蛋
             * type_v2 : 菜式 蛋类
             * des : 生活里真的是创意无限,虽然都是一样的柴米油盐,有些家吃的欢,有些家吃的愁。所以要吃的好，不在于你买了什么，而是你即使用简单的材料也能做出让家人有惊喜的美食。今天这道美食就是这样，简单的食材，只用到了一个鸡蛋和一张海苔就能让你尝到从没吃过的味道，不用加一点调料，不用盐，不用味精！
             * type_v1 : 热门专题 蛋奶豆制品
             * cpName : 爆浆鸡蛋
             * smallImg : http://app2.showapi.com/img/caipuImg3/201611110205/1478801151775155_smallImg.jpg
             * steps : [{"content":"准备好一张海苔","imgUrl":"http://app2.showapi.com/img/caipuImg3/201611110205/1478801150911864_1.jpg","orderNum":1},{"content":"把海苔放在一制盘子里","imgUrl":"http://app2.showapi.com/img/caipuImg3/201611110205/1478801151018866_2.jpg","orderNum":2},{"content":"准备好一点温水","imgUrl":"http://app2.showapi.com/img/caipuImg3/201611110205/147880115109369_3.jpg","orderNum":3},{"content":"在海苔的四周抹上温水","imgUrl":"http://app2.showapi.com/img/caipuImg3/201611110205/1478801151135287_4.jpg","orderNum":4},{"content":"打入一个鸡蛋","imgUrl":"http://app2.showapi.com/img/caipuImg3/201611110205/1478801151293194_5.jpg","orderNum":5},{"content":"把海苔包起，捏紧","imgUrl":"http://app2.showapi.com/img/caipuImg3/201611110205/1478801151375757_6.jpg","orderNum":6},{"content":"锅里放入适量的油，烧热后放入油炸","imgUrl":"http://app2.showapi.com/img/caipuImg3/201611110205/1478801151439629_7.jpg","orderNum":7},{"content":"炸到外面有点松脆的感觉就可以了","imgUrl":"http://app2.showapi.com/img/caipuImg3/201611110205/1478801151541259_8.jpg","orderNum":8}]
             * type : 热门专题 蛋奶豆制品 菜式 蛋类 创意菜 鸡蛋
             * yl : [{"ylName":"鸡蛋","ylUnit":""},{"ylName":"海苔","ylUnit":""}]
             * tip : 1. 海苔四周抹水是因为放入鸡蛋后可以把海苔包拢，鸡蛋不会流出； 2. 如果有的海苔太薄，建议用两张比较安全； 3. 煎之前油要烧热再放入才会炸的快，大约炸一分钟左右就可以了。 4. 用平底锅也可以少放油，就是把平底锅倾斜一下油就集中到一边了。
             * largeImg : http://app2.showapi.com/img/caipuImg3/201611110205/1478801151716465_largeImg.jpg
             */

            private String id;
            private String type_v3;
            private String type_v2;
            private String des;
            private String type_v1;
            private String cpName;
            private String smallImg;
            private String type;
            private String tip;
            private String largeImg;
            private List<StepsBean> steps;
            private List<YlBean> yl;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getType_v3() {
                return type_v3;
            }

            public void setType_v3(String type_v3) {
                this.type_v3 = type_v3;
            }

            public String getType_v2() {
                return type_v2;
            }

            public void setType_v2(String type_v2) {
                this.type_v2 = type_v2;
            }

            public String getDes() {
                return des;
            }

            public void setDes(String des) {
                this.des = des;
            }

            public String getType_v1() {
                return type_v1;
            }

            public void setType_v1(String type_v1) {
                this.type_v1 = type_v1;
            }

            public String getCpName() {
                return cpName;
            }

            public void setCpName(String cpName) {
                this.cpName = cpName;
            }

            public String getSmallImg() {
                return smallImg;
            }

            public void setSmallImg(String smallImg) {
                this.smallImg = smallImg;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getTip() {
                return tip;
            }

            public void setTip(String tip) {
                this.tip = tip;
            }

            public String getLargeImg() {
                return largeImg;
            }

            public void setLargeImg(String largeImg) {
                this.largeImg = largeImg;
            }

            public List<StepsBean> getSteps() {
                return steps;
            }

            public void setSteps(List<StepsBean> steps) {
                this.steps = steps;
            }

            public List<YlBean> getYl() {
                return yl;
            }

            public void setYl(List<YlBean> yl) {
                this.yl = yl;
            }

            public static class StepsBean {
                /**
                 * content : 准备好一张海苔
                 * imgUrl : http://app2.showapi.com/img/caipuImg3/201611110205/1478801150911864_1.jpg
                 * orderNum : 1
                 */

                private String content;
                private String imgUrl;
                private int orderNum;

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getImgUrl() {
                    return imgUrl;
                }

                public void setImgUrl(String imgUrl) {
                    this.imgUrl = imgUrl;
                }

                public int getOrderNum() {
                    return orderNum;
                }

                public void setOrderNum(int orderNum) {
                    this.orderNum = orderNum;
                }
            }

            public static class YlBean {
                /**
                 * ylName : 鸡蛋
                 * ylUnit :
                 */

                private String ylName;
                private String ylUnit;

                public String getYlName() {
                    return ylName;
                }

                public void setYlName(String ylName) {
                    this.ylName = ylName;
                }

                public String getYlUnit() {
                    return ylUnit;
                }

                public void setYlUnit(String ylUnit) {
                    this.ylUnit = ylUnit;
                }
            }
        }
    }
}
