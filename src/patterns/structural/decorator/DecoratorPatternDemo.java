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

package patterns.structural.decorator;

/**
 * @author ArnoFrost
 * @since 2021/9/14 14:23
 */
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Shape circle = new Circle();
        //通过修饰器来包装原有类 而不是直接使用Shape
        //以此来获得增加的功能
        ShapeDecorator redCircle = new RedShapeDecorator(new Circle());
        ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());
        ShapeDecorator greenCircle = new GreenShapeDecorator(new Circle());
        //Shape redCircle = new RedShapeDecorator(new Circle());
        //Shape redRectangle = new RedShapeDecorator(new Rectangle());
        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();

        System.out.println("\nCircle of green border");
        greenCircle.draw();
    }
}
