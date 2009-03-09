
A small library for doing assertions.

Example
=======

    String foo = "asdf";
    Avow.that(foo).equals("asdf");

    List list = ...;
    Avow.that(list).contains(item);

This is a lot like separate `StringAssert`, `ListAssert`, etc., classes, which I had used before. `Avow.that` is just a hack to move the choosing of an `XxxAssert` class to the compiler based on method overloading instead of the programming typing each one out.

This is somewhat like [Hamcrest][1] (which was integrated into JUnit 4.4), but without the Matcher static import methods. Nothing against static import methods, but I like `that` returning the appropriate `StringAsserter`, `ListAsserter`, etc., just based on basic Java method overloading.

Granted, this approach cannot handle `or` type nested logical statements, but that is just fine with me. I like simple assertions.

[1]: http://code.google.com/p/hamcrest/

Extending
=========

To extend and add your own assertion classes/methods, you should make your own `Avow` class, e.g.:

    package com.yourapp;
    public class Avow extends org.exigencecorp.avow.Avow {
      public static YourStringAsserter that(String string) {
        return new YourStringAsserter(string);
      }
      public static WidgetAsserter that(Widget widget) {
        return new WidgetAsserter(widget);
      }
    }

Then just have:

* `YourStringAsserter` extend `StringAsserter`, and
* `WidgetAsserter` extend `ObjectAsserter<Widget>`

And add your own assertion methods to each class.

Then when using `Avow.that` in your tests, just make sure you import your own `Avow` subclass instead of the base class.

