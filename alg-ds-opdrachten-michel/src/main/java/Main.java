import week_two.SingleLL;

class Main {
    public static void main(String[]args){
        SingleLL l = new SingleLL();
        System.out.println(l.getSize());
        l.appendNode("test");
        l.appendNode("test3");
        l.appendNode("test3");
        l.appendNode("test3");
        l.appendNode("test3");
        l.appendNode("test3");
        System.out.println(l.getSize());
        l.insertNode(5, "test 4");
        l.removeNode(4);
        System.out.println(l.getSize());
        l.print();
    }
}
