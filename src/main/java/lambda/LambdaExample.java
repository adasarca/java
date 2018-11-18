package lambda;

public class LambdaExample {

    public static void main(String[] args) {

        //without lambda expression (anonymous interface implementation)
        MathOperation<Integer> multiplication = new MathOperation<Integer>() {
            @Override
            public Integer calculate(Integer a, Integer b) {
                return a * b;
            }
        };
        System.out.println(multiplication.calculate(10, 13));

        //with type declaration and return statement
        MathOperation<Integer> addition = (Integer a, Integer b) -> { return a + b; };
        System.out.println(addition.calculate(2, 3));

        //without type declaration and return statement
        MathOperation<Integer> subtraction = (a, b) -> a - b;
        System.out.println(subtraction.calculate(10, 3));

        //void
        GreetingService greetingService = name -> System.out.println("Hello " + name);
        greetingService.welcome("world");

        /*
        *
        * Method Reference
        *
        */

        //static method call
        GreetingService greetingService1 = message -> System.out.println(message);
        greetingService1.welcome("Welcome 1");

        //static method reference
        GreetingService greetingService2 = System.out::println;
        greetingService2.welcome("Welcome 2");

        //instance method call to an object of particular type
        StringConverter converter1 = string -> string.toUpperCase();
        System.out.println(converter1.convert("yummy 1"));

        //instance method reference to an object of particular type
        StringConverter converter2 = String::toUpperCase;
        System.out.println(converter2.convert("yummy 2"));

        //instance method call to an existing object
        LambdaExample lambdaExample = new LambdaExample();
        MathOperation<Double> division1 = (a, b) -> lambdaExample.division(a, b);
        System.out.println(division1.calculate(15.0, 3.0));

        //instance method reference for an existing object
        MathOperation<Double> division = lambdaExample::division;
        System.out.println(division.calculate(30.0, 5.0));

        //constructor
        TestFactory testFactory1 = string -> new Test(string);
        Test test1 = testFactory1.create("test 1");
        System.out.println(test1.getString());

        //constructor reference
        TestFactory testFactory2 = Test::new;
        Test test2 = testFactory2.create("test 2");
        System.out.println(test2.getString());
    }

    public Double division(Double a, Double b) {
        return a / b;
    }
}
