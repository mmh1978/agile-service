package io.choerodon.agile.api.dto;

import java.util.Date;

/**
 * Created by HuangFuqiang@choerodon.io on 2019/3/26.
 * Email: fuqianghuang01@gmail.com
 */
public class PiCreateDTO {

    private Long artId;

    private Date startDate;

    public void setArtId(Long artId) {
        this.artId = artId;
    }

    public Long getArtId() {
        return artId;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStartDate() {
        return startDate;
    }
}
