package io.choerodon.agile.infra.repository.impl;

import io.choerodon.agile.domain.agile.entity.ArtE;
import io.choerodon.agile.domain.agile.repository.ArtRepository;
import io.choerodon.agile.infra.dataobject.ArtDO;
import io.choerodon.agile.infra.mapper.ArtMapper;
import io.choerodon.core.convertor.ConvertHelper;
import io.choerodon.core.exception.CommonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by HuangFuqiang@choerodon.io on 2019/3/11.
 * Email: fuqianghuang01@gmail.com
 */
@Component
public class ArtRepositoryImpl implements ArtRepository {

    @Autowired
    private ArtMapper artMapper;

    @Override
    public ArtE create(ArtE artE) {
        ArtDO artDO = ConvertHelper.convert(artE, ArtDO.class);
        if (artMapper.insert(artDO) != 1) {
            throw new CommonException("error.art.insert");
        }
        return ConvertHelper.convert(artMapper.selectByPrimaryKey(artDO.getId()), ArtE.class);
    }

    @Override
    public ArtE updateBySelective(ArtE artE) {
        ArtDO artDO = ConvertHelper.convert(artE, ArtDO.class);
        if (artMapper.updateByPrimaryKeySelective(artDO) != 1) {
            throw new CommonException("error.art.update");
        }
        return ConvertHelper.convert(artMapper.selectByPrimaryKey(artDO.getId()), ArtE.class);
    }

    @Override
    public void delete(Long id) {
        ArtDO artDO = artMapper.selectByPrimaryKey(id);
        if (artDO == null) {
            throw new CommonException("error.art.exist");
        }
        if (artMapper.delete(artDO) != 1) {
            throw new CommonException("error.art.delete");
        }
    }
}
