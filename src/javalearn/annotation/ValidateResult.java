/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package javalearn.annotation;

/**
 * @program: demo
 * @description:
 * @author wwh
 * @create: 2019-01-16 14:28
 **/
public class ValidateResult {
    private boolean isValid = true;
    private String message;

    public ValidateResult() {
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.isValid = false;
        this.message = message;
    }

    public boolean isValid() {
        return this.isValid;
    }
}


