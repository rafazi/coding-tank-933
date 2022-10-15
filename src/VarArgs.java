public class VarArgs {
    public static void main(String[] args) {
//        for (String arg : args) {
//            System.out.println(arg);
//        }

        for (int i = 0; i < args.length; i++) {
            System.out.printf("i:%s, args:%s%n", i, args[i]);
        }
        System.out.println(args[args.length-1]);
    }
}
