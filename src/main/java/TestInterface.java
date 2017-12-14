public interface TestInterface {
    static TestInterface getInstance(){
        return new TestInterface() {
            @Override
            public String doSomething(String thing) {
                return thing;
            }
        };
    };

    default
    String doSomething(String thing){
        return "";
    }
}
