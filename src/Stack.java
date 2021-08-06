public class Stack {

    private int size = 1;
    private Item[] stack = new Item[this.size];


    public void push(Item item) {
        int count = this.size - 1;
        this.stack[count] = item;
        this.size++;
        Item[] temp = new Item[this.size];
        System.arraycopy(this.stack, 0, temp, 0, this.stack.length);
        this.stack = temp;
    }

    public void pop(){
        this.size--;
        int shrink = this.size - 1;
        Item[] somebody = new Item[this.size];
        for (int i = 0; i < somebody.length; i++) {
            if (i != shrink){
                somebody[i] = this.stack[i];
            }
        }
        this.stack = somebody;
    }

    public void search(String nome) {
        boolean notFound = false;
        int count= 0;
        for (Item item : this.stack) {
            count++;
            if (item.getName().equalsIgnoreCase(nome)) {
                System.out.printf("%s was found\n" , nome);
                break;
            }
            else if(count == this.size - 1 ) {
                System.out.printf("nothing was found\n");
                break;
            }
        }
    }

    public void listAll() {
        for (Item item : this.stack){
            if (item != null){
                System.out.println(item);
            }
        }
    }

    public Item getItem(int index) {
        return this.stack[index];}

}
