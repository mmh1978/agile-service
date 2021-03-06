package io.choerodon.agile.app.assembler;

import io.choerodon.agile.api.dto.ArtDTO;
import io.choerodon.agile.domain.agile.repository.UserRepository;
import io.choerodon.agile.infra.dataobject.ArtDO;
import io.choerodon.agile.infra.dataobject.UserMessageDO;
import io.choerodon.core.convertor.ConvertHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by HuangFuqiang@choerodon.io on 2019/3/11.
 * Email: fuqianghuang01@gmail.com
 */
@Component
public class ArtAssembler {

    @Autowired
    private UserRepository userRepository;

    public ArtDTO artDOTODTO(ArtDO artDO) {
        ArtDTO artDTO = ConvertHelper.convert(artDO, ArtDTO.class);
        List<Long> rteIds = new ArrayList<>();
        if (artDO.getRteId() != null) {
            rteIds.add(artDO.getRteId());
        }
        if (rteIds.isEmpty()) {
            return artDTO;
        }
        Map<Long, UserMessageDO> userMessageDOMap = userRepository.queryUsersMap(
                rteIds.stream().filter(Objects::nonNull).distinct().collect(Collectors.toList()), true);
        UserMessageDO userMessageDO = userMessageDOMap.get(artDO.getRteId());
        String rteName = userMessageDO != null ? userMessageDO.getLoginName() + userMessageDO.getName() : null;
        artDTO.setRteName(rteName);
        return artDTO;
    }
}
