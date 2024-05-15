class Overflow {
  static int value = Integer.MAX_VALUE;
  public static void main(String args[]){
    System.out.println("value: " + value);
    value++;
    System.out.println("value2: " + value);
  }
}
