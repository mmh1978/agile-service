package io.choerodon.agile.api.dto;

/**
 * Created by HuangFuqiang@choerodon.io on 2018/6/13.
 * Email: fuqianghuang01@gmail.com
 */
public class QuickFilterFiledDTO {

    private Long filedId;

    private String type;

    private String name;

    public void setFiledId(Long filedId) {
        this.filedId = filedId;
    }

    public Long getFiledId() {
        return filedId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
