package utility.managers;

public class ResponseCreator {
    private static StringBuilder stringBuilder = new StringBuilder();
    public static void append(String str){
        stringBuilder.append(str);
    }
    public static void appendln(){
        stringBuilder.append("\n");
    }
    public static void appendln(Object str) {
        stringBuilder.append(str + "\n");
    }
    public static String get() {
        String out=stringBuilder.toString();
        return out;
    }
    public static void error(String str){
        stringBuilder.append("\u001B[37m"+"\u001B[31m"+str+"\u001B[31m"+"\u001B[37m");
        appendln();
    }
    public static String getAndClear() {
        String out=stringBuilder.toString();
        stringBuilder.delete(0, stringBuilder.length());
        return out;
    }

    public static void clear() {
        stringBuilder.delete(0, stringBuilder.length());
    }

}
