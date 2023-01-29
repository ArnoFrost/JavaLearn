/*
 * Copyright (c) 2023.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package javalearn.generic.wildcard;

import javalearn.generic.core.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 学习通配符使用
 * 原则PECS (Producer Extends Consumer Super)
 *
 * @author xuxin14
 * @date 2023/01/20
 */
public class LearnWildcardUse {
    //region level 1
    private List<Swimming> swimmingList = new ArrayList<>();
    private List<Speaking> speakingList = new ArrayList<>();
    //endregion
    //region level 2
    private List<Human> humanList = new ArrayList<>();
    private List<Parrot> parrotList = new ArrayList<>();
    private List<Dolphin> dolphinList = new ArrayList<>();
    //endregion
    //region level 3
    private List<Male> maleList = new ArrayList<>();
    private List<Female> femaleList = new ArrayList<>();
    //endregion

    /**
     * 简单泛型
     */
    private void testGenericNormal() {
        List<Human> testList;

        testList = humanList;
        //1. 禁止指向其他类型
//        testList = maleList;
//        testList = speakingList;

        //2. 允许存储 本身与子类,由于多态造成
        testList.add(new Male());
        //不允许存储超类
//        testList.add(new Object());
        //3. 允许获取,获取为简单泛型约束类型
        Human human = testList.get(0);


    }

    /**
     * 上界通配符
     * 1. 允许指向? 类型以及子类型
     * 2. 禁止存储,因为存储时会有歧义
     * 3. 可以读取,但读取的类型是上界类型
     */
    public void testUpperBoundWildcard() {
        // 1. 允许指向? 类型以及子类型
        List<? extends Human> testList;
        testList = humanList;
        testList = maleList;
        // 编译错误 不允许指向超类型
//        testList = speakingList;
//        testList = swimmingList;
        // 2. 禁止存储,因为存储时会有歧义
        // 歧义点在于不知道 testList 属于哪个具体的多态List 无法确定存储的类型
//        testList.add(new Human());
//        testList.add(new Male());
//        testList.add(new Female());
        // 3. 可以读取,但读取的类型是上界类型
        Human human = testList.get(0);
        Speaking speaking = testList.get(0);
        Swimming swimming = testList.get(0);
        //运行强转风险 有获取歧义 无法确定获取的类型
//        Male male = testList.get(0);
    }


    /**
     * 下界通配符
     * 1. 允许指向? 类型以及父类型
     * 2. 可以存储,但存储的类型是下界类型
     * 3. 可以读取,但读取的类型是Object 因为会有读取歧义
     */
    public void testLowerBoundWildcard() {
        // 1. 允许指向? 类型以及父类型
        List<? super Human> testList;
        testList = humanList;
        testList = speakingList;
        testList = swimmingList;
        // 编译错误 不允许指向子类型
//        testList = maleList;
//        testList = femaleList;
        //2. 可以存储,但存储的类型是下界类型
        testList.add(new Human());
        testList.add(new Male());
        testList.add(new Female());
        // 编译错误 不允许存储超类型
//        testList.add(new Dolphin());
//        testList.add(new Parrot());
        //3. 可以读取,但读取的类型是Object
        Object object = testList.get(0);
        //运行强转风险 有读取歧义 无法确定读取的类型
//        Female female = testList.get(0);
    }

    /**
     * 通配符
     * 1. 允许指向所有类型 入参和泛型相关的都不能使用
     * 2. 禁止存储因为存储时会有歧义
     * 3. 可以读取,但返回值和泛型相关的都只能用Object接收（只能强转为Object）
     */
    public void testWildcard() {
        // 1. 允许指向所有类型
        List<?> testList;
        testList = humanList;
        testList = speakingList;
        testList = swimmingList;
        testList = maleList;
        testList = femaleList;
        //2. 禁止存储,因为存储时会有歧义 歧义点在于不知道 testList 属于哪个具体的多态List 无法确定存储的类型
//        testList.add(new Human());
//        testList.add(new Female());
        //3. 可以读取,但读取的类型是Object
        Object object = testList.get(0);
    }
}
