
A small library for doing assertions.

Example
=======

    String foo = "asdf";
    Assert.assertThat(foo).equals("asdf");

    List list = ...;
    Assert.assertThat(list).contains(item);

This is a lot like separate `StringAssert`, `ListAssert`, etc., classes, which I had used before. `Assert.that` is just a hack to move the choosing of an `XxxAssert` class to the compiler based on method overloading instead of the programming typing each one out.

This is somewhat like Hamcrest, but without the Matcher static import methods. Nothing against static import methods, but I like `assertThat` returning the appropriate `StringAsserter`, `ListAsserter`, etc., just based on basic Java method overloading. And this also cannot do `or` type logical, which is just fine with me. I like simple assertions.

Extending
=========

To extend and add your own assertion classes/methods, you should make your own `Assert` class, e.g.:

    package com.yourapp;
    public class Assert extends org.exigencecorp.Assert {
      public static YourStringAsserter assertThat(String string) {
        return new YourStringAsserter(string);
      }
      public static WidgetAsserter assertThat(Widget widget) {
        return new WidgetAsserter(widget);
      }
    }

Then just have:

* `YourStringAsserter` extend `StringAsserter`, and
* `WidgetAsserter` extend `ObjectAsserter<Widget>`

And add your own assertion methods to each class.

