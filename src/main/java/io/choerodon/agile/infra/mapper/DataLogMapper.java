package io.choerodon.agile.infra.mapper;

import io.choerodon.agile.api.dto.StatusMapDTO;
import io.choerodon.agile.infra.dataobject.DataLogDO;
import io.choerodon.agile.infra.dataobject.IssueDO;
import io.choerodon.agile.infra.dataobject.IssueStatusDO;
import io.choerodon.mybatis.common.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by HuangFuqiang@choerodon.io on 2018/6/14.
 * Email: fuqianghuang01@gmail.com
 */

public interface DataLogMapper extends BaseMapper<DataLogDO> {

    List selectByIssueId(@Param("projectId") Long projectId,
                         @Param("issueId") Long issueId);

    DataLogDO selectLastWorkLogById(@Param("projectId") Long projectId,
                                    @Param("issueId") Long issueId,
                                    @Param("field") String field);

    /**
     * 批量生成issue是否解决日志
     *
     * @param projectId    projectId
     * @param issueDOS     issueDOS
     * @param userId       userId
     * @param statusMapDTO statusMapDTO
     * @param completed    completed
     */
    void batchCreateStatusLogByIssueDOS(@Param("projectId") Long projectId, @Param("issueDOS") List<IssueDO> issueDOS
            , @Param("userId") Long userId, @Param("statusMapDTO") StatusMapDTO statusMapDTO, @Param("completed") Boolean completed);

    /**
     * 批量生成issue状态变更日志
     *
     * @param projectId projectId
     * @param issueDOS  issueDOS
     * @param userId    userId
     * @param oldStatus oldStatus
     * @param newStatus newStatus
     */
    void batchCreateChangeStatusLogByIssueDOS(@Param("projectId") Long projectId, @Param("issueDOS") List<IssueDO> issueDOS, @Param("userId") Long userId,
                                              @Param("oldStatus") StatusMapDTO oldStatus, @Param("newStatus") StatusMapDTO newStatus);
}
