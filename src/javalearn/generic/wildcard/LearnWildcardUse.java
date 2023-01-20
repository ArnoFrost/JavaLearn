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
     * 上界通配符
     * 1. 允许指向? 类型以及子类型
     * 2. 禁止存储,因为存储时会有歧义
     * 3. 可以读取,但读取的类型是上界类型
     */
    public void testUpperBoundWildcard() {
        // 1. 允许指向? 类型以及子类型
        List<? extends Human> list1 = humanList;
        List<? extends Human> list2 = maleList;
        // 编译错误 不允许指向超类型
//        List<? extends Human> list3 = speakingList;
//         编译错误 不允许指向超类型
//        List<? extends Human> list4 = swimmingList;
        // 2. 禁止存储,因为存储时会有歧义
//         list1.add(new Human());
//         list1.add(new Parrot());
//         list1.add(new Dolphin());
        // 3. 可以读取,但读取的类型是上界类型
        Human human = list1.get(0);
        Speaking speaking = list2.get(0);
        Human human2 = list2.get(0);
        //运行强转风险 有获取歧义
        Male male = (Male) list2.get(0);
    }


    /**
     * 下界通配符
     * 1. 允许指向? 类型以及父类型
     * 2. 可以存储,但存储的类型是下界类型
     * 3. 可以读取,但读取的类型是Object 因为会有读取歧义
     */
    public void testLowerBoundWildcard() {
        // 1. 允许指向? 类型以及父类型
        List<? super Human> list1 = humanList;
        List<? super Human> list2 = speakingList;
        List<? super Human> list3 = swimmingList;
        // 编译错误 不允许指向子类型
//        List<? super Human> list4 = maleList;
        //2. 可以存储,但存储的类型是下界类型
        list1.add(new Human());
        list2.add(new Male());
        // 编译错误 不允许存储超类型
//        list3.add(new Dolphin());
        //3. 可以读取,但读取的类型是Object
        Object object = list1.get(0);
        //运行强转风险 有读取歧义
        Female female = (Female) list2.get(0);
    }

    /**
     * 通配符
     * 1. 允许指向所有类型 入参和泛型相关的都不能使用
     * 2. 禁止存储因为存储时会有歧义
     * 3. 可以读取,但返回值和泛型相关的都只能用Object接收（只能强转为Object）
     */
    public void testWildcard() {
        // 1. 允许指向所有类型
        List<?> list1 = humanList;
        List<?> list2 = speakingList;
        List<?> list3 = swimmingList;
        List<?> list4 = maleList;
        List<?> list5 = femaleList;
        //2. 禁止存储,因为存储时会有歧义
//        list1.add(new Human());
        //3. 可以读取,但读取的类型是Object
        Object object = list1.get(0);
    }
}
