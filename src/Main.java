public class Main{
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(2);
        list.add(5);
        list.add(13);
        list.add(15);

        list.forEach(System.out::println);

        System.out.println("\n.............\n");
        System.out.println(String.format("Size: %d", list.size()));
        System.out.println("\n.............\n");
        System.out.println(list.getPreviousByIndex(1));
        System.out.println(list.getByIndex(1));
        System.out.println(list.getNextByIndex(1));
        list.replaceByIndex(1, 100);
        System.out.println(list.getByIndex(1));
    }
}
