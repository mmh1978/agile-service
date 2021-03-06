package io.choerodon.agile.domain.agile.converter;


import io.choerodon.agile.api.dto.ActiveSprintDTO;
import io.choerodon.agile.infra.dataobject.SprintDO;
import io.choerodon.core.convertor.ConvertorI;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;


/**
 * Created by HuangFuqiang@choerodon.io on 2018/8/27.
 * Email: fuqianghuang01@gmail.com
 */
@Component
public class ActiveSprintConverter implements ConvertorI<Object, SprintDO, ActiveSprintDTO> {

    @Override
    public ActiveSprintDTO doToDto(SprintDO sprintDO) {
        ActiveSprintDTO activeSprintDTO = new ActiveSprintDTO();
        BeanUtils.copyProperties(sprintDO, activeSprintDTO);
        return activeSprintDTO;
    }
}
