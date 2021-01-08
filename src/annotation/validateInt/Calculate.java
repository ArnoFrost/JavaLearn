package annotation.validateInt;

public class Calculate {
    public Calculate() {
        this(0, 0, 0, 0);
    }

    public Calculate(int s1, int s2, int s3, int s4) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.s4 = s4;
        //参数校验
        ValidateHandler.getInstance().isValidateField(this);
    }

//    @ValidateInt(maxValue = 10)
//    @Retention(RetentionPolicy.RUNTIME)
//    @interface SumValidate {
//    }
//
//    @ValidateInt(maxValue = 20)
//    @Retention(RetentionPolicy.RUNTIME)
//    @interface MinusValidate {
//    }

    private @ValidateInt(maxValue = 10)
    final
    int s1;
    private @ValidateInt(maxValue = 10)
    final
    int s2;
    private @ValidateInt(maxValue = 20)
    final
    int s3;
    private @ValidateInt(maxValue = 20)
    final
    int s4;


    private int doSum(int s1, int s2) {
        return s1 + s2;
    }

    private int doMinus(int s1, int s2) {
        return s1 - s2;
    }

    public void doCalculate() {
        int sumResult = doSum(s1, s2);
        int minusResult = doMinus(s3, s4);
        System.out.println(hashCode() + ": sumResult = " + sumResult + ",minusResult = " + minusResult);
//
//        //没有超过
//        int result1 = doSum(5, 7);
//        System.out.println("result 1 = " + result1);
//        //超过
//        int result2 = doSum(30, 40);
//        System.out.println("result 2 = " + result2);
//
//        //没有超过
//        int result3 = doMinus(10, 5);
//        System.out.println("result 3 = " + result3);
//
//        //超过
//        int result4 = doMinus(30, 45);
//        System.out.println("result 4 = " + result4);
    }
}