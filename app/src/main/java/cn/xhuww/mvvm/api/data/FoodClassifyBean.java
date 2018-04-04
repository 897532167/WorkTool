package cn.xhuww.mvvm.api.data;

import java.util.List;

/**
 * 作者：xhu_ww on 2018/3/12
 * 用途：食谱类别
 */
public class FoodClassifyBean {


    /**
     * group : 汤粥主食
     * groupId : 1
     * list : [{"childGroup":"饼","childList":["饼"]},{"childGroup":"饭","childList":["饭","焖","饭团","盖浇饭","煲仔饭","焗饭","烩饭"]},{"childGroup":"汤羹","childList":["汤羹"]},{"childGroup":"面","childList":["面","炒面","汤面","凉面","焖面"]}]
     */

    private String group;
    private int groupId;
    private List<ListBean> list;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * childGroup : 饼
         * childList : ["饼"]
         */

        private String childGroup;
        private List<String> childList;

        public String getChildGroup() {
            return childGroup;
        }

        public void setChildGroup(String childGroup) {
            this.childGroup = childGroup;
        }

        public List<String> getChildList() {
            return childList;
        }

        public void setChildList(List<String> childList) {
            this.childList = childList;
        }
    }
}
