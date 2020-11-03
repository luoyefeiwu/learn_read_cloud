package com.jerry.bookcloud.homepage.service.impl;

import com.github.pagehelper.PageHelper;
import com.jerry.bookcloud.common.cache.RedisExpire;
import com.jerry.bookcloud.common.cache.RedisHomepageKey;
import com.jerry.bookcloud.common.cache.RedisService;
import com.jerry.bookcloud.common.pojo.index.IndexPageConfig;
import com.jerry.bookcloud.common.result.Result;
import com.jerry.bookcloud.common.result.ResultUtil;
import com.jerry.bookcloud.common.utils.CommonUtil;
import com.jerry.bookcloud.homepage.common.config.RedisConfig;
import com.jerry.bookcloud.homepage.dao.IndexPageConfigMapper;
import com.jerry.bookcloud.homepage.service.IndexPageConfigService;
import com.jerry.bookcloud.homepage.vo.IndexPageVO;
import net.bytebuddy.asm.Advice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 精品服务
 */
@Service
public class IndexPageConfigServiceImpl implements IndexPageConfigService {

    private static final Logger logger = LoggerFactory.getLogger(IndexPageConfigServiceImpl.class);

    @Autowired
    private RedisService redisService;
    @Autowired
    private IndexPageConfigMapper indexPageConfigMapper;

    /**
     * 获取精品页VO
     *
     * @param type  页面数量（1.精品，2.男士,3.女士）
     * @param page
     * @param limit
     * @return
     */
    @Override
    public Result getIndexPageByType(Integer type, Integer page, Integer limit) {
        String key = RedisHomepageKey.getHomepageKey(type);
        //精品页 VO列表
        List<IndexPageVO> pageVOS = redisService.getHashListVal(key, page.toString(), IndexPageVO.class);
        if (pageVOS != null) {
            return ResultUtil.success(pageVOS);
        }
        //获得精品页配置
        List<IndexPageConfig> pageConfigs = getIndexPageWithPaging(type, page, limit);
        if (CommonUtil.isEmpty(pageConfigs)) {
            logger.warn("当前页面没有配置项!");
        }

        pageVOS = new ArrayList<>(pageConfigs.size());

        for (int i = 0; i < pageConfigs.size(); i++) {
            IndexPageConfig pageConfig = pageConfigs.get(i);
            IndexPageVO vo = new IndexPageVO();
            BeanUtils.copyProperties(pageConfig, vo);

            //模块是否有效
            boolean okFlag = true;
            switch (pageConfig.getItemType()) {
                case 1:
                    //书单
                    //vo.setBooklist();
                    break;
                case 2:
                    //Banner
                    break;
                default:
                    break;
            }
            //对应的模块值不为空，才进行添加到vo中
            if (okFlag) {
                pageVOS.add(vo);
            }
        }
        if (pageVOS.size() > 0) {
            //缓存精品页
            this.redisService.setHashValExpire(key, page.toString(), pageVOS, RedisExpire.DAY);
        }
        return ResultUtil.success(pageVOS);
    }

    /**
     * 分页获取精品页配置列表
     *
     * @param type
     * @param page
     * @param limit
     * @return
     */
    private List<IndexPageConfig> getIndexPageWithPaging(Integer type, Integer page, Integer limit) {
        if (page <= 0) {
            page = 1;
        }
        PageHelper.startPage(page, limit);
        List<IndexPageConfig> pageWithResult = indexPageConfigMapper.findPageWithResult(type);
        return pageWithResult;
    }

}
