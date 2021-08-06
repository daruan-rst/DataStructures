public class Queue {

    private int size;
    private Item[] queue = new Item[this.size];


    public void enqueue(Item item) {
        int lastIndex = this.size - 1;
        this.queue[lastIndex] = item;
        this.size++;
        Item[] temp = new Item[this.size];
        System.arraycopy(this.queue, 0, temp, 0, this.queue.length);
        this.queue = temp;
    }

    public void dequeue(){
        this.size--;
        Item[] something = new Item[this.size];
        System.arraycopy(this.queue, 1, something, 0, something.length);
        this.queue = something;
    }


    public Item searchByName(String name) {

        int count = 0;
        for (Item item : this.queue) {
            count++;
            if (item.getName().equalsIgnoreCase(name)) {
                System.out.printf("%s was found\n" , name);
                return item;
            }
            else if(count == this.size ) {
                System.out.printf("nothing was found\n");
                break;

            }

        }
        return null;}



    public void printAll() {
        for (Item item : this.queue){
            if (item != null){
                System.out.println(item);
            }
        }
    }


    public Item getItem(int index) {
        return this.queue[index];}



}

