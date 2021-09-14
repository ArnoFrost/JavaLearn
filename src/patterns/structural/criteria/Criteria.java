/*
 * Copyright (c) 2021.
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

package patterns.structural.criteria;

import java.util.List;

/**
 * @author ArnoFrost
 * @since 2021/9/14 12:19
 */
public interface Criteria {
    /**
     * 处理过滤
     *
     * @param persons 人
     * @return 结果
     */
    List<Person> doFilter(List<Person> persons);
}
