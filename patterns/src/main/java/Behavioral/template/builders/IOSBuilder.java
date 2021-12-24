package Behavioral.template.builders;

public class IOSBuilder extends Builder {
    @Override
    protected void test() {
        System.out.println("Running IOS tests");
    }

    @Override
    protected void lint() {
        System.out.println("Linting the IOS code");
    }

    @Override
    protected void assemble() {
        System.out.println("Assembling the IOS build");
    }

    @Override
    protected void deploy() {
        System.out.println("Deploying IOS build to server");
    }
}
