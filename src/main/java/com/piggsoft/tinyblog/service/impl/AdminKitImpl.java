package com.piggsoft.tinyblog.service.impl;

import com.piggsoft.tinyblog.service.IAdminKit;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author piggsoft
 * @version 1.0
 * @create 2018/1/30
 * @since 1.0
 */
@Service
public class AdminKitImpl implements IAdminKit {

    private Random random = new Random();

    /**
     * 根据一个范围，生成一个随机的整数
     *
     * @param min 最小值（包括）
     * @param max 最大值（包括）
     * @return 随机数
     */
    public int random(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    @Override
    public int random(int max) {
        return random(1, max);
    }

}
