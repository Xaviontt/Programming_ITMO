public class Potato {
    private static final String potatoName = "potato";
    private static final String potatoType = "common";

    public static String getPotatoName() {
        return potatoName;
    }

    public static String getPotatoType() {
        return potatoType;
    }

    public void isFried(){
        System.out.println("fried " + getPotatoName());
    }

    public void isBoiled(){
        System.out.println("boiled " + getPotatoName());
    }

    public void isCommon(){
        System.out.println("it is " + getPotatoType() + " " + getPotatoName());
    }

    public void growOnTrees(){
        System.out.println(getPotatoName() + "es grow on " + Trees.getTreesName());
    }
}
