package io.choerodon.agile.api.controller.v1;

import io.choerodon.agile.app.service.ReportService;
import io.choerodon.core.iam.InitRoleCode;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by HuangFuqiang@choerodon.io on 2018/11/13.
 * Email: fuqianghuang01@gmail.com
 */
@RestController
@RequestMapping(value = "/v1/fix_data")
public class FixDataController {

    @Autowired
    private ReportService reportService;

    @Permission(level = ResourceLevel.SITE, roles = {InitRoleCode.SITE_ADMINISTRATOR, InitRoleCode.SITE_DEVELOPER})
    @ApiOperation("修复累积流图脏数据")
    @PostMapping(value = "/fix_cumulative_flow_diagram")
    public ResponseEntity fixCumulativeFlowDiagram() {
        reportService.fixCumulativeFlowDiagram();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
