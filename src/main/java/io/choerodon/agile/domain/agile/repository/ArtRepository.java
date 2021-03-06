package io.choerodon.agile.domain.agile.repository;

import io.choerodon.agile.domain.agile.entity.ArtE;

/**
 * Created by HuangFuqiang@choerodon.io on 2019/3/11.
 * Email: fuqianghuang01@gmail.com
 */
public interface ArtRepository {

    ArtE create(ArtE artE);

    ArtE updateBySelective(ArtE artE);

    void delete(Long id);
}
