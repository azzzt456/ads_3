class MyTestingClass {
    private final int value;

    //initialize the object with a given value
    public MyTestingClass(int value) {
        this.value = value;
    }

    //return the string representation of the value
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}



