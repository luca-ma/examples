package a;

enum Metal2 {
COPPER, GOLD, PLATUIN;
Metal2() {
System.out.print("constructor:");
}
static {
System.out.print("static:");
}
public static void main(String args[]) {
System.out.print(Metal2.COPPER + ":");
}
}

