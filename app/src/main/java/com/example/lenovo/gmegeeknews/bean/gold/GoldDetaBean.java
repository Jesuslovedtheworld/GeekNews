package com.example.lenovo.gmegeeknews.bean.gold;

import java.util.List;

public class GoldDetaBean {

    /**
     * error : false
     * results : [{"_id":"5cb9c6929d21220319b8e316","createdAt":"2019-04-19T13:01:06.608Z","desc":"博客笔记大汇总，包括Java基础及深入知识点，Android技术博客，还有近300多个面试题","publishedAt":"2019-04-19T13:01:48.210Z","source":"web","type":"Android","url":"https://github.com/yangchong211/YCBlogs/blob/master/blog/00.%E5%8D%9A%E5%AE%A2%E5%A4%A7%E6%B1%87%E6%80%BB.md","used":true,"who":"潇湘剑雨"},{"_id":"5c96259a9d21225de6278cd6","createdAt":"2019-03-23T12:24:58.142Z","desc":"一个可切换数据状态的布局，包含了加载布局，空数据布局，错误布局","images":["https://ww1.sinaimg.cn/large/0073sXn7gy1g25pmtf1g3g30k00zkhdt"],"publishedAt":"2019-04-17T01:50:22.760Z","source":"web","type":"Android","url":"https://github.com/F1ReKing/StatusLayout","used":true,"who":"潇湘剑雨"},{"_id":"5ca1e39a9d21225def25413d","createdAt":"2019-04-01T10:10:34.674Z","desc":"关于状态栏方案总结案例，适合于绝大多数的使用场景\u2026\u2026","publishedAt":"2019-04-17T01:49:40.411Z","source":"web","type":"Android","url":"https://github.com/yangchong211/YCStatusBar","used":true,"who":"潇湘剑雨"},{"_id":"5cb3dfdb9d21220322355ecd","createdAt":"2019-04-15T01:35:23.864Z","desc":"Android 9.0中的新功能 - PrecomputedText","publishedAt":"2019-04-16T01:28:58.839Z","source":"web","type":"Android","url":"https://weilu.blog.csdn.net/article/details/89282221","used":true,"who":"潇湘剑雨"},{"_id":"5cac623a9d21220322355ec1","createdAt":"2019-04-09T09:13:30.178Z","desc":"阿里开源新一代混合技术方案 FlutterBoost","publishedAt":"2019-04-09T09:14:09.156Z","source":"web","type":"Android","url":"https://github.com/alibaba/flutter_boost","used":true,"who":"潇湘剑雨"},{"_id":"5caab6489d2122031c18f56d","createdAt":"2019-04-08T02:47:36.321Z","desc":"支持上拉加载更多，下拉刷新，可以自定义头部和底部，使用一个原生recyclerView就可以搞定复杂界面。支持自由切换状态【加载中，加载成功，加载失败，没网络等状态】的控件，可以自定义状态视图View。拓展功能【支持长按拖拽，侧滑删除】，轻量级 。已经用于多个实际项目中，持续更新\u2026\u2026","images":["https://ww1.sinaimg.cn/large/0073sXn7gy1g1w6n01bt6j308c0go74r"],"publishedAt":"2019-04-09T00:53:48.433Z","source":"web","type":"Android","url":"https://github.com/yangchong211/YCRefreshView","used":true,"who":"潇湘剑雨"},{"_id":"5ca2e4f79d21225def25413f","createdAt":"2019-04-02T04:28:39.469Z","desc":"Flutter自定义实现神奇的卡片切换效果","images":["https://ww1.sinaimg.cn/large/0073sXn7gy1g1w6mzbds1g307w0dcnpg"],"publishedAt":"2019-04-07T10:02:03.420Z","source":"web","type":"Android","url":"https://github.com/BakerJQ/Flutter-InfiniteCards","used":true,"who":"潇湘剑雨"},{"_id":"5c9d722d9d21225de6278ce3","createdAt":"2019-03-29T01:17:33.854Z","desc":"Flutter之AndroidStudio版FishRedux模版代码生成插件","images":["https://ww1.sinaimg.cn/large/0073sXn7ly1g1p98sa633g30s00ew7wh"],"publishedAt":"2019-04-02T03:47:40.100Z","source":"web","type":"Android","url":"https://github.com/BakerJQ/FishReduxTemplateForAS","used":true,"who":"lijinshanmx"},{"_id":"5c9de3f79d21225de91ac038","createdAt":"2019-03-29T09:23:03.100Z","desc":"开源免费的IM，功能和UI符合国内习惯，比XMPP具有更适合移动端的协议，可以作为IM组件代替环信、融云、网易云信等云通讯和XMPP","images":["https://ww1.sinaimg.cn/large/0073sXn7ly1g1p98vc7jdj30u01ko43z","https://ww1.sinaimg.cn/large/0073sXn7ly1g1p98vnn4kj30u01kotae","https://ww1.sinaimg.cn/large/0073sXn7ly1g1p98wo75wj30u01kogv0"],"publishedAt":"2019-04-02T03:47:26.884Z","source":"web","type":"Android","url":"https://github.com/wildfirechat/android-chat","used":true,"who":"lijinshanmx"},{"_id":"5bbb01af9d21226111b86f0d","createdAt":"2018-10-08T07:05:19.297Z","desc":"适用于Android的灵活，强大且轻量级的插件框架【爱奇艺】","publishedAt":"2019-03-26T09:36:34.302Z","source":"chrome","type":"Android","url":"https://github.com/iqiyi/Neptune","used":true,"who":"潇湘剑雨"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 5cb9c6929d21220319b8e316
         * createdAt : 2019-04-19T13:01:06.608Z
         * desc : 博客笔记大汇总，包括Java基础及深入知识点，Android技术博客，还有近300多个面试题
         * publishedAt : 2019-04-19T13:01:48.210Z
         * source : web
         * type : Android
         * url : https://github.com/yangchong211/YCBlogs/blob/master/blog/00.%E5%8D%9A%E5%AE%A2%E5%A4%A7%E6%B1%87%E6%80%BB.md
         * used : true
         * who : 潇湘剑雨
         * images : ["https://ww1.sinaimg.cn/large/0073sXn7gy1g25pmtf1g3g30k00zkhdt"]
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;
        private List<String> images;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
