package com.springcloud.commoncore.constant;


/**
 * 枚举返回结果信息
 */
public interface ResultMessage {

    public enum TestHttpResult{
        TEST_HTTP_SUCCESS("测试请求成功",200),
        TEST_HTTP_FAIL("测试请求失败",401),
        TEST_HTTP_OBJECT_NULL("对象为空",402);

        private String name;
        private int index;

        //私有一个构造方法,不可被其他外界方法使用或修改
        private TestHttpResult(String name,int index){
            this.index=index;
            this.name=name;
        }

        public static String getName(int index){
            for (TestHttpResult value : TestHttpResult.values()) {
                if (value.getIndex()==index){
                    return value.getName();
                }
            }

            return "index错误";
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

}
