import java.util.Arrays;

public class newQueue {

    private final int INITIAL_SIZE = 16;
    private int position = 0;
    private Object[] elements;

    public newQueue() {
        elements = new Object[INITIAL_SIZE];
    }

    public void enqueue(Object e){
        ensureCapacity();
        elements[position++] = e;
    }

    public Object dequeue(){
        Object dequeuedObject = elements[0];
        for (int i = 0 ; i <elements.length-1 ; i++){
            elements[i] = elements[i++];
        }
        elements[elements.length-1] = null;
        return dequeuedObject;
    }



    private void ensureCapacity(){
        if (elements.length == position){
            elements = Arrays.copyOf(elements, 2*(position+1));
        }
    }
}
