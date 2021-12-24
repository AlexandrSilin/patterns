package Behavioral.template;

import Behavioral.template.builders.AndroidBuilder;
import Behavioral.template.builders.Builder;
import Behavioral.template.builders.IOSBuilder;

public class Example {
    public static void main(String[] args) {
        Builder android = new AndroidBuilder();
        Builder ios = new IOSBuilder();
        android.build();
        ios.build();
    }
}
