package com.ray.utils;

import org.junit.jupiter.api.Test;

import java.util.UUID;

public class IDUtil {
    //  让我们的ID是随机值,保证唯一

    public static String getId()
    {
        return UUID.randomUUID().toString().replace("-","");
    }

    @Test
    public void test()
    {
        System.out.println(getId());
    }
}
